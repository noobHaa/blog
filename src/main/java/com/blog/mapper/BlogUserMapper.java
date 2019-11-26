package com.blog.mapper;

import com.blog.entity.BlogUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.entity.vo.UserVo;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
public interface BlogUserMapper extends BaseMapper<BlogUser> {

    @Select({
            "select id,name,phone from blog_user where id=#{userId}"
    })
    @ResultType(UserVo.class)
    UserVo getUserInfo(Integer userId);
}
