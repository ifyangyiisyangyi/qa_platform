package com.yang.test;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
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

import java.util.ArrayList;
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

    /**
     * mabatisplus代码自动生成器
     */
    @Test
    public void testAutoGenerate() {
        // 构建代码自动生成器对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); // /Users/yangyi/Documents/yy_code/qa_platform
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("yy");
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
//        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2. 设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://39.100.27.239:3306/qa_platform?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root123");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3. 包的配置  生成的代码放在项目的位置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.yang");
        pc.setEntity("bean");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(("recode").split(","));
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);        // 自动lombok，是否使用lombok完成Entity实体标注Getting Setting ToString 方法；
        strategy.setLogicDeleteFieldName("deleted"); // 逻辑删除

        // 自动填充配置
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);//创建时间
        TableFill gmtModified = new TableFill("update_time",
                FieldFill.INSERT_UPDATE);//修改时间
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        mpg.setStrategy(strategy);
        mpg.execute();
    }
}