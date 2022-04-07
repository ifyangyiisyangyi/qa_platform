package com.yang.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


@Data
@TableName(value = "linkages")
public class Link {
    @TableId(value = "id", type = IdType.AUTO) //自增主键
    private Integer id;
    private String name;
    private String link;
    private String describes;
    @TableLogic  // 逻辑删除
    private Integer deleted;
    private String createTime;
    private String updateTime;
}
