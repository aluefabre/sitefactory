package org.fabrelab.sitefactory.event.handler;

import org.fabrelab.sitefactory.dal.dao.UserRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.UserRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.DeleteUserEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.service.UserService;

public class UserEventHandler extends EventHandler {
	
	UserService userService;

	UserRelationDAO userRelationDAO;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			UserRelationDO example = new UserRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			userRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteUserEvent){
			DeleteUserEvent deleteEvent = (DeleteUserEvent)event;
			UserRelationDO example = new UserRelationDO();
			example.setUserId(deleteEvent.getEntityId());
			userRelationDAO.deleteByExample(example);
		}

	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUserRelationDAO(UserRelationDAO userRelationDAO) {
		this.userRelationDAO = userRelationDAO;
	}

}
