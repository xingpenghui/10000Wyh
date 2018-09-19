package com.wyh10000.mapper.loan;

import com.wyh10000.domain.loan.LoanCreditLog;

import java.util.List;

public interface LoanCreditLogMapper {

    int insert(LoanCreditLog record);
    List<LoanCreditLog> selectByLid(int lid);

}