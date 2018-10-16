package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

import javax.jws.soap.SOAPBinding;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.service
 * @Author: sanhaowuai
 * @CreateTime: 2018-10-13 17:10
 * @Description: 用户接口
 */
public interface IUserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 实时校验用户名和email
     *
     * @param str,value值
     * @param type，是username或者email
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 查询安全问题
     *
     * @param username
     * @return
     */
    ServerResponse selectQuestion(String username);

    /**
     * 校验回答问题是否正确
     *
     * @param username
     * @param question
     * @param answer
     * @return
     */
    ServerResponse<String> checkAnswer(String username, String question, String answer);

    /**
     * 忘记密码中的重置密码
     *
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    /**
     * 登陆状态下的密码重置
     * @param passwordOld
     * @param passwordNew
     * @param user
     * @return
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 更新用户个人信息
     * @param user
     * @return
     */
    ServerResponse<User> updateInformation(User user);

    /**
     * 获取详细信息
     * @param userId
     * @return
     */
    ServerResponse<User> getInformation(int userId);
}
