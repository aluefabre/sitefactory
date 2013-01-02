package org.fabrelab.guokr.web.pages.question;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionRelationDO;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.UserService;

public class Tag {

	@Inject 
	private UserService userService;
	
	@Property
	private QuestionDO question;
	
	@Inject
	private QuestionService questionService;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Property
	private Integer pageNo;
	
	@Property
	private Long tagId;
	
	private Boolean onActivate(EventContext context) {
		this.tagId = context.get(Long.class, 0);
		this.pageNo = context.get(Integer.class, 1);
		if(pageNo==null){
			pageNo=0;
		}
		return true;
	}

	Object[] onPassivate() {
		return new Object[]{tagId, pageNo};
	}
	
	public java.util.List<QuestionDO> getQuestions() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);

		QuestionDO example = new QuestionDO();
		
		QuestionRelationDO relation = new QuestionRelationDO();
		relation.setRelatedId(tagId);
		relation.setRelatedType("Tag");
		relation.setRelation(RelationConstants.REGULAR);
		
		return questionService.pageByRelationAndExample(relation, example, pageInfo);
	}
}
