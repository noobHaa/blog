package com.blog.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.base.Constant;
import com.blog.entity.BlogUser;
import com.blog.service.IBlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 登录拦截器
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate template;

    @Autowired
    private IBlogUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().equals("/blog/user/login") || request.getRequestURI().equals("/blog/user/loginByPhone")
                || request.getRequestURI().equals("/blog/user/getVerifyCode")) {
            return true;
        }
        String token = request.getHeader(Constant.APP_TOKEN);
        if (null != token && !"".equals(token)) {
            ValueOperations ops = template.opsForValue();
            Integer userId = (Integer) ops.get(token);
            if (null != userId) {
                QueryWrapper<BlogUser> wrapper = new QueryWrapper<>();
                wrapper.eq("id", userId);
                BlogUser user = userService.getOne(wrapper);
                if (null != user) {
                    template.expire(token, 10 * 60, TimeUnit.SECONDS);
                    request.setAttribute(Constant.CURRENT_USER_ID, userId);
                    return true;
                }
            }
        }
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return false;
    }
}
