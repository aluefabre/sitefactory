package org.fabrelab.sitefactory.event.handler;

import java.util.List;

import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dao.QuestionRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.DeleteQuestionEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.event.model.NewQuestionEvent;
import org.fabrelab.sitefactory.event.model.NewQuestionRelationEvent;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.UserService;

public class QuestionEventHandler extends EventHandler {
	
	QuestionService questionService;

	QuestionRelationDAO questionRelationDAO;
	
	UserService userService;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			QuestionRelationDO example = new QuestionRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			questionRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteQuestionEvent){
			DeleteQuestionEvent deleteEvent = (DeleteQuestionEvent)event;
			QuestionRelationDO example = new QuestionRelationDO();
			example.setQuestionId(deleteEvent.getEntityId());
			questionRelationDAO.deleteByExample(example);
		}

		if(event instanceof NewQuestionEvent){
			handleNewQuestionEvent((NewQuestionEvent)event);
		}
		
		if(event instanceof NewQuestionRelationEvent){
			handleNewQuestionRelationEvent((NewQuestionRelationEvent)event);
		}
	}

	private void handleNewQuestionRelationEvent(NewQuestionRelationEvent event) {
		if("User".equals(event.getRelation().getRelatedType())
				&& RelationConstants.FOLLOW.equals(event.getRelation().getRelation())){
			// increase follow count;
		}
		if("Answer".equals(event.getRelation().getRelatedType())
				&& RelationConstants.REGULAR.equals(event.getRelation().getRelation())){
			// increase answer count;
		}
	}

	private void handleNewQuestionEvent(NewQuestionEvent event) {
		Long questionId = event.getQuestionId();
		QuestionDO question = questionService.findByPrimaryKey(questionId);
		PageInfo page = new PageInfo();
		page.setPageSize(Integer.MAX_VALUE);
		page.setPageStart(0);
		List<UserDO> followers = userService.getFollowMeUsers(question.getCreatorId(), page);
		for(UserDO follower : followers){
			QuestionRelationDO anu = new QuestionRelationDO();
			anu.setQuestionId(questionId);
			anu.setRelatedId(follower.getId());
			anu.setRelatedType("User");
			anu.setRelation("FOLLOW");
			questionService.createQuestionRelation(anu, follower.getId());
		}
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setQuestionRelationDAO(QuestionRelationDAO questionRelationDAO) {
		this.questionRelationDAO = questionRelationDAO;
	}
}
