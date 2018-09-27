package com.wyh10000.mapper.invest;

import com.wyh10000.domain.invest.InvestSh;

public interface InvestShMapper {

    int insert(InvestSh record);

    InvestSh selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(InvestSh record);
}