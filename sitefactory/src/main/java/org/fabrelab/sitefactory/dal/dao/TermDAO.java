package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TermDAO {

    public java.lang.Long insert(TermDO termDO);


    public Integer update(TermDO termDO);


    public TermDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TermDO termDO);


    public List<TermDO> listByExample(TermDO termDO);


    public List<TermDO> pageByExample(TermDO termDO, PageInfo page);


    public Integer deleteByExample(TermDO termDO);


    public List<TermDO> listByRelation(TermRelationDO termRelationDO);


    public List<TermDO> pageByRelation(TermRelationDO termRelationDO, PageInfo page);


    public List<TermDO> pageByRelationAndExample(TermRelationDO termRelationDO, TermDO termDO, PageInfo page);


    public List<TermDO> listByRelationAndExample(TermRelationDO termRelationDO, TermDO termDO);

}
