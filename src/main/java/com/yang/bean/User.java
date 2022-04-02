package com.yang.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@TableName("qa_platform")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NonNull
    private String username;
    private String password;
    private String email;
}

