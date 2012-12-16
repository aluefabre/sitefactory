package org.fabrelab.guokr.web.services;

import java.io.IOException;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;

public class UserFilter implements RequestFilter {
	@Inject
	private MyCookieManager cookieManager;
	
	public boolean service(Request request, Response response, RequestHandler handler) throws IOException {
		cookieManager.initCurrentUser();
		boolean result = false;
		try {
			result = handler.service(request, response);
		} catch (Exception e) {
			throw new IOException(e);
		} finally{
			cookieManager.cleanCurrentUser();
		}
		return result;
	}
}
