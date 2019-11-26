package com.blog.service;

import com.blog.entity.BlogUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.vo.UserVo;
import com.blog.vo.ResultModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
public interface IBlogUserService extends IService<BlogUser> {

    ResultModel login(String username, String password);

    ResultModel getVerifyCode(String phone);

    ResultModel loginByPhone(String phone, String verifyCode);

    UserVo getUserInfo(Integer userId);
}
