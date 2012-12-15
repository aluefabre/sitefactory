package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TermHistoryDAO {

    public java.lang.Long insert(TermHistoryDO termHistoryDO);


    public Integer update(TermHistoryDO termHistoryDO);


    public TermHistoryDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TermHistoryDO termHistoryDO);


    public List<TermHistoryDO> listByExample(TermHistoryDO termHistoryDO);


    public List<TermHistoryDO> pageByExample(TermHistoryDO termHistoryDO, PageInfo page);


    public Integer deleteByExample(TermHistoryDO termHistoryDO);


    public List<TermHistoryDO> listByRelation(TermHistoryRelationDO TermHistoryRelationDO);


    public List<TermHistoryDO> pageByRelation(TermHistoryRelationDO TermHistoryRelationDO, PageInfo page);


    public List<TermHistoryDO> pageByRelationAndExample(TermHistoryRelationDO TermHistoryRelationDO, TermHistoryDO termHistoryDO, PageInfo page);


    public List<TermHistoryDO> listByRelationAndExample(TermHistoryRelationDO TermHistoryRelationDO, TermHistoryDO termHistoryDO);

}
