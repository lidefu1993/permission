package com.github.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lidefu
 * @date 2019/2/26 13:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    /**
     * 主键
     */
    private String userId;

    /**
     * 账号
     */
    private String accountNumber;

    /**
     * 密码
     */
    private String userPass;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 性别
     */
    private int userSex;

}
