package org.fabrelab.sitefactory.event.handler;

import org.fabrelab.sitefactory.dal.dao.CommentRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.CommentRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteCommentEvent;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.service.CommentService;
import org.fabrelab.sitefactory.service.UserService;

public class CommentEventHandler extends EventHandler {
	
	CommentService commentService;

	CommentRelationDAO commentRelationDAO;
	
	UserService userService;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			CommentRelationDO example = new CommentRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			commentRelationDAO.deleteByExample(example);
		}
		
		if(event instanceof DeleteCommentEvent){
			DeleteCommentEvent deleteEvent = (DeleteCommentEvent)event;
			CommentRelationDO example = new CommentRelationDO();
			example.setCommentId(deleteEvent.getEntityId());
			commentRelationDAO.deleteByExample(example);
		}
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCommentRelationDAO(CommentRelationDAO commentRelationDAO) {
		this.commentRelationDAO = commentRelationDAO;
	}
}
