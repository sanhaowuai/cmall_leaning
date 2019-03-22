package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.util
 * @Author: 爱迪生
 * @CreateTime: 2018-10-29 10:28
 * @Description: 时间处理类,joda-time
 */
public class DateTimeUtil {

    public static final String STANDRD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 字符串转为时间
     * @param dateTimeStr
     * @param formatStr
     * @return
     */
    public static Date strToDate(String dateTimeStr, String formatStr){

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /**
     * 日起转为字符串
     * @param date
     * @param formatStr
     * @return
     */
    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    /**
     * 标准格式字符串转为日期
     * @param dateTimeStr
     * @return
     */
    public static Date strToDate(String dateTimeStr){

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDRD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /**
     * 标准格式日期转为字符串
     * @param date
     * @return
     */
    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
    }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDRD_FORMAT);
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.strToDate("2018-10-29 10:55:55","yyyy-MM-dd HH:mm:ss"));
    }
}
