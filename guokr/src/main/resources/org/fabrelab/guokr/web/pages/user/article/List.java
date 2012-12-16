package org.fabrelab.guokr.web.pages.user.article;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.UserService;

public class List {

	@Inject
	private ArticleService articleService;

	@Inject
	private UserService userService;

	@Property
	private UserDO targetUser;
	
	@Property
	private ArticleDO article;
	
	@Property
	private Integer pageNo;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	private Boolean onActivate(EventContext context) {
		Long targetUserId = context.get(Long.class, 0);
		targetUser = userService.getUserById(targetUserId);
		pageNo=0;
		if(context.getCount()>1){
			this.pageNo = context.get(Integer.class, 1);
		}
		return true;
	}

	Object[] onPassivate() {
		return  new Object[]{targetUser.getId(), pageNo};
	}
	
	public java.util.List<ArticleDO> getArticles(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		ArticleDO articleDO = new ArticleDO();
		articleDO.setCreatorId(targetUser.getId());
		articleDO.setType("Article");
		return articleService.pageByExample(articleDO, pageInfo);
	}
	
}
