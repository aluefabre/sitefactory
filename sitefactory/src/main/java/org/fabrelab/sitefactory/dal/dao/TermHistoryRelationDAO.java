package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TermHistoryRelationDAO {

    public java.lang.Long insert(TermHistoryRelationDO termHistoryRelationDO);


    public Integer update(TermHistoryRelationDO termHistoryRelationDO);


    public TermHistoryRelationDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TermHistoryRelationDO termHistoryRelationDO);


    public List<TermHistoryRelationDO> listByExample(TermHistoryRelationDO termHistoryRelationDO);


    public List<TermHistoryRelationDO> pageByExample(TermHistoryRelationDO termHistoryRelationDO, PageInfo page);


    public Integer deleteByExample(TermHistoryRelationDO termHistoryRelationDO);









}
