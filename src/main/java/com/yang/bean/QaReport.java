package com.yang.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class QaReport {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String prd_addr;
    private String dev_addr;
    private String qa;
    private String dev;
    private String bug_addr;
    private Integer open_bug;
    private Integer close_bug;
    private Integer total_bug;
    private String summary;
}
