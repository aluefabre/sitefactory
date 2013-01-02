package org.fabrelab.guokr.web.pages.article;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteRelationDO;
import org.fabrelab.sitefactory.deo.ArticleEO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.SiteService;
import org.fabrelab.sitefactory.service.UserService;
import org.fabrelab.sitefactory.util.LongUtils;

public class Edit {
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

	@Property
	private String title;
	
	@Property
	private String content;
	
	private Link onActivate(EventContext context) {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long articleId = context.get(Long.class, 0);
		article = articleService.findExtendedArticle(articleId);
		if(!LongUtils.equalsAndNotNull(article.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		title = article.getTitle();
		content = article.getContent();
		return null;
	}

	Long onPassivate() {
		return article.getId();
	}
	
	public SiteDO getTargetSite(){
		SiteRelationDO siteRelationDO = new SiteRelationDO();
		siteRelationDO.setRelatedId(article.getId());
		siteRelationDO.setRelatedType("Article");
		siteRelationDO.setRelation(RelationConstants.REGULAR);
		List<SiteDO> list =siteService.listByRelation(siteRelationDO);
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
	}
	
	public List<SiteDO> getArticleSites(){
		SiteRelationDO siteRelationDO = new SiteRelationDO();
		siteRelationDO.setRelatedId(article.getId());
		siteRelationDO.setRelatedType("Article");
		siteRelationDO.setRelation(RelationConstants.REGULAR);
		return siteService.listByRelation(siteRelationDO);
	}
	
	public Link onSuccess() throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		
		if(!LongUtils.equalsAndNotNull(article.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		article.setContent(content);
		article.setTitle(title);
		articleService.updateArticle(article,cookieManager.getCurrentUserId());
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, article.getId());
	}

}
