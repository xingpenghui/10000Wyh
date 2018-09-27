package com.wyh10000.service.loan;

import com.wyh10000.common.result.R;
import com.wyh10000.domain.loan.LoanCredit;
import com.wyh10000.domain.loan.LoanCreditLog;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/19 15:30
 */
public interface LoanCreditService {
    //新增
    R save(LoanCredit lc);
    R saveLog(LoanCreditLog loanCreditLog);
    //查询
    List<LoanCredit> queryList(int uid);



}
