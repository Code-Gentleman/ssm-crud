package wang.l1n.service;

import wang.l1n.entity.User;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/5 12:20
 * @description：
 */
public interface UserService {
    User checkLogin(String username, String password);

    void addUser(String username, String password);
}
