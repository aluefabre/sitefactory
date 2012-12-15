package org.fabrelab.sitefactory.event.model;


public class DeleteAnswerEvent extends DeleteEntityEvent {
	
	public DeleteAnswerEvent(Long answerId) {
		super(answerId, "Answer");
	}
	
}
