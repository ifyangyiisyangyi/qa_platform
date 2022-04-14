package com.yang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.Recode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yy
 * @since 2022-04-14
 */
public interface RecodeService extends IService<Recode> {
    boolean writeLog(Recode recode);
}
