package com.mmall.util;

import java.math.BigDecimal;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.util
 * @Author: 爱迪生
 * @CreateTime: 2018-11-23 16:19
 * @Description: BigDecimal工具类
 */
public class BigDecimalUtil {

    private BigDecimalUtil(){

    }

    /**
     * 两个数相加
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal add(double v1,double v2){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    /**
     * 所有数相加（是add方法的扩展）
     * @param v
     * @return
     */
    public static BigDecimal addAll(double...v ){

        BigDecimal bigAdd = new BigDecimal("0");
        for(double v1 : v){
            bigAdd =bigAdd.add(new BigDecimal(Double.toString(v1)));
        }
        return bigAdd;
    }

    /**
     * addAll测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(addAll(0.1,0.5,0.3));
    }

    /**
     * 减
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal sub(double v1,double v2){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    /**
     * 乘
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal mul(double v1,double v2){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    /**
     * 除
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal div(double v1,double v2){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);//保留两位小数，四舍五入
    }


}
