package com.yang.service;

import com.yang.bean.User;
import com.yang.request.LoginQo;
import com.yang.request.RegisterQo;

public interface UserService {
    User login(LoginQo loginQo);
    User register(RegisterQo registerQo);
}
