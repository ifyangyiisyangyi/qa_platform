package com.yang.controller;

import com.yang.request.LoginQo;
import com.yang.request.RegisterQo;
import com.yang.response.ResultVO;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    public ResultVO<?> login(@RequestBody @Valid LoginQo loginQo) {
        return new ResultVO<>(userService.login(loginQo));
    }

    @PostMapping(value = "register")
    public ResultVO<?> register(@RequestBody @Valid RegisterQo registerQo) {
        return new ResultVO<>(userService.register(registerQo));
    }
}
