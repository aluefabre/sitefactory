package org.fabrelab.sitefactory.event.model;


public class DeleteQuestionEvent extends DeleteEntityEvent {
	
	public DeleteQuestionEvent(Long questionId) {
		super(questionId, "Question");
	}
	
}
