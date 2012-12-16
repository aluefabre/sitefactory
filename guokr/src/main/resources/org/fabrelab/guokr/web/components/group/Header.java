package org.fabrelab.guokr.web.components.group;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.UserService;

public class Header {
	@Property
	@Parameter(required = true, allowNull=false)
	private GroupDO targetGroup;
	
	@Inject
	private GroupService groupService;

	@Inject
	private UserService userService;
	
	@Inject
	private ComponentResources resources;

}
