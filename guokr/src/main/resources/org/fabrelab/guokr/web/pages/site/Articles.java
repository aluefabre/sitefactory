package org.fabrelab.guokr.web.pages.site;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.ArticleRelationDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.UserService;

public class Articles {
	
	@Inject
	private UserService userService;
	
	@Property
	private ArticleDO article;
	
	@Inject
	private ArticleService articleService;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Property
	private Integer pageNo;
	
	private Boolean onActivate(EventContext context) {
		this.pageNo = context.get(Integer.class, 0);
		if(pageNo==null){
			pageNo=0;
		}
		return true;
	}

	Integer onPassivate() {
		return  pageNo;
	}

	public java.util.List<ArticleDO> getArticles(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		ArticleRelationDO relation = new ArticleRelationDO();
		relation.setRelatedType("Site");
		relation.setRelation(RelationConstants.REGULAR);
		return articleService.pageByRelation(relation , pageInfo);
	}
	
}
