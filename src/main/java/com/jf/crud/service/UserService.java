package com.jf.crud.service;

import com.jf.crud.bean.User;
import com.jf.crud.bean.UserExample;
import com.jf.crud.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getAll() {
        List<User> user = userMapper.selectByExample(null);
        return user;
    }
    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }
    public User loginGetId(String username) {
        return userMapper.selectByUsername(username);
    }
    public User loginGetUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
    public User loginSeller(Integer id) {
        return userMapper.selectWithSeller(id);
    }
    public Boolean Login(String username,String password) {
        User user = userMapper.selectByUsername(username);
        return user.getPassword().equals(password);
    }
    public Boolean UpdateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user)!=0;
    }
    public void DeleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
    public void DeleteBatch(List<Integer> ids) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIn(ids);
        userMapper.deleteByExample(userExample);
    }
}
