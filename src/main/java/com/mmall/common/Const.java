package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

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
    //商品排序
    public interface ProductListOrderBy{
        //使用Set而不使用List主要原因是Set的contains方法的时间复杂度是O(1),List是O(n),最好是Set
        //按照价格price降序或者升序
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }
    public interface Cart{
        int CHECKED = 1;//购物车选中状态
        int UN_CHECKED = 0;//购物车未选中状态

        //加入购物车功能
        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";//限制失败
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";//限制成功

    }
    //内部接口类实现用户分组，使用枚举类也是可以的，只是显得过于臃肿，还需增加描述。
    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }
    //注册实时校验判断type是email
    public static final String EMAIL = "email";

    //注册实时校验判断type是username
    public static final String USERNAME = "username";

    //前台商品状态(是否在线)
    public enum ProductStatusEnum{

        ON_SALE(1,"在线");
        private int code;
        private String value;
        ProductStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }
}
