package com.blog.resolvers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.annotation.CurrentUser;
import com.blog.base.Constant;
import com.blog.entity.BlogUser;
import com.blog.entity.vo.UserVo;
import com.blog.service.IBlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@Component
public class CurrentUserResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private IBlogUserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(UserVo.class) &&
                methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Integer userId = (Integer) nativeWebRequest.getAttribute(Constant.CURRENT_USER_ID, NativeWebRequest.SCOPE_REQUEST);
        if (null != userId) {
            return userService.getUserInfo(userId);
        }
        throw new MissingServletRequestPartException(Constant.CURRENT_USER_ID);
    }
}
