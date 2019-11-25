package com.blog.service.impl;

import com.blog.entity.BlogCategory;
import com.blog.mapper.BlogCategoryMapper;
import com.blog.service.IBlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

}
