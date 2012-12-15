package org.fabrelab.sitefactory.event.model;


public class DeletePostEvent extends DeleteEntityEvent {
	
	public DeletePostEvent(Long postId) {
		super(postId, "Post");
	}
	
}
