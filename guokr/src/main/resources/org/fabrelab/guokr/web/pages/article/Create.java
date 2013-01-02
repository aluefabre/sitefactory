package org.fabrelab.guokr.web.pages.article;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.ArticleRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteRelationDO;
import org.fabrelab.sitefactory.deo.ArticleEO;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.SiteService;

public class Create {
	@Property
	private String title;

	@Property
	private String content;

	@Inject
	private ArticleService articleService;

	@Inject
	private SiteService siteService;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	@Property
	private Long siteId;
	
	private Link onActivate(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		siteId = context.get(Long.class, 0);
		return null;
	}
	
	Object[] onPassivate() {
		return new Object[]{siteId};
	}
	
	public Link onSuccess(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		siteId = context.get(Long.class, 0);
		ArticleEO article = new ArticleEO();
		article.setContent(content);
		article.setTitle(title);
		article.setType("ARTICLE");
		articleService.createArticle(article, cookieManager.getCurrentUserId());
		
		ArticleRelationDO arel = new ArticleRelationDO();
		arel.setArticleId(article.getId());
		arel.setRelatedId(siteId);
		arel.setRelation(RelationConstants.PENDING);
		arel.setRelatedType("Site");
		articleService.createArticleRelation(arel, cookieManager.getCurrentUserId());
		
		SiteRelationDO grel = new SiteRelationDO();
		grel.setSiteId(siteId);
		grel.setRelatedId(article.getId());
		grel.setRelation(RelationConstants.PENDING);
		grel.setRelatedType("Article");
		siteService.createSiteRelation(cookieManager.getCurrentUserId(), grel);
		
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, article.getId());
	}
}
