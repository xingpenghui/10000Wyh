package com.wyh10000.controller.loan;

import com.wyh10000.common.result.R;
import com.wyh10000.domain.loan.LoanCredit;
import com.wyh10000.service.loan.LoanCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/19 15:39
 */
@RestController
public class LoanCreditController {
    @Autowired
    private LoanCreditService loanCreditService;

    //新增
    @RequestMapping("loancreditsave.do")
    public R save(LoanCredit credit){
        return loanCreditService.save(credit);
    }
    //查询
    @RequestMapping("loancreditlist")
    public List<LoanCredit> queryByUid(){
        return loanCreditService.queryList(0);
    }

}
