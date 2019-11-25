package com.blog.service.impl;

import com.blog.entity.BlogUser;
import com.blog.mapper.BlogUserMapper;
import com.blog.service.IBlogUserService;
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
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {

}
