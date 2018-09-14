package com.wyh10000.provider.user;

import com.wyh10000.common.result.R;
import com.wyh10000.common.util.ResultUtil;
import com.wyh10000.domain.UserDetail;
import com.wyh10000.mapper.user.UserDetailMapper;
import com.wyh10000.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/9/14 10:16
 */
@Service
public class UserDetailServiceProvider implements UserDetailService {
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Override
    public R save(UserDetail detail) {
        return ResultUtil.createResult(userDetailMapper.insert(detail));
    }

    @Override
    public UserDetail queryByUid(int uid) {
        return userDetailMapper.selectByUid(uid);
    }
}
