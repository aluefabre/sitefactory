package org.fabrelab.guokr.web.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.guokr.web.services.MyCookieManager;

/**
 * Start page of application newapp.
 */
public class Logout {
	
	@Inject 
	private MyCookieManager cookieManager;
	private Class onActivate() {
		cookieManager.setCurrentUserId(null);
		return Index.class;
	}
}
