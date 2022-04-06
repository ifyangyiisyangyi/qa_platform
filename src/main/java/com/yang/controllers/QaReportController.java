package com.yang.controllers;

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

    // 新增
    @PostMapping(value = "add")
    public ResultVO<?> add(@RequestBody QaReport qaReport) {
        return new ResultVO<>(qaReportService.add(qaReport));
    }

    //删除
    @GetMapping(value = "del")
    public ResultVO<?> del(@RequestParam Integer id) {
        return new ResultVO<>(qaReportService.del(id));
    }

    // 更新
    @PostMapping(value = "update")
    public  ResultVO<?> update(@RequestBody QaReport qaReport) {
        return new ResultVO<>(qaReportService.update(qaReport));
    }
}
