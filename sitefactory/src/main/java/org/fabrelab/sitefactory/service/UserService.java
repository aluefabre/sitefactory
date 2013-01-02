package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dao.UserDAO;
import org.fabrelab.sitefactory.dal.dao.UserRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.dal.dataobject.UserRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteUserRelationEvent;
import org.fabrelab.sitefactory.event.model.NewUserRelationEvent;
import org.fabrelab.sitefactory.event.service.EventService;

public class UserService {
	public static String ROLE_ROOT = "ROLE_ROOT";
	
	protected UserDAO userDAO;

	protected UserRelationDAO userRelationDAO;
	
	protected EventService eventService;
	
	public UserDO getUserById(long id) {
		return userDAO.findByPrimaryKey(id);
	}

	public void createUser(UserDO user) {
		user.setGmtCreate(new Date());
		user.setGmtModify(new Date());
		userDAO.insert(user);
	}

	public boolean isValid(String email, String password) {
		UserDO user = getUserByEmail(email);
		if(user==null){
			return false;
		}
		if(!StringUtils.equals(user.getPassword(), password)){
			return false;
		}
		return true;
	}

	public UserDO getUserByEmail(String email) {
		UserDO example = new UserDO();
		example.setEmail(email);
		List<UserDO> resultList = userDAO.listByExample(example);
		if(resultList==null || resultList.isEmpty()){
			return null;
		}
		return resultList.get(0);
	}

	public List<UserDO> listUsers(PageInfo page) {
		UserDO example = new UserDO();
		List<UserDO> userDOs = userDAO.pageByExample(example, page);
		return userDOs;
	}

	public void createFollow(Long userAId, Long userBId){
		UserRelationDO followBy = createFollowByRelation(userAId, userBId);
		createOrUpdateRelation(userAId, followBy);

		UserRelationDO follow = createFollowRelation(userAId, userBId);
		createOrUpdateRelation(userAId, follow);
		
		if(isAFollowB(userBId, userAId)){
			createFriendship(userAId, userBId);
		}
		
	}

	private void createFriendship(Long userAId, Long userBId) {
		UserRelationDO friendBy = createFriendRelation(userAId, userBId);
		createOrUpdateRelation(userAId, friendBy);

		UserRelationDO friend = createFriendRelation(userBId, userAId);
		createOrUpdateRelation(userAId, friend);
	}
	
	private UserRelationDO createFollowRelation(Long userAId, Long userBId) {
		UserRelationDO follow = new UserRelationDO();
		follow.setUserId(userAId);
		follow.setRelatedId(userBId);
		follow.setRelatedType("User");
		follow.setRelation("FOLLOW");
		return follow;
	}

	private UserRelationDO createFollowByRelation(Long userAId, Long userBId) {
		UserRelationDO followBy = new UserRelationDO();
		followBy.setUserId(userBId);
		followBy.setRelatedId(userAId);
		followBy.setRelatedType("User");
		followBy.setRelation("FOLLOW_BY");
		return followBy;
	}

	private UserRelationDO createFriendRelation(Long userAId, Long userBId) {
		UserRelationDO friendBy = new UserRelationDO();
		friendBy.setUserId(userBId);
		friendBy.setRelatedId(userAId);
		friendBy.setRelatedType("User");
		friendBy.setRelation("FRIEND");
		return friendBy;
	}

	private void createOrUpdateRelation(Long userAId, UserRelationDO followBy) {
		List<UserRelationDO> exsitingRecords = userRelationDAO.listByExample(followBy);
		if(exsitingRecords==null || exsitingRecords.isEmpty()){
			createUserRelation(followBy, userAId);
		}
	}

	public void createUserRelation(UserRelationDO relation, Long userId) {
		relation.setCreatorId(userId);
		relation.setModifierId(userId);
		userRelationDAO.insert(relation);

		eventService.fireEvent(new NewUserRelationEvent(relation));
	}
	
	public boolean isAFollowB(Long userAId, Long userBId) {
		if(userAId==null || userBId==null){
			return false;
		}
		UserRelationDO follow = createFollowRelation(userAId, userBId);
		List<UserRelationDO> exsitingRecords = userRelationDAO.listByExample(follow);
		if(exsitingRecords==null || exsitingRecords.isEmpty()){
			return false;
		}
		return true;
	}

	public void deleteFollow(Long userAId, Long userBId) {
		UserRelationDO followBy = createFollowByRelation(userAId, userBId);
		deleteRelation(followBy);

		UserRelationDO follow = createFollowRelation(userAId, userBId);
		deleteRelation(follow);
		
		UserRelationDO friendBy = createFriendRelation(userAId, userBId);
		deleteRelation(friendBy);

		UserRelationDO friend = createFriendRelation(userBId, userAId);
		deleteRelation(friend);
	}

	private void deleteRelation(UserRelationDO relation) {
		List<UserRelationDO> exsitingRecords = userRelationDAO.listByExample(relation);
		if(exsitingRecords==null || exsitingRecords.isEmpty()){
			return;
		}
		for (UserRelationDO userRelationDO : exsitingRecords) {
			userRelationDAO.deleteByPrimaryKey(userRelationDO.getId());
		}
		eventService.fireEvent(new DeleteUserRelationEvent(relation));
	}

	public List<UserDO> getIFollowUsers(Long targetUserId, PageInfo page) {
		UserRelationDO follow = new UserRelationDO();
		follow.setUserId(targetUserId);
		follow.setRelatedType("User");
		follow.setRelation("FOLLOW_BY");
		return userDAO.pageByRelation(follow, page);
	}
	
	public List<UserDO> getFollowMeUsers(Long targetUserId, PageInfo page) {
		UserRelationDO follow = new UserRelationDO();
		follow.setUserId(targetUserId);
		follow.setRelatedType("User");
		follow.setRelation("FRIEND");
		return userDAO.pageByRelation(follow, page);
	}

	public List<UserDO> getFriendUsers(Long targetUserId, PageInfo page) {
		UserRelationDO follow = new UserRelationDO();
		follow.setUserId(targetUserId);
		follow.setRelatedType("User");
		follow.setRelation("FOLLOW");
		return userDAO.pageByRelation(follow, page);
	}

	public List<UserDO> pageUsersByRelation(PageInfo page, Long relatedId, String relatedType, String relation) {
		UserRelationDO relationDO = new UserRelationDO();
		relationDO.setUserId(relatedId);
		relationDO.setRelatedType(relatedType);
		relationDO.setRelation(relation);
		return userDAO.pageByRelation(relationDO, page);
	}
	
	public void setUserRelationDAO(UserRelationDAO userRelationDAO) {
		this.userRelationDAO = userRelationDAO;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<UserRelationDO> findRelationByExample(UserRelationDO urel, Long currentUserId) {
		return userRelationDAO.listByExample(urel);
	}

}
