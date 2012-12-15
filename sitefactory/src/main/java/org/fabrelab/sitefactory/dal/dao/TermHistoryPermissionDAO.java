package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TermHistoryPermissionDAO {

    public java.lang.Long insert(TermHistoryPermissionDO termHistoryPermissionDO);


    public Integer update(TermHistoryPermissionDO termHistoryPermissionDO);


    public TermHistoryPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TermHistoryPermissionDO termHistoryPermissionDO);


    public List<TermHistoryPermissionDO> listByExample(TermHistoryPermissionDO termHistoryPermissionDO);


    public List<TermHistoryPermissionDO> pageByExample(TermHistoryPermissionDO termHistoryPermissionDO, PageInfo page);


    public Integer deleteByExample(TermHistoryPermissionDO termHistoryPermissionDO);









}
