package org.fabrelab.sitefactory.event.handler;

import org.fabrelab.sitefactory.dal.dao.GroupRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.DeleteGroupEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.service.GroupService;

public class GroupEventHandler extends EventHandler {
	
	GroupService groupService;

	GroupRelationDAO groupRelationDAO;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			GroupRelationDO example = new GroupRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			groupRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteGroupEvent){
			DeleteGroupEvent deleteEvent = (DeleteGroupEvent)event;
			GroupRelationDO example = new GroupRelationDO();
			example.setGroupId(deleteEvent.getEntityId());
			groupRelationDAO.deleteByExample(example);
		}

	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void setGroupRelationDAO(GroupRelationDAO groupRelationDAO) {
		this.groupRelationDAO = groupRelationDAO;
	}
	
}
