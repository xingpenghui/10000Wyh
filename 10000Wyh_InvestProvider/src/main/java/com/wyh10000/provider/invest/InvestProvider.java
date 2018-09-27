package com.wyh10000.provider.invest;

import com.alibaba.fastjson.JSON;
import com.wyh10000.common.result.R;
import com.wyh10000.common.util.ResultUtil;
import com.wyh10000.domain.invest.Invest;
import com.wyh10000.domain.invest.InvestLog;
import com.wyh10000.mapper.invest.InvestLogMapper;
import com.wyh10000.mapper.invest.InvestMapper;
import com.wyh10000.service.invest.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/9/27 10:35
 */
@Service
public class InvestProvider  implements InvestService {
    @Autowired
    private InvestMapper investMapper;
    @Autowired
    private InvestLogMapper investLogMapper;

    @Override
    public R save(Invest invest) {
        R r= ResultUtil.createResult(investMapper.insert(invest));
        InvestLog log=new InvestLog();
        log.setContent(JSON.toJSONString(invest));
        log.setIid(invest.getId());
        log.setMoney(invest.getMoney());
        log.setUid(invest.getUid());
        investLogMapper.insert(log);
        return r;
    }

}
