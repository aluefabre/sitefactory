package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface GroupDAO {

    public java.lang.Long insert(GroupDO groupDO);


    public Integer update(GroupDO groupDO);


    public GroupDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(GroupDO groupDO);


    public List<GroupDO> listByExample(GroupDO groupDO);


    public List<GroupDO> pageByExample(GroupDO groupDO, PageInfo page);


    public Integer deleteByExample(GroupDO groupDO);


    public List<GroupDO> listByRelation(GroupRelationDO groupRelationDO);


    public List<GroupDO> pageByRelation(GroupRelationDO groupRelationDO, PageInfo page);


    public List<GroupDO> pageByRelationAndExample(GroupRelationDO groupRelationDO, GroupDO groupDO, PageInfo page);


    public List<GroupDO> listByRelationAndExample(GroupRelationDO groupRelationDO, GroupDO groupDO);

}
