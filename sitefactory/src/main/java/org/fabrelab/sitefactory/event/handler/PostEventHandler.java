package org.fabrelab.sitefactory.event.handler;

import java.util.List;

import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dao.PostRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.PostRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.event.model.DeletePostEvent;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.event.model.NewPostEvent;
import org.fabrelab.sitefactory.service.PostService;
import org.fabrelab.sitefactory.service.UserService;

public class PostEventHandler extends EventHandler {
	
	PostService postService;

	PostRelationDAO postRelationDAO;
	
	UserService userService;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			PostRelationDO example = new PostRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			postRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeletePostEvent){
			DeletePostEvent deleteEvent = (DeletePostEvent)event;
			PostRelationDO example = new PostRelationDO();
			example.setPostId(deleteEvent.getEntityId());
			postRelationDAO.deleteByExample(example);
		}

		if(event instanceof NewPostEvent){
			handleNewPostEvent((NewPostEvent)event);
		}
	}

	private void handleNewPostEvent(NewPostEvent event) {
		Long postId = event.getPostId();
		PostDO post = postService.findByPrimaryKey(postId);
		PageInfo page = new PageInfo();
		page.setPageSize(Integer.MAX_VALUE);
		page.setPageStart(0);
		List<UserDO> followers = userService.getFollowMeUsers(post.getCreatorId(), page);
		for(UserDO follower : followers){
			PostRelationDO anu = new PostRelationDO();
			anu.setPostId(postId);
			anu.setRelatedId(follower.getId());
			anu.setRelatedType("User");
			anu.setRelation("FOLLOW");
			postService.createPostRelation(anu, follower.getId());
		}
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPostRelationDAO(PostRelationDAO postRelationDAO) {
		this.postRelationDAO = postRelationDAO;
	}
}
