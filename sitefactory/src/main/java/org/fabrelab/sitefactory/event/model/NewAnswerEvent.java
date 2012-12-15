package org.fabrelab.sitefactory.event.model;


public class NewAnswerEvent extends Event {
	
	Long answerId;
	
	public NewAnswerEvent(Long answerId) {
		this.answerId = answerId;
	}

	public Long getAnswerId() {
		return answerId;
	}

}
