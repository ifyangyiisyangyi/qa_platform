package com.yang.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginQo {
    @NotNull(message = "用户名不能为空")
    String username;
    @NotNull(message = "密码不能为空")
    String password;
}
