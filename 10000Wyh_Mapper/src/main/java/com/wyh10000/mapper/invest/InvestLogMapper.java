package com.wyh10000.mapper.invest;

import com.wyh10000.domain.invest.InvestLog;

import java.util.List;

public interface InvestLogMapper {

    int insert(InvestLog record);
    List<InvestLog> selectByIid(int iid);
    List<InvestLog> selectNew();

}