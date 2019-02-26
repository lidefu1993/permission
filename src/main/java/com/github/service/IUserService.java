package com.github.service;

import com.github.model.UserValidedResult;

/**
 * @author lidefu
 * @date 2019/2/26 13:14
 */
public interface IUserService {

    /**
     * 用户验证
     * @param accountNumber 账号
     * @param userPass 密码
     * @return
     */
    UserValidedResult userValided(String accountNumber, String userPass);

}
