package org.fabrelab.guokr.web.components.articles;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;

public class ListBlock {
	
	@Property
	@Parameter(required = true, allowNull=false)
	private java.util.List<ArticleDO> articles;
	
	@Property
	private ArticleDO article;
}
