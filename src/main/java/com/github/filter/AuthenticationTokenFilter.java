package com.github.filter;

import com.github.helper.token.AnalysisResult;
import com.github.helper.token.TokenHelper;
import com.github.model.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lidefu
 * @date 2019/2/26 15:44
 */
public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    private static final String TOKEN_HEADER = "permission_token";

    @Value("${login.url}")
    private String loginUrl;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将 ServletRequest 转换为 HttpServletRequest 才能拿到请求头中的 token
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 尝试获取请求头的 token
        String authToken = httpRequest.getHeader(TOKEN_HEADER);
        System.out.println("loginUrl" + loginUrl);
        // 尝试拿 token 中的 username
        // 若是没有 token 或者拿 username 时出现异常，那么 username 为 null
        AnalysisResult analysisResult = TokenHelper.analysisToken(authToken, TokenHelper.TOKEN_SECRET, UserInfo.class);
        // 如果上面解析 token 成功并且拿到了 username 并且本次会话的权限还未被写入
        if (analysisResult != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // 检查用户带来的 token 是否有效
            // 包括 token 和 userDetails 中用户名是否一样， token 是否过期， token 生成时间是否在最后一次密码修改时间之前
            // 若是检查通过
            if (analysisResult.isSuccess()) {
                // 生成通过认证
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(analysisResult.getResult(), null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                // 将权限写入本次会话
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().print("{\"code\":\"403\",\"data\":\"\",\"message\":\"验证失败\"}");
                return;
            }
        }
        chain.doFilter(request, response);
    }

}
