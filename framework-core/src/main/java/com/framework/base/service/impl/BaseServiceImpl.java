package com.framework.base.service.impl;

import com.framework.base.mapper.BaseMapper;
import com.framework.base.service.BaseService;
import com.framework.base.vo.BaseCondation;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public abstract class BaseServiceImpl<T, C extends BaseCondation, M extends BaseMapper<T, C>> implements BaseService<T, C> {

    @Autowired
    protected M mapper;

    public boolean add(T t) {
        mapper.add(t);
        return Boolean.TRUE;
    }

    public boolean updateDelFlag(Long id, boolean delFlag) {
        mapper.updateDelFlag(id, delFlag);
        return Boolean.TRUE;
    }

    public boolean updateDetail(T t) {
        mapper.updateDetail(t);
        return Boolean.TRUE;
    }

    public T queryById(Long id) {
        return mapper.queryById(id);
    }

    public List<T> queryList(C c) {
        return mapper.queryList(c);
    }
}
