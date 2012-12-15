package org.fabrelab.sitefactory.event.model;


public class NewPostEvent extends Event {
	
	Long postId;
	
	public NewPostEvent(Long postId) {
		this.postId = postId;
	}

	public Long getPostId() {
		return postId;
	}

}
