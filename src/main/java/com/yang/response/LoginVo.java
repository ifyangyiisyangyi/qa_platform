package com.yang.response;

import lombok.Data;

@Data
public class LoginVo {
    private Integer id;
    private String username;
    private String email;
    private String token;
}
