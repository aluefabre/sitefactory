package org.fabrelab.guokr.web.services;

import org.apache.tapestry5.Link;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ComponentEventLinkEncoder;
import org.apache.tapestry5.services.PageRenderRequestParameters;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.linktransform.PageRenderLinkTransformer;


public class SuffixLinkTransformer implements PageRenderLinkTransformer {
	
	@Inject
	ComponentEventLinkEncoder componentEventLinkEncoder;
	
	public PageRenderRequestParameters decodePageRenderRequest(Request request) {
		return null;
	}

	public Link transformPageRenderLink(Link defaultLink, PageRenderRequestParameters parameters) {
		String basePath = defaultLink.getBasePath();
		if(!basePath.endsWith("/")){
			basePath = basePath + ".htm";
		}
		return defaultLink.copyWithBasePath(basePath);
	}
}