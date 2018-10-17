package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@BelongsProject: cmall
 *@BelongsPackage: com.mmall.service.impl
 *@Author: 爱迪生
 *@CreateTime: 2018-10-17 15:52
 *@Description: 分类管理实现类
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public ServerResponse addCategory(String categoryname,Integer parentId){

        if(parentId == null || StringUtils.isBlank(categoryname)){
            return ServerResponse.createByErrorMessage("添加分类参数错误");
        }
        Category category = new Category();
        category.setName(categoryname);
        category.setParentId(parentId);
        category.setStatus(true);
        int rowCount = categoryMapper.insert(category);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("添加分类成功");
        }
        return ServerResponse.createByErrorMessage("添加分类失败");
    }

    public ServerResponse updateCategoryName(Integer categoryId,String categoryName){

        if(categoryId == null || StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("更新分类参数错误");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("更新分类名字成功");
        }
        return ServerResponse.createByErrorMessage("更新分类名字失败");
    }
}
