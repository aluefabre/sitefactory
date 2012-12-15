package org.fabrelab.sitefactory.event.handler;

import java.util.List;

import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dao.AnswerRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.event.model.DeleteAnswerEvent;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.event.model.NewAnswerEvent;
import org.fabrelab.sitefactory.service.AnswerService;
import org.fabrelab.sitefactory.service.UserService;

public class AnswerEventHandler extends EventHandler {
	
	AnswerService answerService;

	AnswerRelationDAO answerRelationDAO;
	
	UserService userService;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			AnswerRelationDO example = new AnswerRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			answerRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteAnswerEvent){
			DeleteAnswerEvent deleteEvent = (DeleteAnswerEvent)event;
			AnswerRelationDO example = new AnswerRelationDO();
			example.setAnswerId(deleteEvent.getEntityId());
			answerRelationDAO.deleteByExample(example);
		}

		if(event instanceof NewAnswerEvent){
			handleNewAnswerEvent((NewAnswerEvent)event);
		}
	}

	private void handleNewAnswerEvent(NewAnswerEvent event) {
		Long answerId = event.getAnswerId();
		AnswerDO answer = answerService.findByPrimaryKey(answerId);
		PageInfo page = new PageInfo();
		page.setPageSize(Integer.MAX_VALUE);
		page.setPageStart(0);
		List<UserDO> followers = userService.getFollowMeUsers(answer.getCreatorId(), page);
		for(UserDO follower : followers){
			AnswerRelationDO anu = new AnswerRelationDO();
			anu.setAnswerId(answerId);
			anu.setRelatedId(follower.getId());
			anu.setRelatedType("User");
			anu.setRelation("FOLLOW");
			answerService.createAnswerRelation(anu, follower.getId());
		}
	}

	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setAnswerRelationDAO(AnswerRelationDAO answerRelationDAO) {
		this.answerRelationDAO = answerRelationDAO;
	}
}
