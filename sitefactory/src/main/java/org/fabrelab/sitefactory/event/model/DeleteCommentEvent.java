package org.fabrelab.sitefactory.event.model;


public class DeleteCommentEvent extends DeleteEntityEvent {
	
	public DeleteCommentEvent(Long commentId) {
		super(commentId, "Comment");
	}
	
}
