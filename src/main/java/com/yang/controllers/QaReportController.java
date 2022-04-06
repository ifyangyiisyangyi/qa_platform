package com.yang.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.QaReport;
import com.yang.request.PageQo;
import com.yang.response.ResultVO;
import com.yang.service.QaReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "qa/report")
public class QaReportController {

    @Autowired
    QaReportService qaReportService;

    // 列表
    @PostMapping(value = "list")
    public ResultVO<?> list(@RequestBody PageQo pageQo) {
        return new ResultVO<>(qaReportService.list(pageQo));
    }
}
