package com.framework.base.mapper;

import com.framework.base.vo.BaseCondation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BaseMapper<T, C extends BaseCondation> {

    void add(T t);

    void updateDelFlag(@Param("id") Long id, @Param("delFlag") boolean delFlag);

    void updateDetail(T t);

    T queryById(Long id);

    List<T> queryList(C c);

}
