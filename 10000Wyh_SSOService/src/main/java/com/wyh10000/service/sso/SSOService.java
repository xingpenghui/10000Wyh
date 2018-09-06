package com.wyh10000.service.sso;

import com.wyh10000.common.result.R;

/**
 *@Author feri
 *@Date Created in 2018/9/4 16:24
 */
public interface SSOService {

    R login(String name, String password);
    R loginCheck(String token);
    R loginOut(String token);

}
