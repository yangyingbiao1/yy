package com.yy.user.service.impl;

import com.yy.user.bean.UserInfo;
import com.yy.user.mapper.UserMapper;
import com.yy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserInfo> getUserInfoListAll() {
        List<UserInfo> userInfoList = userMapper.selectAll();
        return userInfoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userMapper.insertSelective(userInfo);

    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userMapper.updateByPrimaryKeySelective(userInfo);

    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {

        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);
        userMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void delUser(UserInfo userInfo) {
        userMapper.deleteByPrimaryKey(userInfo.getId());

    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
