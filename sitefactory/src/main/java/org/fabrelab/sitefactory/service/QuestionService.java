package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.sitefactory.dal.dao.QuestionDAO;
import org.fabrelab.sitefactory.dal.dao.QuestionRelationDAO;
import org.fabrelab.sitefactory.dal.dao.impl.QuestionDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteQuestionEvent;
import org.fabrelab.sitefactory.event.model.NewQuestionEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.util.LongUtils;

public class QuestionService extends QuestionDAOImpl {
 
	
	protected QuestionDAO questionDAO;
	protected QuestionRelationDAO questionRelationDAO;
	protected EventService eventService;
	
	
	public void createQuestion(QuestionDO question, Long userId) {
		question.setCreatorId(userId);
		question.setModifierId(userId);
		question.setGmtCreate(new Date());
		question.setGmtModify(new Date());
		questionDAO.insert(question);
		
		eventService.fireEvent(new NewQuestionEvent(question.getId()));
	}
		
	public void updateQuestion(QuestionDO question, Long operator) throws NoPermissionException{
		if(!LongUtils.equalsAndNotNull(question.getCreatorId(), operator)){
			throw new NoPermissionException();
		}
		question.setModifierId(operator);
		questionDAO.update(question);
	}

	public boolean deleteQuestionById(Long operator, Long questionId) throws NoPermissionException{
		QuestionDO question = findByPrimaryKey(questionId);
//		if(!LongUtils.equalsAndNotNull(question.getCreatorId(), operator)){
//			throw new NoPermissionException();
//		}
		questionDAO.deleteByPrimaryKey(questionId);
		eventService.fireEvent(new DeleteQuestionEvent(questionId));
		return true;
	}

	public void createQuestionRelation(QuestionRelationDO relation, Long userId) {
		relation.setCreatorId(userId);
		relation.setModifierId(userId);
		questionRelationDAO.insert(relation);
	}
	
	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	public void setQuestionRelationDAO(QuestionRelationDAO questionRelationDAO) {
		this.questionRelationDAO = questionRelationDAO;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public List<QuestionRelationDO> findRelationByExample(QuestionRelationDO relation, Long currentUserId) {
		return questionRelationDAO.listByExample(relation);
	}

	public void updateRelation(QuestionRelationDO relation) {
		questionRelationDAO.update(relation);
	}

	public void deleteRelationByExample(QuestionRelationDO arel, Long currentUserId) {
		questionRelationDAO.deleteByExample(arel);
	}
}
