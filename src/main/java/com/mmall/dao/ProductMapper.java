package com.mmall.dao;

import com.mmall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 查询列表
     * @return
     */
    List<Product> selectList();

    /**
     * 根据商品名或产品ID查询产品
     * @param productName
     * @param productId
     * @return
     */
    List<Product> selectByNameAndProductId(@Param("productName") String productName, @Param("productId") Integer productId);

    /**
     * 根据商品名或产品IDS查询商品
     * @param productName，这就是kerword
     * @param categoryIdList
     * @return
     */
    List<Product> selectByNameAndCategoryIds(@Param("productName")String productName,@Param("categoryIdList")List<Integer> categoryIdList);
}