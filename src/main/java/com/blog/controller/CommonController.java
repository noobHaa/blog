package com.blog.controller;


import com.blog.annotation.CurrentUser;
import com.blog.entity.vo.UserVo;
import com.blog.service.IBlogMenuService;
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
@RequestMapping("/menu")
public class CommonController {

    @Autowired
    private IBlogMenuService menuService;

    @PostMapping("/getMenu")
    public ResultModel getMenu(@CurrentUser UserVo userVo) {
        return menuService.getMenu();
    }
}
