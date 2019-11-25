package com.blog.service.impl;

import com.blog.entity.BlogArticle;
import com.blog.mapper.BlogArticleMapper;
import com.blog.service.IBlogArticleService;
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
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements IBlogArticleService {

}
