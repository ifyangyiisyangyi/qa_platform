package com.yang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.QaReport;
import com.yang.request.PageQo;
import org.springframework.stereotype.Service;


@Service
public interface QaReportService{

    Page<QaReport> list(PageQo pageQo);
    QaReport add(QaReport qaReport);
    Boolean del(Integer id);
    QaReport update(QaReport qaReport);
}
