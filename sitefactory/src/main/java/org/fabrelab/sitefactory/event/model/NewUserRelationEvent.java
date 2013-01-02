package org.fabrelab.sitefactory.event.model;

import org.fabrelab.sitefactory.dal.dataobject.UserRelationDO;

public class NewUserRelationEvent extends Event {
	UserRelationDO relation;
	public NewUserRelationEvent(UserRelationDO relation) {
		this.relation = relation;
	}
	public void setRelation(UserRelationDO relation) {
		this.relation = relation;
	}
}
