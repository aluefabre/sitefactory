package org.fabrelab.guokr.web.components.site;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;

public class OpSidebar {

	@Property
	@Parameter(required = true, allowNull=false)
	private SiteDO targetSite;
}
