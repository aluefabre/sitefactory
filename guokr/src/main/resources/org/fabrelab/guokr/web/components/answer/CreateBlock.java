package org.fabrelab.guokr.web.components.answer;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.UserRelationDO;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.AnswerService;
import org.fabrelab.sitefactory.service.UserService;

public class CreateBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private QuestionDO targetQuestion;	
	
	@Inject
	private QuestionService questionService;
	
	@Inject
	private UserService userService;
	
	@Inject
	private AnswerService answerService;

	@Property
	private String answerContent;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	public Link onSuccess(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long questionId = context.get(Long.class, 0);
		AnswerDO answer = new AnswerDO();
		answer.setContent(answerContent);
		answerService.createAnswer(answer, cookieManager.getCurrentUserId());
		
		QuestionRelationDO arel = new QuestionRelationDO();
		arel.setQuestionId(questionId);
		arel.setRelatedId(answer.getId());
		arel.setRelation(RelationConstants.REGULAR);
		arel.setRelatedType("Answer");
		questionService.createQuestionRelation(arel, cookieManager.getCurrentUserId());
		
		AnswerRelationDO grel = new AnswerRelationDO();
		grel.setAnswerId(answer.getId());
		grel.setRelatedId(questionId);
		grel.setRelation(RelationConstants.REGULAR);
		grel.setRelatedType("Question");
		answerService.createAnswerRelation(grel, cookieManager.getCurrentUserId());
		
		return null;
	}
}
