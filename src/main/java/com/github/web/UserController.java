package com.github.web;

import com.github.model.UserValidedResult;
import com.github.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lidefu
 * @date 2019/2/26 17:18
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("login")
    public UserValidedResult login(String accountNumber, String userPass, HttpServletRequest request){
        return userService.userValided(accountNumber, userPass);
    }

}
