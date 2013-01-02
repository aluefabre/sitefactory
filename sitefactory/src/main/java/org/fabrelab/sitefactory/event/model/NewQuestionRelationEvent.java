package org.fabrelab.sitefactory.event.model;

import org.fabrelab.sitefactory.dal.dataobject.QuestionRelationDO;

public class NewQuestionRelationEvent extends Event {
	QuestionRelationDO relation;
	public NewQuestionRelationEvent(QuestionRelationDO relation){
		this.relation = relation;
	}
	public QuestionRelationDO getRelation() {
		return relation;
	}
}
