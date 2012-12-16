package org.fabrelab.guokr.web.components.group;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;

public class OpSidebar {

	@Property
	@Parameter(required = true, allowNull=false)
	private GroupDO targetGroup;
}
