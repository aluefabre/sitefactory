package org.fabrelab.guokr.web.components.site;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.service.SiteService;
import org.fabrelab.sitefactory.service.UserService;

public class Header {
	@Property
	@Parameter(required = true, allowNull=false)
	private Long targetSiteId;
	
	@Inject
	private SiteService siteService;

	@Inject
	private UserService userService;
	
	@Inject
	private ComponentResources resources;

	public SiteDO getTargetSite(){
		return siteService.findByPrimaryKey(targetSiteId);
	}
}
