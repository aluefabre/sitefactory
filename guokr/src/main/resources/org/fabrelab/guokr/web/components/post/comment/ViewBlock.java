package org.fabrelab.guokr.web.components.post.comment;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.CommentDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.CommentService;
import org.fabrelab.sitefactory.service.UserService;

public class ViewBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private CommentDO comment;	
	
	@Inject
	private CommentService commentService;

	@Inject
	private UserService userService;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	public UserDO getCreator(){
		return userService.getUserById(comment.getCreatorId());
	}
	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long commentId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		commentService.deleteCommentById(currentUserId, commentId);
		return null;
	}
}
