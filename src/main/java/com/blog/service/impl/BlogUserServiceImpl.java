package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.entity.BlogUser;
import com.blog.entity.vo.UserVo;
import com.blog.mapper.BlogUserMapper;
import com.blog.service.IBlogUserService;
import com.blog.util.AESUtil;
import com.blog.util.VerifyCode;
import com.blog.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户服务
 * </p>
 *
 * @author lilei
 * @since 2019-11-25
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {

    @Autowired
    private RedisTemplate template;

    @Autowired
    private BlogUserMapper userMapper;

    @Override
    public ResultModel getVerifyCode(String phone) {
        ValueOperations ops = template.opsForValue();
        String code = VerifyCode.code();
        ops.set(phone, code);
        template.expire(phone, 60, TimeUnit.SECONDS);
        return ResultModel.success(code);
    }

    @Override
    public ResultModel loginByPhone(String phone, String verifyCode) {
        ValueOperations ops = template.opsForValue();
        String code = (String) ops.get(phone);
        if (!verifyCode.equals(code)) {
            return ResultModel.error(ResultModel.CODE_ERROR);//验证码错误
        }
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("phone", phone);
        QueryWrapper<BlogUser> wrapper = new QueryWrapper<>();
        wrapper.allEq(paramMap);
        BlogUser user = userMapper.selectOne(wrapper);
        if (null != user && !"".equals(user.getName())) {
            String token = AESUtil.getEncrypt(UUID.randomUUID().toString().replace("-", ""));
            ops.set(token, user.getId());
            template.expire(token, 10 * 60, TimeUnit.SECONDS);
            return ResultModel.success(token);
        }
        return ResultModel.success();
    }

    @Override
    public UserVo getUserInfo(Integer userId) {
        return userMapper.getUserInfo(userId);
    }


    @Override
    public ResultModel login(String username, String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", username);
        paramMap.put("password", password);
        QueryWrapper<BlogUser> wrapper = new QueryWrapper<>();
        wrapper.allEq(paramMap);
        BlogUser user = userMapper.selectOne(wrapper);
        if (null != user && !"".equals(user.getName())) {
            ValueOperations ops = template.opsForValue();
            String token = AESUtil.getEncrypt(UUID.randomUUID().toString().replace("-", ""));
            ops.set(token, user.getId());
            template.expire(token, 10 * 60, TimeUnit.SECONDS);
            return ResultModel.success(token);
        }
        return ResultModel.error(ResultModel.USER_NOT_EXIST_ERROR);
    }
}
