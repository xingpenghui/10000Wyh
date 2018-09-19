package com.wyh10000.provider.credit;

import com.alibaba.fastjson.JSON;
import com.wyh10000.common.result.R;
import com.wyh10000.common.util.ResultUtil;
import com.wyh10000.common.vo.MsgVo;
import com.wyh10000.domain.loan.LoanCredit;
import com.wyh10000.domain.loan.LoanCreditLog;
import com.wyh10000.mapper.loan.LoanCreditLogMapper;
import com.wyh10000.mapper.loan.LoanCreditMapper;
import com.wyh10000.service.loan.LoanCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/19 15:33
 */
@Service
public class LoanCreditProvider implements LoanCreditService {
    @Autowired  //通过类型注入
    private LoanCreditMapper loanCreditMapper;
    @Autowired
    private LoanCreditLogMapper loanCreditLogMapper;
    @Autowired
    private JmsTemplate jmsTemplate;
//    @Qualifier()
//    @Resource


    @Override
    public R save(LoanCredit lc) {
        loanCreditMapper.insert(lc);
        LoanCreditLog log=new LoanCreditLog();
        log.setLid(lc.getId());
        log.setUid(lc.getUid());
        log.setContent("用户新增信用贷申请:"+lc.getMoney());
        MsgVo<LoanCreditLog> msgVo=new MsgVo<>();
        msgVo.setType(1);
        msgVo.setObj(log);
        String json= JSON.toJSONString(msgVo);
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message=session.createTextMessage(json);
                return message;
            }
        });
        //loanCreditLogMapper.insert(log);
        return R.setOK();
    }

    @Override
    public R saveLog(LoanCreditLog loanCreditLog) {

        return ResultUtil.createResult( loanCreditLogMapper.insert(loanCreditLog));
    }

    @Override
    public List<LoanCredit> queryList(int uid) {
        return loanCreditMapper.selectByUId(uid);
    }
}
