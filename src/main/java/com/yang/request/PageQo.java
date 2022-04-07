package com.yang.request;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PageQo {
    @NotNull(message = "pageNum不能为空")
    Integer pageNum;
    @NotNull(message = "pageSize不能为空")
    Integer pageSize;
}
