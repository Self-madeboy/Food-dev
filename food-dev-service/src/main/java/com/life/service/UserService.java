package com.life.service;

import com.life.pojo.Users;
import com.life.pojo.bo.UserBO;

/**
 * @author jc
 */
public interface UserService {
    /**
     * 判断用户名是否存在 存在用户返回true
     *
     * @param username
     * @return
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 判断用户名是否存在
     *
     * @param userBO
     * @return
     */
    Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     *
     * @param username
     * @param password
     * @return
     */
    Users queryUserForLogin(String username, String password);
}
