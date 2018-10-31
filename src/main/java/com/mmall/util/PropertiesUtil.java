package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.util
 * @Author: 爱迪生
 * @CreateTime: 2018-10-29 09:31
 * @Description: 配置文件公共类
 */
public class PropertiesUtil {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;
    //静态代码块，随着类初始化执行，只执行一次
    static {
        String fileName = "mmall.properties";
        props = new Properties();
        try {
            // Class.getClassLoader.getResourceAsStream(String path) ：默认是从ClassPath根下获取
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    public static String getProperty(String key){

        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    /**
     * 若key没有对应值，则默认获取defaultValue
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(String key,String defaultValue){

        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }

}
