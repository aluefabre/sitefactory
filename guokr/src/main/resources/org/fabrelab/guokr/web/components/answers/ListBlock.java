package org.fabrelab.guokr.web.components.answers;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;

public class ListBlock {

	@Property
	private AnswerDO answer;	
	
	@Property
	@Parameter(required = true, allowNull=false)
	private java.util.List<AnswerDO> answers;
}
