package org.fabrelab.sitefactory.event.model;


public class NewQuestionEvent extends Event {
	
	Long questionId;
	
	public NewQuestionEvent(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestionId() {
		return questionId;
	}

}
