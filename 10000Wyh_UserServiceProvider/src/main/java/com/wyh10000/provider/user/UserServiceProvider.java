package com.wyh10000.provider.user;

import com.wyh10000.common.result.R;
import com.wyh10000.common.util.ResultUtil;
import com.wyh10000.domain.User;
import com.wyh10000.mapper.user.UserMapper;
import com.wyh10000.service.user.UserService;
import org.apache.curator.RetryPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/9/4 16:37
 */
@Service
public class UserServiceProvider implements UserService {
   @Autowired
   private UserMapper userMapper;

    @Override
    public R save(User user)
    {
        System.err.println("provider---1111"+user.getUsername());
        return ResultUtil.createResult(userMapper.insert(user));
    }
}
