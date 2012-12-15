package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.sitefactory.dal.dao.GroupDAO;
import org.fabrelab.sitefactory.dal.dao.GroupPermissionDAO;
import org.fabrelab.sitefactory.dal.dao.GroupRelationDAO;
import org.fabrelab.sitefactory.dal.dao.RoleDAO;
import org.fabrelab.sitefactory.dal.dao.RoleRelationDAO;
import org.fabrelab.sitefactory.dal.dao.impl.GroupDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupPermissionDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.RoleDO;
import org.fabrelab.sitefactory.dal.dataobject.RoleRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteGroupEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;

public class GroupService extends GroupDAOImpl{

	private GroupDAO groupDAO;

	private GroupRelationDAO groupRelationDAO;

	private GroupPermissionDAO groupPermissionDAO;

	protected RoleRelationDAO roleRelationDAO;
	
	private UserService userService;

	protected RoleDAO roleDAO;
	
	protected EventService eventService;
	
	public void createGroup(Long operatorId, GroupDO bean) {
		bean.setCreatorId(operatorId);
		bean.setModifierId(operatorId);
		bean.setGmtCreate(new Date());
		bean.setGmtModify(new Date());
		groupDAO.insert(bean);
	}
	
	public void updateGroup(Long operatorId, GroupDO bean) {
		bean.setModifierId(operatorId);
		groupDAO.update(bean);
	}
	public void createGroupRelation(Long operatorId, GroupRelationDO groupRelation) {
		groupRelationDAO.insert(groupRelation);
	}
	
	public void deleteGroupById(Long operator, Long groupId) throws NoPermissionException {
		groupDAO.deleteByPrimaryKey(groupId);
		eventService.fireEvent(new DeleteGroupEvent(groupId));
	}

	public boolean checkPermission(Long targetUserId, Long groupId, String permission){
		GroupPermissionDO example = new GroupPermissionDO();
		example.setGroupId(groupId);
		example.setPermission(permission);
		List<GroupPermissionDO> listByExample = groupPermissionDAO.listByExample(example);
		for (GroupPermissionDO groupPermission : listByExample) {
			String userCondition = groupPermission.getUserCondition();
			if(matchCondition(targetUserId, groupId, userCondition)){
				return true;
			}
		}
		return false;
	}
	
	private boolean matchCondition(Long targetUserId, Long groupId, String userCondition) {
		if("everyone".equals(userCondition)){
			return true;
		}
		if("creator".equals(userCondition)){
			GroupDO group = groupDAO.findByPrimaryKey(groupId);
			if(group.getCreatorId() == targetUserId){
				return true;
			}
		}
		if(userCondition.startsWith("relation-")){
			String[] parts = userCondition.split("-");
			String relation = parts[1];
			GroupRelationDO example = new GroupRelationDO();
			example.setGroupId(groupId);
			example.setRelatedId(targetUserId);
			example.setRelatedType("User");
			example.setRelation(relation);
			Integer count = groupRelationDAO.countByExample(example);
			if(count>0){
				return true;
			}
		}
		if(userCondition.startsWith("role-")){
			String[] parts = userCondition.split("-");
			String roleName = parts[1];
			RoleDO roleExample = new RoleDO();
			roleExample.setName(roleName);
			List<RoleDO> roles = roleDAO.listByExample(roleExample);
			if(roles!=null && roles.size()==1){
				RoleRelationDO example = new RoleRelationDO();
				example.setRoleId(roles.get(0).getId());
				example.setRelatedId(targetUserId);
				example.setRelatedType("User");
				example.setRelation("regular");
				Integer count = roleRelationDAO.countByExample(example);
				if(count>0){
					return true;
				}
			}
		}
		return false;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setGroupRelationDAO(GroupRelationDAO groupRelationDAO) {
		this.groupRelationDAO = groupRelationDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setGroupPermissionDAO(GroupPermissionDAO groupPermissionDAO) {
		this.groupPermissionDAO = groupPermissionDAO;
	}

	public void setRoleRelationDAO(RoleRelationDAO roleRelationDAO) {
		this.roleRelationDAO = roleRelationDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public List<GroupRelationDO> findRelationByExample(GroupRelationDO grel, Long currentUserId) {
		return groupRelationDAO.listByExample(grel);
	}

	public void updateRelation(GroupRelationDO grel) {
		groupRelationDAO.update(grel);
	}

	public void deleteRelationByExample(GroupRelationDO grel, Long currentUserId) {
		groupRelationDAO.deleteByExample(grel);
	}

}
