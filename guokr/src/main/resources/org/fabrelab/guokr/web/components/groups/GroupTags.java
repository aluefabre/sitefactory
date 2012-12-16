package org.fabrelab.guokr.web.components.groups;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.TagDO;
import org.fabrelab.sitefactory.service.TagService;

public class GroupTags {
	@Inject
	private ComponentResources resources;

	@Inject
	private TagService tagService;

	@Property
	private TagDO tag;
	
	public java.util.List<TagDO> getTags(){
		TagDO example = new TagDO();
		example.setType("TAG_FOR_GROUP");
		return tagService.listTagByExample(example);
	}
}
