package com.wyh10000.controller.user;

import com.wyh10000.common.result.R;
import com.wyh10000.domain.User;
import com.wyh10000.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2018/9/4 16:43
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //新增
    @PostMapping("/usersave.do")
    public R save(User user){
        return userService.save(user);
    }
}
