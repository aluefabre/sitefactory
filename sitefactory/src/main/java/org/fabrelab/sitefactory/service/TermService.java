package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.sitefactory.dal.dao.TermDAO;
import org.fabrelab.sitefactory.dal.dao.TermRelationDAO;
import org.fabrelab.sitefactory.dal.dao.impl.TermDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.TermDO;
import org.fabrelab.sitefactory.dal.dataobject.TermRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteTermEvent;
import org.fabrelab.sitefactory.event.model.NewTermEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.util.LongUtils;

public class TermService extends TermDAOImpl {
 
	
	protected TermDAO termDAO;
	protected TermRelationDAO termRelationDAO;
	protected EventService eventService;
	
	
	public void createTerm(TermDO term, Long userId) {
		term.setCreatorId(userId);
		term.setModifierId(userId);
		term.setGmtCreate(new Date());
		term.setGmtModify(new Date());
		termDAO.insert(term);
		
		eventService.fireEvent(new NewTermEvent(term.getId()));
	}
		
	public void updateTerm(TermDO term, Long operator) throws NoPermissionException{
		if(!LongUtils.equalsAndNotNull(term.getCreatorId(), operator)){
			throw new NoPermissionException();
		}
		term.setModifierId(operator);
		termDAO.update(term);
	}

	public boolean deleteTermById(Long operator, Long termId) throws NoPermissionException{
		TermDO term = findByPrimaryKey(termId);
//		if(!LongUtils.equalsAndNotNull(term.getCreatorId(), operator)){
//			throw new NoPermissionException();
//		}
		termDAO.deleteByPrimaryKey(termId);
		eventService.fireEvent(new DeleteTermEvent(termId));
		return true;
	}

	public void createTermRelation(TermRelationDO relation, Long userId) {
		relation.setCreatorId(userId);
		relation.setModifierId(userId);
		termRelationDAO.insert(relation);
	}
	
	public void setTermDAO(TermDAO termDAO) {
		this.termDAO = termDAO;
	}

	public void setTermRelationDAO(TermRelationDAO termRelationDAO) {
		this.termRelationDAO = termRelationDAO;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public List<TermRelationDO> findRelationByExample(TermRelationDO relation, Long currentUserId) {
		return termRelationDAO.listByExample(relation);
	}

	public void updateRelation(TermRelationDO relation) {
		termRelationDAO.update(relation);
	}

	public void deleteRelationByExample(TermRelationDO arel, Long currentUserId) {
		termRelationDAO.deleteByExample(arel);
	}
}
