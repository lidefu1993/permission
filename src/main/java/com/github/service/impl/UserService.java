package com.github.service.impl;

import com.github.model.UserInfo;
import com.github.model.UserValidedResult;
import com.github.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author lidefu
 * @date 2019/2/26 15:36
 */
@Service
public class UserService implements IUserService {

    @Override
    public UserValidedResult userValided(String accountNumber, String userPass) {
        if("ldf".equals(accountNumber) && "123".equals(userPass)){
            return UserValidedResult.builder().status(1).msg("成功").token("token").userInfo(new UserInfo()).build();
        }
        return UserValidedResult.builder().status(2).msg("失败").build();
    }

}
