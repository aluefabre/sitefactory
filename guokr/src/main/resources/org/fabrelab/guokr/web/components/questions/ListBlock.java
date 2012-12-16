package org.fabrelab.guokr.web.components.questions;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;

public class ListBlock {
	
	@Property
	@Parameter(required = true, allowNull=false)
	private java.util.List<QuestionDO> questions;
	
	@Property
	private QuestionDO question;
}
