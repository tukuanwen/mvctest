package com.tu.mvctest.controller;

import com.tu.mvctest.dao.entity.ClassTab;
import com.tu.mvctest.dao.entity.UserTab;
import com.tu.mvctest.server.ClassService;
import com.tu.mvctest.server.UserService;
import com.tu.mvctest.server.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * userInfo操作类，对UserInfo进行增删改查操作
 */
@Controller
@RestController
public class UserInfoHandler {

    //注入userService
    @Autowired
    private UserService userService;
    @Autowired
    private ClassService classService;

    private String MESSAGE_CODE = "SESUCESS";
    private String MESSAGE_STR = "请求成功";

    /**
     * 查询所有UserInfo列表
     */
    @RequestMapping(value="/doGetUserInfoByList",method = RequestMethod.GET)
    public String doGetUserInfoByList(Map<String, Object> map){

        List<UserTab> userTabList = userService.doGetUserInfoByList(null);

        System.out.println("列表大小："+userTabList.size());
        for (UserTab userTab : userTabList) {
            System.out.println("查询出的用户名字"+userTab.getUserName());
            if(userTab.getClassTab()!=null)
                System.out.println("班级名字"+userTab.getClassTab().getClassName());
            else
                System.out.println("" +
                        "未查询到班级");
        }

        map.put("userTabList", userTabList);

        return "listUserInfo";
    }

    /**
     * 根据UserId查询UserInfo
     */
    @RequestMapping(value = "/doGetUserInfoById/{userId}", method = RequestMethod.GET)
    public String doGetUserInfoById(@PathVariable("userId") Integer userId, Map<String, UserTab> map){

        System.out.println("进入了详情查询页面");
        UserTab userTab = userService.doGetUserInfo(userId);

        map.put("userInfo", userTab);

        return "getUserInfo";
    }

    /**
     * 增加UserInfo实体
     */
    @RequestMapping(value = "/doIncrUserInfo", method = RequestMethod.POST)
    public String doIncrUserInfo(@ModelAttribute("userTab")UserTab userTab, Map<String, String> map){



        System.out.println("用户名："+userTab.getUserName());
        System.out.println("邮  箱："+userTab.getUserMail());

        int num = userService.doIncrUserInfo(userTab);

        if(num <= 0){
            MESSAGE_CODE = "FAILURE";
            MESSAGE_STR = "添加UserInfo失败";
        }

        map.put("MESSAGE", MESSAGE_CODE);
        return "redirect:/doGetUserInfoByList";
    }

    /**
     * 修改UserInfo实体
     */
    @RequestMapping(value = "/doDecrUserInfoById", method = RequestMethod.PUT)
    public String doDecrUserInfoById(UserTab userTab,Map<String, String> map){

        int num = userService.doUpdUserInfo(userTab);

        if(num <= 0)
            MESSAGE_CODE = "FAILURE";
        map.put("MESSAGE", MESSAGE_CODE);
        return "redirect:/doGetUserInfoById/{"+userTab.getUserId()+"}";
    }

    /**
     * 查询classTab
     */
    @RequestMapping(value = "/doInitIncrUserInfo", method = RequestMethod.GET)
    public String doInitIncrUserInfo(Map<String, Object> map){
        System.out.println("进入获取classTab");
        List<ClassTab> classTabList = classService.getClassInfoByList();
        System.out.println("班级数量："+classTabList.size());
        for (ClassTab classTab : classTabList) {
            System.out.println(classTab.getClassName());
        }

        map.put("classTabList", classTabList);
        map.put("userTab", new UserTab());

        return "incrUserInfo";
    }


    public static void main(String[] args) {
        double sum1 = 11.5+23.9+8+49.95+17+18.3+16+202+111.73+43.56+68.08+51.24+14+83.25+5+38+263.5+182.8+16+39+159+131.59+37.1+29.6;
        double sum2 = 83.44+18+1+20+5+7+18.35+55+17.79+24.83+17.7+20+24+19.91+1.49+35.9+85.02+52.06+24;
        System.out.println(sum1+sum2);
    }

}
