package wang.l1n.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.l1n.dao.UserMapper;
import wang.l1n.entity.User;
import wang.l1n.service.UserService;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/5 21:25
 * @description：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User checkLogin(String username, String password) {
        return userMapper.checkLogin(username,password);
    }

    @Override
    public void addUser(String username, String password) {
        userMapper.addUser(username,password);
    }
}
