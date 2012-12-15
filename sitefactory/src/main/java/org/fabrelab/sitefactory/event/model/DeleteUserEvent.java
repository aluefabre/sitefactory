package org.fabrelab.sitefactory.event.model;


public class DeleteUserEvent extends DeleteEntityEvent {
	
	public DeleteUserEvent(Long articleId) {
		super(articleId, "User");
	}
	
}
