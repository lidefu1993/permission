package com.github.helper.token;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 * @author lidefu
 * @date 2018/12/11 11:45
 */
@Data
public class CheckResult {
    private int errCode;

    private boolean success;

    private Claims claims;


    public static CheckResult ok(Claims claims){
        CheckResult checkResult = new CheckResult();
        checkResult.setSuccess(true);
        checkResult.setClaims(claims);
        return checkResult;
    }

    public static CheckResult fail(int errorCode){
        CheckResult checkResult = new CheckResult();
        checkResult.setSuccess(false);
        checkResult.setErrCode(errorCode);
        return checkResult;
    }
}
