package com.wyh10000.service.user;

import com.wyh10000.common.result.R;
import com.wyh10000.domain.UserDetail;

/**
 *@Author feri
 *@Date Created in 2018/9/14 10:12
 */
public interface UserDetailService {
    R save(UserDetail detail);
    UserDetail queryByUid(int uid);
}
