package org.fabrelab.sitefactory.event.model;

import org.fabrelab.sitefactory.dal.dataobject.UserRelationDO;

public class DeleteUserRelationEvent extends Event {
	UserRelationDO relation;
	public DeleteUserRelationEvent(UserRelationDO relation) {
		this.relation = relation;
	}
	public void setRelation(UserRelationDO relation) {
		this.relation = relation;
	}
}
