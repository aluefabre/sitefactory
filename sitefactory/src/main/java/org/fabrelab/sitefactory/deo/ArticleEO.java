package org.fabrelab.sitefactory.deo;

import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;

public class ArticleEO extends ArticleDO {
	
	String content;

	public String getContent() {
		return content;
	}

	public void setContent(String text) {
		this.content = text;
	}
	
	
}
