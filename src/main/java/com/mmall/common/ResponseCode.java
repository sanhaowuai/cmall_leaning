package com.mmall.common;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.common
 * @Author: sanhaowuai
 * @CreateTime: 2018-10-13 17:39
 * @Description: 响应编码枚举类
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;
    //枚举类就是有包含有固定数量实例（并且实例的值也固定）的特殊类,构造器默认使用private修饰
    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
