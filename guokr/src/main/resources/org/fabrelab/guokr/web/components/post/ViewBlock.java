package org.fabrelab.guokr.web.components.post;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.PostService;

public class ViewBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private PostDO post;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Inject
	private PostService postService;

	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long postId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		postService.deletePostById(currentUserId, postId);
		return null;
	}
}
