package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TermRelationDAO {

    public java.lang.Long insert(TermRelationDO termRelationDO);


    public Integer update(TermRelationDO termRelationDO);


    public TermRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TermRelationDO termRelationDO);


    public List<TermRelationDO> listByExample(TermRelationDO termRelationDO);


    public List<TermRelationDO> pageByExample(TermRelationDO termRelationDO, PageInfo page);


    public Integer deleteByExample(TermRelationDO termRelationDO);









}
