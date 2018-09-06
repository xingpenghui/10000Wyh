package com.wyh10000.controller.sso;

import com.wyh10000.common.result.R;
import com.wyh10000.common.util.CookieUtil;
import com.wyh10000.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@Author feri
 *@Date Created in 2018/9/6 11:31
 */
@RestController
public class SSOController {
    @Autowired
    private SSOService ssoService;

    //登录
    @RequestMapping("/ssologin.do")
    public R login(String name, String password, HttpServletRequest request, HttpServletResponse response){
        String token=CookieUtil.getCk(request,"userauth");
        if(token==null){
            //登录
           R r=ssoService.login(name,password);
           if(r.getCode()==1001){
               //登录成功，需要将令牌存储到Cookie
               CookieUtil.setCK(response,"userauth",r.getData().toString());
           }
            return r;
        }
        else {
            //检查
            return ssoService.loginCheck(token);
        }
    }
    //检查
    @RequestMapping("/ssologincheck.do")
    public R logigcheck( HttpServletRequest request, HttpServletResponse response){
        String token=CookieUtil.getCk(request,"userauth");
        if(token!=null) {
            return ssoService.loginCheck(token);
        }else {
            return R.setERROR();
        }
    }
    //注销
    @RequestMapping("/ssologinout.do")
    public R loginout( HttpServletRequest request, HttpServletResponse response) {
        String token=CookieUtil.getCk(request,"userauth");
        CookieUtil.delCK(response,"userauth");
        return ssoService.loginOut(token);
    }
}
