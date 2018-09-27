package com.wyh10000.controller.invest;

import com.wyh10000.domain.invest.Increment;
import com.wyh10000.service.invest.IncrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/27 11:40
 */
@RestController
public class IncrementController {

    @Autowired
    private IncrementService incrementService;

    //查询投资的收益
    @RequestMapping("/incrementbytz.do")
    public Increment getByiid(int iid){
        return incrementService.selectByIid(iid);
    }
    //查询用户的待收益
    @RequestMapping("/incrementuid.do")
    public List<Increment> getByuid(int uid){
        return incrementService.selectByUid(uid);
    }

}
