package org.fabrelab.sitefactory.event.model;


public class NewTermEvent extends Event {
	
	Long termId;
	
	public NewTermEvent(Long termId) {
		this.termId = termId;
	}

	public Long getTermId() {
		return termId;
	}

}
