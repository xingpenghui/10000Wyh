package com.wyh10000.controller.user;

import com.alibaba.fastjson.JSON;
import com.wyh10000.common.redis.JedisUtil;
import com.wyh10000.common.result.R;
import com.wyh10000.common.util.CookieUtil;
import com.wyh10000.domain.Rank;
import com.wyh10000.domain.User;
import com.wyh10000.domain.UserDetail;
import com.wyh10000.service.user.RankService;
import com.wyh10000.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/14 11:23
 */
@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private JedisUtil jedisUtil;

    //新增
    @RequestMapping("/userdetailsave.do")
    public R save(UserDetail detail){
        return userDetailService.save(detail);
    }
    //查询
    @RequestMapping("/userdetailbyuid.do")
    public UserDetail getSingle(HttpServletRequest request){
        String token=CookieUtil.getCk(request,"userauth");
        String json= jedisUtil.getStr(token);
        User user= JSON.parseObject(json,User.class);
        return userDetailService.queryByUid(user.getId());
    }
}
