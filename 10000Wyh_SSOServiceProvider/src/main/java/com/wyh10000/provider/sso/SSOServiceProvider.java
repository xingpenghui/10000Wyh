package com.wyh10000.provider.sso;

import com.alibaba.fastjson.JSON;
import com.wyh10000.common.redis.JedisUtil;
import com.wyh10000.common.result.R;
import com.wyh10000.common.util.EncrypUtil;
import com.wyh10000.domain.User;
import com.wyh10000.mapper.user.UserMapper;
import com.wyh10000.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *@Author feri
 *@Date Created in 2018/9/6 10:15
 */
@Service("ssoServiceProvider")
public class SSOServiceProvider implements SSOService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisUtil jedisUtil;

    //登录
    @Override
    public R login(String name, String password) {
        //1、查询数据库
        User user=userMapper.selectByName(name);
        //2、验证登录信息
        if(user!=null){
            //用户存在
            if(Objects.equals(user.getPassword(),password)){
                //登录成功
                //3、生成令牌--唯一，复杂，密文
                String token=EncrypUtil.md5Pass(user.getId().toString(),name);
                //4、存储登录信息到Redis
                jedisUtil.addStr(token,JSON.toJSONString(user),TimeUnit.MINUTES,30);
                //5、令牌记录到Cookie---控制器

                return new R(1001,"登录成功",token);
            }else {
                return new R(1003,"密码不正确");
            }
        }else{
            return new R(1002,"用户不存在");
        }
    }

    //校验--令牌存在
    @Override
    public R loginCheck(String token) {
        if(jedisUtil.isKey(token)){
            //有效
            //读取Redis中的用户信息
            String json=jedisUtil.getStr(token);
            jedisUtil.expire(token,TimeUnit.MINUTES,30);
            return new R(1001,"OK",JSON.parseObject(json,User.class));
        }else {
            return R.setERROR();
        }
    }

    //注销
    @Override
    public R loginOut(String token) {
        //删除Redis
        jedisUtil.delKey(token);
        return R.setOK();
    }


}
