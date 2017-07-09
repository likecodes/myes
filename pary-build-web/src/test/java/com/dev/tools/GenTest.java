package com.dev.tools;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2017/7/7.
 */
@RunWith(SpringRunner.class)
public class GenTest {

    private File configFile;

    @Before
    public void before() {
        //读取mybatis参数
        configFile = new File("E:\\IdeaProject\\myes\\pary-build-web\\src\\test\\resources\\generatorConfig.xml");
//        configFile = new File("E:\\ideaProject\\party-build\\pary-build-web\\src\\test\\resources\\generatorConfig.xml");

    }

    @Test
    public void test() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
