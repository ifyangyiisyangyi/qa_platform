package com.yang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.Link;
import com.yang.bean.Recode;
import com.yang.mapper.LinkMapper;
import com.yang.request.PageQo;
import com.yang.service.LinkService;
import com.yang.service.RecodeService;
import com.yang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auth yangyi
 * @Date 2022-04-07 14:52:17
 */
@Service
@Slf4j
public class LinkImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    @Autowired
    private RecodeService recodeService;

    // 分页查询
    @Override
    public Page<Link> list(PageQo pageQo) {
        Page<Link> page = new Page<>(pageQo.getPageNum(), pageQo.getPageSize());
        QueryWrapper<Link> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        return linkMapper.selectPage(page, wrapper);
    }

    // 新增
    @Override
    public Link add(Link link) {
        if (linkMapper.insert(link) > 0) {
            return link;
        }
        return null;
    }

    // 修改
    public Link update(Link link) {
        if (linkMapper.updateById(link) > 0) {
            return link;
        }
        return null;
    }

    // 删除
    public Boolean del(Integer id) {
        if (linkMapper.deleteById(id) > 0) {
            return true;
        }
        return null;
    }
}
