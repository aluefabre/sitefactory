package org.fabrelab.sitefactory.event.model;


public class NewArticleEvent extends Event {
	
	Long articleId;
	
	public NewArticleEvent(Long articleId) {
		this.articleId = articleId;
	}

	public Long getArticleId() {
		return articleId;
	}

}
