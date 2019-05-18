package com.jf.crud.controller;

import com.jf.crud.util.Msg;
import com.jf.crud.bean.User;
import com.jf.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 获取所有user表信息
     */
    @RequestMapping(value = "/users")
    @ResponseBody
    public Msg getAll() {
        List<User> users = userService.getAll();
        return Msg.success().add("users", users);
    }
    /**
     * 登录
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Msg Login(String username,String password) {
        if (userService.Login(username,password)) {
            User user = userService.loginGetId(username);
            Msg msg;
            if (user.getAuthority()==2) {
                User seller = userService.loginSeller(user.getId());
                msg = Msg.success().add("user", seller);
            } else {
                User userList = userService.loginGetUser(user.getId());
                msg = Msg.success().add("user", userList);
            }
            return msg;
        } else {
            return Msg.fail();
        }
    }
    /**
     * 新增一条记录
     */
    @RequestMapping(value = "/userInsert",method = RequestMethod.POST)
    @ResponseBody
    public Msg userInsert(@Valid User user) {
        userService.insertUser(user);
        return Msg.success();
    }
    /**
     * 注册
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public Msg insertUser(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            userService.insertUser(user);
            return Msg.success();
        }
    }
    /**
     * 根据id修改更新
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg UpdateUser(User user) {
        if (userService.UpdateUser(user)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/user/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg DeleteUser(@PathVariable("ids")String ids) {
        if (ids.contains("-")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            userService.DeleteBatch(del_ids);
        } else {
            userService.DeleteUser(Integer.parseInt(ids));
        }
        return Msg.success();
    }
}
