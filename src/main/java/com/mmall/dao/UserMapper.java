package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    int checkUsername(String username);

    /**
     * 登陆查询
     * @param username
     * @param password
     * @return
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 查询邮箱是否存在
     * @param email
     * @return
     */
    int checkEmail(String email);

    /**
     * 根据用户名获取安全问题
     * @param username
     * @return
     */
    String selectQuestionByUsername(String username);

    /**
     * 校验回答问题是否正确
     * @param username
     * @param question
     * @param answer
     * @return
     */
    int checkAnswer(@Param("username")String username, @Param("question")String question, @Param("answer")String answer);

    /**
     * 根据用户名更改密码
     * @param username
     * @param passwordNew
     * @return
     */
    int updatePasswordByUsername(@Param("username")String username,@Param("passwordNew")String passwordNew);

    /**
     * 检查密码
     * @param password
     * @param userId
     * @return
     */
    int checkPassword(@Param(value = "password")String password,@Param("userId")int userId);
}