package org.fabrelab.guokr.web.components.ask;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.service.UserService;

public class Nav {
	@Inject
	private ComponentResources resources;

	@Inject 
	private UserService userService;
	
	public String getNavClass() {
		String pageName = resources.getPageName(); 
		String parts[] = pageName.split("/");
		if(parts.length>1){
			return parts[1].toLowerCase();
		}		
		return pageName.toLowerCase();
	}

}
