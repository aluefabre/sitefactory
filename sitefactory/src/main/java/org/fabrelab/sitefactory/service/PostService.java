package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.sitefactory.dal.dao.PostDAO;
import org.fabrelab.sitefactory.dal.dao.PostRelationDAO;
import org.fabrelab.sitefactory.dal.dao.impl.PostDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.PostRelationDO;
import org.fabrelab.sitefactory.event.model.DeletePostEvent;
import org.fabrelab.sitefactory.event.model.NewPostEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.util.LongUtils;

public class PostService extends PostDAOImpl {
 
	
	protected PostDAO postDAO;
	protected PostRelationDAO postRelationDAO;
	protected EventService eventService;
	
	
	public void createPost(PostDO post, Long userId) {
		post.setCreatorId(userId);
		post.setModifierId(userId);
		post.setGmtCreate(new Date());
		post.setGmtModify(new Date());
		postDAO.insert(post);
		
		eventService.fireEvent(new NewPostEvent(post.getId()));
	}
		
	public void updatePost(PostDO post, Long operator) throws NoPermissionException{
		if(!LongUtils.equalsAndNotNull(post.getCreatorId(), operator)){
			throw new NoPermissionException();
		}
		post.setModifierId(operator);
		postDAO.update(post);
	}

	public boolean deletePostById(Long operator, Long postId) throws NoPermissionException{
		PostDO post = findByPrimaryKey(postId);
//		if(!LongUtils.equalsAndNotNull(post.getCreatorId(), operator)){
//			throw new NoPermissionException();
//		}
		postDAO.deleteByPrimaryKey(postId);
		eventService.fireEvent(new DeletePostEvent(postId));
		return true;
	}

	public void createPostRelation(PostRelationDO relation, Long userId) {
		relation.setCreatorId(userId);
		relation.setModifierId(userId);
		postRelationDAO.insert(relation);
	}
	
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public void setPostRelationDAO(PostRelationDAO postRelationDAO) {
		this.postRelationDAO = postRelationDAO;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public List<PostRelationDO> findRelationByExample(PostRelationDO relation, Long currentUserId) {
		return postRelationDAO.listByExample(relation);
	}

	public void updateRelation(PostRelationDO relation) {
		postRelationDAO.update(relation);
	}

	public void deleteRelationByExample(PostRelationDO arel, Long currentUserId) {
		postRelationDAO.deleteByExample(arel);
	}
}
