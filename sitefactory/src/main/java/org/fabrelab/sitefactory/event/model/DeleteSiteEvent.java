package org.fabrelab.sitefactory.event.model;

public class DeleteSiteEvent extends DeleteEntityEvent {
	
	public DeleteSiteEvent(Long siteId) {
		super(siteId, "Site");
	}
	
}
