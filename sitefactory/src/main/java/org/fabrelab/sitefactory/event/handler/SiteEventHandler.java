package org.fabrelab.sitefactory.event.handler;

import org.fabrelab.sitefactory.dal.dao.SiteRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.SiteRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.DeleteSiteEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.service.SiteService;

public class SiteEventHandler extends EventHandler {
	
	SiteService siteService;

	SiteRelationDAO siteRelationDAO;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			SiteRelationDO example = new SiteRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			siteRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteSiteEvent){
			DeleteSiteEvent deleteEvent = (DeleteSiteEvent)event;
			SiteRelationDO example = new SiteRelationDO();
			example.setSiteId(deleteEvent.getEntityId());
			siteRelationDAO.deleteByExample(example);
		}

	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	public void setSiteRelationDAO(SiteRelationDAO siteRelationDAO) {
		this.siteRelationDAO = siteRelationDAO;
	}
	
}
