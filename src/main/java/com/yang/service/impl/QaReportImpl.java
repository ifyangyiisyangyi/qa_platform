package com.yang.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.QaReport;
import com.yang.exception.APIException;
import com.yang.mapper.QaReportMapper;
import com.yang.request.PageQo;
import com.yang.service.QaReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auth yangyi
 * @Date 2022-04-06 14:37:24
 */
@Service
public class QaReportImpl implements QaReportService {

    @Autowired
    QaReportMapper qaReportMapper;

    // 列表
    @Override
    public Page<QaReport> list(PageQo pageQo) {
        Page<QaReport> page = new Page<>(pageQo.getPageNum(), pageQo.getPageSize());
        qaReportMapper.selectPage(page, null);
        return page;
    }

    // 新增
    @Override
    public QaReport add(QaReport qaReport) {
        if (qaReportMapper.insert(qaReport) > 0) {
            return qaReport;
        }
        return null;
    }

    // 删除
    @Override
    public Boolean del(Integer id) {
        if (qaReportMapper.deleteById(id) > 0) {
            return true;
        }

        if (qaReportMapper.selectById(id) == null) {
            throw new APIException("数据不存在");
        }

        return null;
    }

    // 更新
    @Override
    public QaReport update(QaReport qaReport) {
        if (qaReportMapper.updateById(qaReport) > 0) {
            return qaReportMapper.selectById(qaReport.getId());
        }
        return null;
    }

}
