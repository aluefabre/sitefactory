package org.fabrelab.guokr.web.pages.answer;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerRelationDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.AnswerService;

public class Create {
	@Property
	private String title;

	@Property
	private String content;

	@Inject
	private AnswerService answerService;

	@Inject
	private GroupService groupService;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	@Property
	private Long groupId;
	
	private Link onActivate(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		groupId = context.get(Long.class, 0);
		return null;
	}
	
	Object[] onPassivate() {
		return new Object[]{groupId};
	}
	
	public Link onSuccess(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		groupId = context.get(Long.class, 0);
		AnswerDO answer = new AnswerDO();
		answer.setContent(content);
		answer.setTitle(title);
		answer.setType("POST");
		answerService.createAnswer(answer, cookieManager.getCurrentUserId());
		
		AnswerRelationDO arel = new AnswerRelationDO();
		arel.setAnswerId(answer.getId());
		arel.setRelatedId(groupId);
		arel.setRelation(RelationConstants.REGULAR);
		arel.setRelatedType("Group");
		answerService.createAnswerRelation(arel, cookieManager.getCurrentUserId());
		
		GroupRelationDO grel = new GroupRelationDO();
		grel.setGroupId(groupId);
		grel.setRelatedId(answer.getId());
		grel.setRelation(RelationConstants.REGULAR);
		grel.setRelatedType("Answer");
		groupService.createGroupRelation(cookieManager.getCurrentUserId(), grel);
		
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, answer.getId());
	}
}
