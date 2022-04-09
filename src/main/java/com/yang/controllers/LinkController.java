package com.yang.controllers;


import com.yang.annotation.LoginRequired;
import com.yang.bean.Link;
import com.yang.request.PageQo;
import com.yang.response.ResultVO;
import com.yang.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    // 分页查询
    @LoginRequired
    @PostMapping("list")
    public ResultVO<?> list(@RequestBody @Valid PageQo pageQo) {
        return new ResultVO<>(linkService.list(pageQo));
    }
    // 新增
    @PostMapping(value = "add")
    public ResultVO<?> add(@RequestBody Link link) {
        return new ResultVO<>(linkService.add(link));
    }
    // 修改
    @PostMapping(value = "update")
    public ResultVO<?> update(@RequestBody Link link) {
        return new ResultVO<>(linkService.update(link));
    }
    // 删除
    @GetMapping(value = "del")
    public ResultVO<?> del(@RequestParam Integer id) {
        return new ResultVO<Object>(linkService.del(id));
    }

}
