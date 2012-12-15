package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.sitefactory.dal.dao.AnswerDAO;
import org.fabrelab.sitefactory.dal.dao.AnswerRelationDAO;
import org.fabrelab.sitefactory.dal.dao.impl.AnswerDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteAnswerEvent;
import org.fabrelab.sitefactory.event.model.NewAnswerEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.util.LongUtils;

public class AnswerService extends AnswerDAOImpl {
 
	
	protected AnswerDAO answerDAO;
	protected AnswerRelationDAO answerRelationDAO;
	protected EventService eventService;
	
	
	public void createAnswer(AnswerDO answer, Long userId) {
		answer.setCreatorId(userId);
		answer.setModifierId(userId);
		answer.setGmtCreate(new Date());
		answer.setGmtModify(new Date());
		
		answerDAO.insert(answer);
		eventService.fireEvent(new NewAnswerEvent(answer.getId()));
	}
		
	public void updateAnswer(AnswerDO answer, Long operator) throws NoPermissionException{
		if(!LongUtils.equalsAndNotNull(answer.getCreatorId(), operator)){
			throw new NoPermissionException();
		}
		answer.setModifierId(operator);
		answerDAO.update(answer);
	}

	public boolean deleteAnswerById(Long operator, Long answerId) throws NoPermissionException{
		AnswerDO answer = findByPrimaryKey(answerId);
//		if(!LongUtils.equalsAndNotNull(answer.getCreatorId(), operator)){
//			throw new NoPermissionException();
//		}
		answerDAO.deleteByPrimaryKey(answerId);
		eventService.fireEvent(new DeleteAnswerEvent(answerId));
		return true;
	}

	public void createAnswerRelation(AnswerRelationDO relation, Long userId) {
		relation.setCreatorId(userId);
		relation.setModifierId(userId);
		answerRelationDAO.insert(relation);
	}
	
	public void setAnswerDAO(AnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}

	public void setAnswerRelationDAO(AnswerRelationDAO answerRelationDAO) {
		this.answerRelationDAO = answerRelationDAO;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public List<AnswerRelationDO> findRelationByExample(AnswerRelationDO relation, Long currentUserId) {
		return answerRelationDAO.listByExample(relation);
	}

	public void updateRelation(AnswerRelationDO relation) {
		answerRelationDAO.update(relation);
	}

	public void deleteRelationByExample(AnswerRelationDO arel, Long currentUserId) {
		answerRelationDAO.deleteByExample(arel);
	}
}
