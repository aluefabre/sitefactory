package org.fabrelab.sitefactory.service;

import java.util.Date;

import org.fabrelab.sitefactory.dal.dao.CommentRelationDAO;
import org.fabrelab.sitefactory.dal.dao.impl.CommentDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.CommentDO;
import org.fabrelab.sitefactory.dal.dataobject.CommentRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteArticleEvent;
import org.fabrelab.sitefactory.event.model.DeleteCommentEvent;
import org.fabrelab.sitefactory.event.service.EventService;

public class CommentService  extends CommentDAOImpl {

	CommentRelationDAO commentRelationDAO;
	
	protected EventService eventService;
	
	public void createComment(CommentDO comment, Long currentUserId) {
		comment.setCreatorId(currentUserId);
		comment.setModifierId(currentUserId);
		comment.setGmtCreate(new Date());
		comment.setGmtModify(new Date());
		insert(comment);
	}

	public void createCommentRelation(Long currentUserId, CommentRelationDO grel) {
		grel.setCreatorId(currentUserId);
		grel.setModifierId(currentUserId);
		grel.setGmtCreate(new Date());
		grel.setGmtModify(new Date());
		commentRelationDAO.insert(grel);
	}

	public void setCommentRelationDAO(CommentRelationDAO commentRelationDAO) {
		this.commentRelationDAO = commentRelationDAO;
	}

	public void deleteCommentById(Long currentUserId, Long commentId) {
		deleteByPrimaryKey(commentId);
		eventService.fireEvent(new DeleteCommentEvent(commentId));
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

}
