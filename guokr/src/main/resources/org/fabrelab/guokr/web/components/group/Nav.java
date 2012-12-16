package org.fabrelab.guokr.web.components.group;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.UserService;

public class Nav {
	@Property
	@Parameter(required = true, allowNull=false)
	private GroupDO targetGroup;
	
	@Inject
	private GroupService groupService;

	@Inject
	private UserService userService;
	
	@Inject
	private ComponentResources resources;

	
	public String getNavClass() {
		String pageName = resources.getPageName(); 
		String parts[] = pageName.split("/");
		if(parts.length>1){
			return parts[1].toLowerCase();
		}		
		return pageName.toLowerCase();
	}
	
}
