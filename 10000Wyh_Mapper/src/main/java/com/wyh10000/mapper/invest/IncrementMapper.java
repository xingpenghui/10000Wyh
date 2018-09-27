package com.wyh10000.mapper.invest;

import com.wyh10000.domain.invest.Increment;

import java.util.List;

public interface IncrementMapper {

    int insert(Increment record);

    int updateByPrimaryKey(Increment record);

    Increment selectByIid(int iid);

    List<Increment> selectByUid(int uid);
}