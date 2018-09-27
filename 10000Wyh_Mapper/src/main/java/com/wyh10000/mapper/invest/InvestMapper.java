package com.wyh10000.mapper.invest;

import com.wyh10000.domain.invest.Invest;

import java.util.List;

public interface InvestMapper {

    int insert(Invest record);

    Invest selectByPrimaryKey(Integer id);

    List<Invest> selectByUid(int uid);

}