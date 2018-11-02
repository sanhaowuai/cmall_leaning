package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *@BelongsProject: cmall
 *@BelongsPackage: com.mmall.service.impl
 *@Author: 爱迪生
 *@CreateTime: 2018-10-17 15:52
 *@Description: 分类管理实现类
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

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

    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId){
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        //代替categoryList != null && categoryList.size()>0
        if(CollectionUtils.isEmpty(categoryList)){
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId){
        //guava提供，等同于 new HashSet<>()
        Set<Category> categorySet = Sets.newHashSet();
        findChildCategory(categorySet,categoryId);

        //guava提供，等同于 new ArrayList<>(),set无序不重复，list.有序重复
        List<Integer> categoryIdList = Lists.newArrayList();
        if(categoryId != null){
            if(CollectionUtils.isNotEmpty(categorySet)){
                for(Category categoryItem : categorySet){
                    categoryIdList.add(categoryItem.getId());
                }
            }
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }

    /**
     * 递归算法,算出子节点
     * @param categorySet
     * @param categoryId
     * @return
     * 注意：下方方法中的set可以不使用，因为查询出来的id都不是重复的，如果最终需要的是parent_id（此时会有重复，如果重写parent_id，则不会出现重复），那么就需要了。
     * 只是为了练习而写，Set中的对象需要重写hashCode与equals方法。String无需重写是因为String已经重写了。
     */
    private Set<Category> findChildCategory(Set<Category> categorySet ,Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category != null){
            categorySet.add(category);
        }
        //查找子节点,递归算法一定要有一个退出的条件
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        if(CollectionUtils.isNotEmpty(categoryList)){
            for(Category categoryItem : categoryList){
                findChildCategory(categorySet,categoryItem.getId());
            }
        }
        return categorySet;
    }
}
