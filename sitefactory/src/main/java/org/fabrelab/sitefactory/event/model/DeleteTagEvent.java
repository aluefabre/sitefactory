package org.fabrelab.sitefactory.event.model;

public class DeleteTagEvent extends DeleteEntityEvent {
	
	public DeleteTagEvent(Long tagId) {
		super(tagId, "Tag");
	}
	
}