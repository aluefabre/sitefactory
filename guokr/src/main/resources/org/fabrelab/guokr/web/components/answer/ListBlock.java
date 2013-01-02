package org.fabrelab.guokr.web.components.answer;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerRelationDO;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.AnswerService;

public class ListBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private QuestionDO targetQuestion;	
	
	@Property
	private Integer pageNo;	
	
	@Inject
	private QuestionService questionService;
	
	@Inject
	private AnswerService answerService;

	@Property
	private AnswerDO answer;	
	
	public java.util.List<AnswerDO> getAnswers() {
		if(pageNo==null){
			pageNo = 0;
		}
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		AnswerRelationDO relation = new AnswerRelationDO();
		relation.setRelatedId(targetQuestion.getId());
		relation.setRelatedType("Question");
		relation.setRelation(RelationConstants.REGULAR);
		return answerService.pageByRelation(relation, pageInfo);
	}
}
