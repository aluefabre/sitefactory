package org.fabrelab.sitefactory.event.model;


public class DeleteArticleEvent extends DeleteEntityEvent {
	
	public DeleteArticleEvent(Long articleId) {
		super(articleId, "Article");
	}
	
}
