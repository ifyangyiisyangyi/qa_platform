package com.yang.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class QaReport {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String prdAddr;   // 字段命名必须是驼峰，命名成prd_addr，会查不到结果
    private String devAddr;
    private String qa;
    private String dev;
    private String bugAddr;
    private Integer openBug;
    private Integer closeBug;
    private Integer totalBug;
    private String summary;
}
