package org.fabrelab.guokr.web.pages.article;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.RelationConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteRelationDO;
import org.fabrelab.sitefactory.deo.ArticleEO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.SiteService;
import org.fabrelab.sitefactory.service.UserService;

public class View {

	@Inject 
	private ArticleService articleService;

	@Inject 
	private UserService userService;
	
	@Inject 
	private SiteService siteService;
	
	@Property
	private ArticleEO article;
	
	@Inject 
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	private Boolean onActivate(EventContext context) {
		Long articleId = context.get(Long.class, 0);
		article = articleService.findExtendedArticle(articleId);
		return true;	
	}
	
	Long onPassivate() {
		return article.getId();
	}
	
	public List<SiteDO> getArticleSites(){
		SiteRelationDO siteRelationDO = new SiteRelationDO();
		siteRelationDO.setRelatedId(article.getId());
		siteRelationDO.setRelatedType("Article");
		siteRelationDO.setRelation(RelationConstants.REGULAR);
		return siteService.listByRelation(siteRelationDO);
	}
	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long articleId =  context.get(Long.class, 0);
		ArticleDO article = articleService.findByPrimaryKey(articleId);
		Long currentUserId = cookieManager.getCurrentUserId();
		boolean success = articleService.deleteArticleById(currentUserId, articleId);
		if(success){
			List<SiteDO> sites = getArticleSites();
			for (SiteDO site : sites) {
				Link link = pageRenderLinkSource.createPageRenderLinkWithContext(org.fabrelab.guokr.web.pages.site.Articles.class, site.getId());
				return link;
			}
			Link link = pageRenderLinkSource.createPageRenderLinkWithContext(org.fabrelab.guokr.web.pages.user.View.class, article.getCreatorId());
			return link;
		}
		return null;
	}
}
