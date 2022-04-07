package com.yang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.Link;
import com.yang.request.PageQo;

public interface LinkService {
    Page<Link> list(PageQo pageQo);
    Link add(Link link);
    Link update(Link link);
    Boolean del(Integer id);
}
