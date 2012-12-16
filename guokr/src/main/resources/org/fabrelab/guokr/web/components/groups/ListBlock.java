package org.fabrelab.guokr.web.components.groups;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;

public class ListBlock {
	
	@Property
	@Parameter(required = true, allowNull=false)
	private java.util.List<GroupDO> groups;
	
	@Property
	private GroupDO group;
}
