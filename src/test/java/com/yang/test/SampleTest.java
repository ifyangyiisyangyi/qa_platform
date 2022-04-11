package com.yang.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.bean.Link;
import com.yang.bean.QaReport;
import com.yang.bean.User;
import com.yang.mapper.LinkMapper;
import com.yang.mapper.QaReportMapper;
import com.yang.mapper.UserMapper;
import com.yang.response.ResultVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QaReportMapper qaReportMapper;
    @Autowired
    private LinkMapper linkMapper;

    /**
     * 测试查询
     */

    @Test
    // SELECT id,username,password,email FROM user WHERE id=?
    public void testSelectById() {
        User user = userMapper.selectById(11);
        System.out.println(user.toString());
    }

    @Test
    // SELECT id,username,password,email FROM user WHERE id IN ( ? , ? )
    public void testselectBatchIds() {
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2));
        userList.forEach(System.out::println);
    }

    @Test
    // SELECT id,username,password,email FROM user
    public void testSelect() {
        System.out.println("------selectAll method test-----");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    // SELECT id,username,password,email FROM user WHERE username = ?
    public void testSelectByMap() {
        HashMap<String, Object> users = new HashMap<>();
        users.put("username", "yy");
        List<User> userList = userMapper.selectByMap(users);
        userList.forEach(System.out::println);
    }

    // 测试插入
//    @Test
//    public void testInsert() {
//        User user = new User();
//        user.setUsername("peter");
//        user.setPassword("123");
//        user.setEmail("qq.com");
//        int insert = userMapper.insert(user);
//        List<User> userList = userMapper.selectList(null);
//        userList.forEach(System.out::println);
//    }

    @Test
    public void testQaReport() {
        QaReport qaReport = new QaReport();
        qaReport.setQa("yy");
        int insert = qaReportMapper.insert(qaReport);
        List<QaReport> qaReports = qaReportMapper.selectList(null);
        qaReports.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        System.out.println("-------------------------------------3534543");
        QueryWrapper<QaReport> wrapper = new QueryWrapper<>();
        wrapper.eq("qa", "yy");
        Page<QaReport> page = new Page<>(1, 2);
        qaReportMapper.selectPage(page, null);
        System.out.println(new ResultVO<>(page));

        System.out.println(qaReportMapper.selectById(3));
    }

    @Test
    // 测试逻辑删除
    public void testDelete() {
        userMapper.deleteById(12);
    }

    @Test
    public void testLink() {
        List<Link> links = linkMapper.selectList(null);
        links.forEach(System.out::println);
    }
}