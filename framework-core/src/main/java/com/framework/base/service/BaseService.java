package com.framework.base.service;

import com.framework.base.vo.BaseCondation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BaseService<T, C extends BaseCondation> {

    boolean add(T t);

    boolean updateDelFlag(@Param("id") Long id, @Param("delFlag") boolean delFlag);

    boolean updateDetail(T t);

    T queryById(Long id);

    List<T> queryList(C c);

}
