package com.yang.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.Link;
import com.yang.mapper.LinkMapper;
import com.yang.request.PageQo;
import com.yang.service.LinkService;
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

    // 分页查询
    @Override
    public Page<Link> list(PageQo pageQo) {
        Page<Link> page = new Page<>(pageQo.getPageNum(), pageQo.getPageSize());
        linkMapper.selectPage(page, null);
        return page;
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
