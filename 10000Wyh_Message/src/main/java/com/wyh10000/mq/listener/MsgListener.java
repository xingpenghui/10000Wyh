package com.wyh10000.mq.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyh10000.domain.loan.LoanCreditLog;
import com.wyh10000.service.loan.LoanCreditService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *@Author feri
 *@Date Created in 2018/9/19 16:35
 */
public class MsgListener implements MessageListener {


    private LoanCreditService loanCreditService;

    public MsgListener(LoanCreditService loanCreditService) {
        this.loanCreditService = loanCreditService;
    }

    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            try {
                String json=((TextMessage) message).getText();

                JSONObject jsonObject=JSON.parseObject(json);
                int type=jsonObject.getIntValue("type");
                switch (type){
                    case 1://借款流水
                        LoanCreditLog loanCreditLog=jsonObject.getObject("obj",LoanCreditLog.class);
                        loanCreditService.saveLog(loanCreditLog);
                        break;
                    case 2://投资
                        break;
                    case 3://账户
                        break;
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
