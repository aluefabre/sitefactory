package org.fabrelab.guokr.web.components.article;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.SelectModelFactory;
import org.fabrelab.guokr.web.constants.RelationConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.ArticleRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteRelationDO;
import org.fabrelab.sitefactory.deo.ArticleEO;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.SiteService;


public class SiteSidebar {

	@Property
	@Parameter(required = true, allowNull=false)
	private ArticleEO article;
	
	@Inject 
	private ArticleService articleService;
	
	@Inject 
	private SiteService siteService;

	@Property
	private SelectModel siteSelectModel;
	
	@Inject
	private SelectModelFactory selectModelFactory;

	@Property
	private SiteDO selectedSite;

	@Inject
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Component(id = "submitArticleForm")
	private Form submitArticleForm; 
	
	void setupRender() {
		SiteDO example = new SiteDO();
		List<SiteDO> listByExample = siteService.listByExample(example);
		siteSelectModel = selectModelFactory.create(listByExample, "title");
	}
	
	public SiteDO getTargetSite(){
		SiteRelationDO siteRelationDO = new SiteRelationDO();
		siteRelationDO.setRelatedId(article.getId());
		siteRelationDO.setRelatedType("Article");
		List<SiteDO> list = siteService.listByRelation(siteRelationDO);
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
	}

	public boolean getIsPending(){
		return isInStatus(RelationConstants.PENDING);
	}
	
	public boolean getIsRegular(){
		return isInStatus(RelationConstants.REGULAR);
	}

	private boolean isInStatus(String relation) {
		SiteRelationDO siteRelationDO = new SiteRelationDO();
		siteRelationDO.setRelatedId(article.getId());
		siteRelationDO.setRelatedType("Article");
		siteRelationDO.setRelation(relation);
		List<SiteDO> list = siteService.listByRelation(siteRelationDO);
		if(list.size()>=1){
			return true;
		}
		return false;
	}
	
	Link onActionFromCancle(EventContext context){
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long articleId = context.get(Long.class, 0);
		
		SiteRelationDO siteRelationDO = new SiteRelationDO();
		siteRelationDO.setRelatedId(articleId);
		siteRelationDO.setRelatedType("Article");
		siteService.deleteRelationByExample(siteRelationDO, cookieManager.getCurrentUserId());
		
		ArticleRelationDO articleRelationDO = new ArticleRelationDO();
		articleRelationDO.setArticleId(articleId);
		articleRelationDO.setRelatedType("Site");
		articleService.deleteRelationByExample(articleRelationDO, cookieManager.getCurrentUserId());
		
		return null;
	}
	
	public Link onSuccess(EventContext context) {
		Long articleId = context.get(Long.class, 0);
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		SiteRelationDO siteRelationDO = new SiteRelationDO();
		siteRelationDO.setRelatedId(articleId);
		siteRelationDO.setRelatedType("Article");
		List<SiteDO> list = siteService.listByRelation(siteRelationDO);
		if(list.size()>=1){
			return null;
		}
		
		siteRelationDO.setSiteId(selectedSite.getId());
		siteRelationDO.setRelatedId(articleId);
		siteRelationDO.setRelatedType("Article");
		siteRelationDO.setRelation(RelationConstants.PENDING);
		siteService.createSiteRelation(cookieManager.getCurrentUserId(), siteRelationDO);
		
		ArticleRelationDO articleRelationDO = new ArticleRelationDO();
		articleRelationDO.setArticleId(articleId);
		articleRelationDO.setRelatedId(selectedSite.getId());
		articleRelationDO.setRelatedType("Site");
		articleRelationDO.setRelation(RelationConstants.PENDING);
		articleService.createArticleRelation(articleRelationDO, cookieManager.getCurrentUserId());
		
		return null;
	}
	
}
