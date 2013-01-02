package org.fabrelab.guokr.web.pages.site.article;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.ArticleRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.SiteService;
import org.fabrelab.sitefactory.service.UserService;

public class List {
	@Inject
	private SiteService siteService;

	@Inject
	private UserService userService;
	
	@Property
	private SiteDO targetSite;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	@Property
	private ArticleDO article;
	
	@Inject
	private ArticleService articleService;

	@Property
	private Integer pageNo;
	
	private Boolean onActivate(EventContext context) {
		Long siteId = context.get(Long.class, 0);
		if(context.getCount()>1){
			this.pageNo =  context.get(Integer.class, 1);
		}else{
			pageNo = 0;
		}
		targetSite = siteService.findByPrimaryKey(siteId);
		return true;
	}
	
	Object[] onPassivate() {
		return new Object[] {targetSite.getId(), pageNo};
	}
	
	public java.util.List<ArticleDO> getArticles() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		ArticleRelationDO relation = new ArticleRelationDO();
		relation.setRelatedId(targetSite.getId());
		relation.setRelatedType("Site");
		relation.setRelation(RelationConstants.REGULAR);
		return  articleService.pageByRelation(relation, pageInfo);
	}
}
