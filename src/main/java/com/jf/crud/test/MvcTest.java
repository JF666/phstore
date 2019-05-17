//package com.jf.crud.test;
//
//import com.github.pagehelper.PageInfo;
//import com.jf.crud.bean.User;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
///**
// * 使用spring测试模块提供的测试请求功能，测试CRUD请求的正确性
// */
//@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
//@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"}) //加载配置文件
//public class MvcTest {
//    //传入springMvc的ioc
//    @Autowired
//    WebApplicationContext context;
//    //虚拟MVC请求，获取到处理结果
//    MockMvc mockMvc;
//    @Before
//    public void initMockMvc() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//    @Test
//    public void testPage() throws Exception {
////        模拟请求拿到返回值
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
//                .param("pn", "2")).andReturn();
////    请求成功以后，请求域中会有pageInfo，我们可以去除pageInfo进行验证
//        MockHttpServletRequest request = result.getRequest();
//        PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
//        System.out.println("当前页码："+pi.getPageNum());
//        System.out.println("总页码："+pi.getPages());
//        System.out.println("总记录数："+pi.getTotal());
//        System.out.println("在页面需要连续显示的页码："+pi.getNavigateFirstPage());
////        int[] nums = pi.getNavigatepageNums();
////        for (int i : nums) {
////            System.out.print(" "+i);
////        }
////        System.out.println();
////        获取员工数据
//        List<User> list = pi.getList();
//        for (User user : list) {
//            System.out.println("ID："+user.getId());
//            System.out.println("Username："+user.getUsername());
//            System.out.println("Password："+user.getPassword());
//            System.out.println("Authority："+user.getAuthority());
//        }
//    }
//}
