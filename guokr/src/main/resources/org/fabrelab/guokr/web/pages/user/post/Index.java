package org.fabrelab.guokr.web.pages.user.post;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.PostService;
import org.fabrelab.sitefactory.service.UserService;
import org.fabrelab.sitefactory.util.LongUtils;

public class Index {
	@Inject
	private PostService postService;

	@Inject
	private UserService userService;

	@Property
	private PostDO post;

	@Property
	private UserDO targetUser;

	@Property
	private Integer pageNo;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	private Boolean onActivate(EventContext context) {
		Long targetUserId = context.get(Long.class, 0);
		targetUser = userService.getUserById(targetUserId);
		this.pageNo = context.get(Integer.class, 1);
		return true;
	}

	Object[] onPassivate() {
		return new Object[] { targetUser.getId(), pageNo };
	}

	public java.util.List<PostDO> getPosts() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		
		PostDO example = new PostDO();
		example.setCreatorId(targetUser.getId());
		
		return postService.pageByExample(example, pageInfo);
	}

	private Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long postId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		postService.deletePostById(currentUserId, postId);
		return null;
	}

	public boolean getShowEdit() {
		return LongUtils.equalsAndNotNull(targetUser.getId(), cookieManager.getCurrentUserId());
	}

	public boolean getShowDelete() {
		return LongUtils.equalsAndNotNull(targetUser.getId(), cookieManager.getCurrentUserId());
	}

}
