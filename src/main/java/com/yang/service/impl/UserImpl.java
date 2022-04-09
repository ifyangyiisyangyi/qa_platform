package com.yang.service.impl;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.bean.User;
import com.yang.interceptor.APIException;
import com.yang.mapper.UserMapper;
import com.yang.request.LoginQo;
import com.yang.request.RegisterQo;
import com.yang.response.LoginVo;
import com.yang.response.ResultCode;
import com.yang.service.UserService;
import com.yang.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Auth yangyi
 * @Date 2022-04-01 18:59:09
 */
@Service
@Slf4j
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     */
    @Override
    public LoginVo login(LoginQo loginQo) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", loginQo.getUsername());
        User user = userMapper.selectOne(wrapper);
        // 判断用户是否存在
        if (user == null) {
            throw new APIException(ResultCode.USER_NOT_EXIST);
        }
        // 判断密码是否正确
        if (!DigestUtils.md5DigestAsHex(loginQo.getPassword().getBytes(StandardCharsets.UTF_8)).equals(user.getPassword())) {
            throw new APIException(ResultCode.USER_LOGIN_FAIL);
        }
        LoginVo loginVo = new LoginVo();
        loginVo.setId(user.getId());
        loginVo.setUsername(user.getUsername());
        loginVo.setEmail(user.getEmail());
        loginVo.setToken(JwtUtil.sign(user.getId()));
        log.info(user.getUsername() + "登录成功");
        return loginVo;
    }

    /**
     * 注册
     */
    public User register(RegisterQo registerQo) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", registerQo.getUsername());
        Long aLong = userMapper.selectCount(wrapper);
        if (aLong > 0) {
            throw new APIException(ResultCode.FAILED, "用户已存在");
        }
        User user = new User();
        user.setUsername(registerQo.getUsername());
        // 密码md5加密
        user.setPassword(DigestUtils.md5DigestAsHex(registerQo.getPassword().getBytes(StandardCharsets.UTF_8)));
        if (userMapper.insert(user) > 0) {
            return user;
        }
        return null;
    }
}
