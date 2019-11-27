package com.blog.service;

import com.blog.entity.BlogMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.vo.ResultModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
public interface IBlogMenuService extends IService<BlogMenu> {

    ResultModel getMenu();
}
