package com.mmall.common;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.common
 * @Author: sanhaowuai
 * @CreateTime: 2018-10-14 00:13
 * @Description: 常量类
 */
public class Const {

    //当前用户
    public static final String CURRENT_USER = "currentUser";
    //内部接口类实现用户分组，使用枚举类也是可以的，只是显得过于臃肿
    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }
    //注册实时校验判断type是email
    public static final String EMAIL = "email";
    //注册实时校验判断type是username
    public static final String USERNAME = "username";
}
