package org.fabrelab.guokr.web.components.posts;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;

public class ListBlock {
	
	@Property
	@Parameter(required = true, allowNull=false)
	private java.util.List<PostDO> posts;
	
	@Property
	private PostDO post;
}
