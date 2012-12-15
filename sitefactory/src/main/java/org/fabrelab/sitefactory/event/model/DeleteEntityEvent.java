package org.fabrelab.sitefactory.event.model;


public class DeleteEntityEvent extends Event {
	
	Long entityId;
	String entityType;
	
	public DeleteEntityEvent(Long entityId, String entityType) {
		this.entityId = entityId;
		this.entityType = entityType;
	}

	public Long getEntityId() {
		return entityId;
	}

	public String getEntityType() {
		return entityType;
	}

}
