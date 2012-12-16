package org.fabrelab.guokr.web.components.site;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.service.SiteService;
import org.fabrelab.sitefactory.service.UserService;

public class Nav {
	@Property
	@Parameter(required = true, allowNull=false)
	private Long targetSiteId;
	
	@Inject
	private SiteService siteService;

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
	
	public SiteDO getTargetSite(){
		return siteService.findByPrimaryKey(targetSiteId);
	}
}
