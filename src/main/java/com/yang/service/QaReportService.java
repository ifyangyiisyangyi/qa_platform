package com.yang.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.QaReport;
import com.yang.request.PageQo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QaReportService{

    Page<QaReport> list(PageQo pageQo);
}
