package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

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

    /**
     * 获取当前节点的子节点
     * @param categoryId
     * @return
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    /**
     * 递归查询本节点的id及孩子节点的id
     * @param categoryId
     * @return
     */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
