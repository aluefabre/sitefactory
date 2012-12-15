package org.fabrelab.sitefactory.event.model;


public class DeleteTermEvent extends DeleteEntityEvent {
	
	public DeleteTermEvent(Long termId) {
		super(termId, "Term");
	}
	
}
