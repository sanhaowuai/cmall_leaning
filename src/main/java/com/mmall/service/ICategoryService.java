package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 *@BelongsProject: cmall
 *@BelongsPackage: com.mmall.service
 *@Author: 爱迪生
 *@CreateTime: 2018-10-17 15:51
 *@Description: 分类管理接口
 */
public interface ICategoryService {

    /**
     * 添加分类
     * @param categoryname
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categoryname,Integer parentId);

    /**
     * 更新分类名字
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId,String categoryName);
}
