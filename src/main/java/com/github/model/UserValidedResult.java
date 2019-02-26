package com.github.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lidefu
 * @date 2019/2/26 15:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserValidedResult {

    private int status;

    private String msg;

    private String token;

    private UserInfo userInfo;

}
