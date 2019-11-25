package com.blog.controller;


import com.blog.service.IBlogMenuService;
import com.blog.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IBlogMenuService menuService;

    @PostMapping("/getmenu")
    public ResultModel getMenu(){
        return ResultModel.success(menuService.getById(1));
    }

}
