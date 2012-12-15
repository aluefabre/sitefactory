package org.fabrelab.sitefactory.event.handler;

import org.fabrelab.sitefactory.dal.dao.TagRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.TagRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.DeleteTagEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.service.TagService;

public class TagEventHandler extends EventHandler {
	
	TagService tagService;

	TagRelationDAO tagRelationDAO;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			TagRelationDO example = new TagRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			tagRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteTagEvent){
			DeleteTagEvent deleteEvent = (DeleteTagEvent)event;
			TagRelationDO example = new TagRelationDO();
			example.setTagId(deleteEvent.getEntityId());
			tagRelationDAO.deleteByExample(example);
		}

	}

	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	public void setTagRelationDAO(TagRelationDAO tagRelationDAO) {
		this.tagRelationDAO = tagRelationDAO;
	}

}
