//package com.jf.crud.test;
//
//import com.jf.crud.bean.Buyer;
//import com.jf.crud.bean.User;
//import com.jf.crud.dao.BuyerMapper;
//import com.jf.crud.dao.UserMapper;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.UUID;
//
///**
// * 测试dao层的工作
// * 推荐spring的项目可以使用spring的单元测试，可以自动注入我们需要的组件
// * 1、导入springTest模块
// * 2、@ContextConfiguration指定spring配置文件的位置
// */
//@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
//public class MapperTest {
//    @Autowired
//    BuyerMapper bm;
//    @Autowired
//    UserMapper um;
//    @Autowired
//    SqlSession sqlSession;
//    @Test
//    public void testCRUD(){
////        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
////        BuyerMapper bean = ioc.getBean(BuyerMapper.class);
////        System.out.println(bm);
////        System.out.println(um);
////        um.insertSelective(new User(null, "aaa", "123", "1"));
////        um.insertSelective(new User(null, "bbb", "123", "1"));
////        bm.insertSelective(new Buyer(null, 1, "aaa", "9999", "南京", "15199999999", "方1"));
////        bm.insertSelective(new Buyer(null, 2, "bbb", "9999", "南京", "15299999999", "方2"));
////        UserMapper um1 = sqlSession.getMapper(UserMapper.class);
////        for (int i = 0;i < 10;i++) {
////            String uname = UUID.randomUUID().toString().substring(0,2) + i;
////            String pass = UUID.randomUUID().toString().substring(3,5) + i;
////            um1.insertSelective(new User(null, uname, pass, "1"));
////        }
//    }
//}
