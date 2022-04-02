package com.yang.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginQo {
    @NotBlank(message = "用户名不能为空")
    String username;
    @NotBlank(message = "密码不能为空")
    String password;
}
