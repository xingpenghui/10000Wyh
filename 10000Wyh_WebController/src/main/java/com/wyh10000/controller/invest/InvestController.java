package com.wyh10000.controller.invest;

import com.wyh10000.common.result.R;
import com.wyh10000.domain.invest.Invest;
import com.wyh10000.service.invest.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2018/9/27 11:38
 */
@RestController
public class InvestController {

    @Autowired
    private InvestService investService;

    //新增--投资
    @RequestMapping("investadd.do")
    public R save(Invest invest){
        return investService.save(invest);
    }
}
