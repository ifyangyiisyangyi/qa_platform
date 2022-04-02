package com.yang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
