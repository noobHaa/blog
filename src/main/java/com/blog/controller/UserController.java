package com.blog.controller;


import com.blog.annotation.CurrentUser;
import com.blog.entity.vo.UserVo;
import com.blog.service.IBlogUserService;
import com.blog.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisTemplate<String, Object> template;
    @Autowired
    private IBlogUserService userService;

    @PostMapping("/getVerifyCode")
    public ResultModel getVerifyCode(@RequestParam String phone) {
        return userService.getVerifyCode(phone);
    }

    @PostMapping("/loginByPhone")
    public ResultModel loginByPhone(@RequestParam String verifyCode,
                                    @RequestParam String phone) {
        return userService.loginByPhone(phone, verifyCode);
    }

    @PostMapping("/login")
    public ResultModel login(@RequestParam String username,
                             @RequestParam String password) {
        return userService.login(username, password);
    }

    @PostMapping("/getUserInfo")
    public ResultModel getUserInfo(@CurrentUser UserVo userVo) {
        return ResultModel.success(userVo);
    }
}
