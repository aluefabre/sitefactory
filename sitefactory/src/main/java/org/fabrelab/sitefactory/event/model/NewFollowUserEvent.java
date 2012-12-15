package org.fabrelab.sitefactory.event.model;

public class NewFollowUserEvent extends Event {

	Long userAId;
	Long userBId;
	public NewFollowUserEvent(Long userAId, Long userBId) {
		this.userAId = userAId;
		this.userBId = userBId;
	}
	public Long getUserAId() {
		return userAId;
	}
	public Long getUserBId() {
		return userBId;
	}

}
