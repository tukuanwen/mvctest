package com.tu.redisDemo.mvctest.test;

import com.tu.redisDemo.mvctest.dao.entity.UserTab;

public class MyTest {

    public static void main(String[] args) throws Exception{

//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("D:\\iproject\\mvctest\\generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);

//        ApplicationContext context = new ClassPathXmlApplicationContext("D:/iproject/mvctest/src/main/resources/spring/beanFactoryXml.xml");
//        StudentBean bean = context.getBean("studentBean", StudentBean.class);
//
//        String info = bean.doString();
//
//        System.out.println(info);


//        String str1 = "通话";
//        String str2 = "重地";

        UserTab str1 = new UserTab();
        UserTab str2 = new UserTab();

        System.out.println("你好呀快捷键");
        System.out.println("哈哈HashCode:"+str1.hashCode()+" 嘻嘻HashCode:"+str2.hashCode());
        System.out.println(str1.equals(str2));

    }
}
