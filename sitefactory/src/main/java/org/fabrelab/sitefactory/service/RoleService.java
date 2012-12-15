package org.fabrelab.sitefactory.service;

import java.util.List;

import org.fabrelab.sitefactory.dal.dao.RoleDAO;
import org.fabrelab.sitefactory.dal.dao.RoleRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.RoleDO;

public class RoleService {
	protected RoleDAO roleDAO;

	protected RoleRelationDAO roleRelationDAO;
	
	public RoleDO getRoleByName(String name) {
		RoleDO example = new RoleDO();
		example.setName(name);
		List<RoleDO> resultList = roleDAO.listByExample(example);
		if(resultList==null || resultList.isEmpty()){
			return null;
		}
		return resultList.get(0);
	}
	
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public void setRoleRelationDAO(RoleRelationDAO roleRelationDAO) {
		this.roleRelationDAO = roleRelationDAO;
	}

}
