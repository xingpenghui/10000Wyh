package com.wyh10000.controller.user;

import com.alibaba.fastjson.JSON;
import com.wyh10000.common.redis.JedisUtil;
import com.wyh10000.common.result.R;
import com.wyh10000.common.util.CookieUtil;
import com.wyh10000.domain.Rank;
import com.wyh10000.domain.User;
import com.wyh10000.service.user.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/14 11:16
 */
@RestController
public class RankController {
    @Autowired
    private RankService rankService;
    @Autowired
    private JedisUtil jedisUtil;

    //新增
    @RequestMapping("/ranksave.do")
    public R save(Rank rank){
        return rankService.save(rank);
    }
    //查询
    @RequestMapping("/ranklist.do")
    public List<Rank> list(HttpServletRequest request){
        String token=CookieUtil.getCk(request,"userauth");
        String json= jedisUtil.getStr(token);
        User user= JSON.parseObject(json,User.class);
        return rankService.queryByUid(user.getId());
    }
}
