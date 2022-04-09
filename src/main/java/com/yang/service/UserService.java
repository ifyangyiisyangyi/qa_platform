package com.yang.service;

import com.yang.bean.User;
import com.yang.request.LoginQo;
import com.yang.request.RegisterQo;
import com.yang.response.LoginVo;

public interface UserService {
    LoginVo login(LoginQo loginQo);
    User register(RegisterQo registerQo);
}
