package com.yang.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.Recode;
import com.yang.request.PageQo;
import com.yang.response.ResultVO;
import com.yang.service.RecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yy
 * @since 2022-04-14
 */
@RestController
@RequestMapping("/recode")
public class RecodeController {
    @Autowired
    private RecodeService recodeService;

    @PostMapping("list")
    public Object list(@RequestBody @Valid PageQo pageQo) {
        Page<Recode> page = new Page<>(pageQo.getPageNum(), pageQo.getPageSize());
        return new ResultVO<>(recodeService.page(page, null));
    }
}

