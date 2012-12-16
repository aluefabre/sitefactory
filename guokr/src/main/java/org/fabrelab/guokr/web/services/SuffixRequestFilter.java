package org.fabrelab.guokr.web.services;

import java.io.IOException;

import org.apache.tapestry5.services.DelegatingRequest;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;

public class SuffixRequestFilter implements RequestFilter {
	public boolean service(Request request, Response response, RequestHandler handler) throws IOException {
		String path = request.getPath();
		final String newPath = path.replace(".htm", "");
		request = new DelegatingRequest(request) {
			@Override
			public String getPath() {
				return newPath;
			}
		};
		return handler.service(request, response);
	}
}
