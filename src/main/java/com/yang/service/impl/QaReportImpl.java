package com.yang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.QaReport;
import com.yang.mapper.QaReportMapper;
import com.yang.request.PageQo;
import com.yang.service.QaReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QaReportImpl implements QaReportService {

    @Autowired
    QaReportMapper qaReportMapper;

    @Override
    public Page<QaReport> list(PageQo pageQo) {
        Page<QaReport> page = new Page<>(pageQo.getPageNum(), pageQo.getPageSize());
        qaReportMapper.selectPage(page, null);
        return page;
    }
}
