package org.fabrelab.guokr.web.pages.question;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.RelationConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionRelationDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.QuestionService;

public class Create {
	@Property
	private String title;

	@Property
	private String content;

	@Inject
	private QuestionService questionService;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	private Link onActivate(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		return null;
	}
	
	Object[] onPassivate() {
		return new Object[]{};
	}
	
	public Link onSuccess(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		QuestionDO question = new QuestionDO();
		question.setContent(content);
		question.setTitle(title);
		question.setType("POST");
		questionService.createQuestion(question, cookieManager.getCurrentUserId());
		
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, question.getId());
	}
}
