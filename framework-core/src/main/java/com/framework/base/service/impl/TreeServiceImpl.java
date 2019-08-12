package com.framework.base.service.impl;


import com.framework.base.mapper.TreeMapper;
import com.framework.base.service.TreeService;
import com.framework.base.vo.BaseCondation;

public abstract class TreeServiceImpl<T, C extends BaseCondation, M extends TreeMapper<T, C>> extends BaseServiceImpl<T, C , M>
    implements TreeService<T,C> {

    public T queryParentById(Long id) {
        return mapper.queryById(id);
    }
}
