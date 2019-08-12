package com.framework.base.service;

import com.framework.base.vo.BaseCondation;

public interface TreeService<T, C extends BaseCondation> extends BaseService<T, C> {

    T queryParentById(Long id);
}
