package wang.l1n.dao;

import org.apache.ibatis.annotations.Param;
import wang.l1n.entity.User;

public interface UserMapper {
    /**
     * 查询登录状态
     * @param username
     * @param password
     * @return
     */
    User checkLogin(@Param("username") String username,
                    @Param("password") String password);

    void addUser(@Param("username") String username, @Param("password") String password);
}
