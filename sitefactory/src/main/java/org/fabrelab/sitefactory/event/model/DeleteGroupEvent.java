package org.fabrelab.sitefactory.event.model;

public class DeleteGroupEvent extends DeleteEntityEvent {
	
	public DeleteGroupEvent(Long groupId) {
		super(groupId, "Group");
	}
	
}
