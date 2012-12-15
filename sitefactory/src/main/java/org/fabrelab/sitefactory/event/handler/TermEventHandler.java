package org.fabrelab.sitefactory.event.handler;

import java.util.List;

import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dao.TermRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.TermDO;
import org.fabrelab.sitefactory.dal.dataobject.TermRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.event.model.DeleteTermEvent;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.event.model.NewTermEvent;
import org.fabrelab.sitefactory.service.TermService;
import org.fabrelab.sitefactory.service.UserService;

public class TermEventHandler extends EventHandler {
	
	TermService termService;

	TermRelationDAO termRelationDAO;
	
	UserService userService;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			TermRelationDO example = new TermRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			termRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteTermEvent){
			DeleteTermEvent deleteEvent = (DeleteTermEvent)event;
			TermRelationDO example = new TermRelationDO();
			example.setTermId(deleteEvent.getEntityId());
			termRelationDAO.deleteByExample(example);
		}

		if(event instanceof NewTermEvent){
			handleNewTermEvent((NewTermEvent)event);
		}
	}

	private void handleNewTermEvent(NewTermEvent event) {
		Long termId = event.getTermId();
		TermDO term = termService.findByPrimaryKey(termId);
		PageInfo page = new PageInfo();
		page.setPageSize(Integer.MAX_VALUE);
		page.setPageStart(0);
		List<UserDO> followers = userService.getFollowMeUsers(term.getCreatorId(), page);
		for(UserDO follower : followers){
			TermRelationDO anu = new TermRelationDO();
			anu.setTermId(termId);
			anu.setRelatedId(follower.getId());
			anu.setRelatedType("User");
			anu.setRelation("FOLLOW");
			termService.createTermRelation(anu, follower.getId());
		}
	}

	public void setTermService(TermService termService) {
		this.termService = termService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTermRelationDAO(TermRelationDAO termRelationDAO) {
		this.termRelationDAO = termRelationDAO;
	}
}
