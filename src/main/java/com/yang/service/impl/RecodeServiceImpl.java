package com.yang.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.Recode;
import com.yang.mapper.RecodeMapper;
import com.yang.service.RecodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yy
 * @since 2022-04-14
 */
@Service
public class RecodeServiceImpl extends ServiceImpl<RecodeMapper, Recode> implements RecodeService {

    @Autowired
    private RecodeMapper recodeMapper;

    @Override
    public boolean writeLog(Recode recode) {
        return recodeMapper.insert(recode) > 0;
    }
}
