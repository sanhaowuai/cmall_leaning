package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.service
 * @Author: 爱迪生
 * @CreateTime: 2018-10-19 09:00
 * @Description: 产品管理接口
 */
public interface IProductService {

    /**
     * 新增或更新产品
     * @param product
     * @return
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
     * 修改产品销售状态
     * @param productId
     * @param status
     * @return
     */
    ServerResponse setSaleStatus(Integer productId,Integer status);

    /**
     * 获取产品的详细信息
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    /**
     * 获取产品List
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    /**
     * 搜索商品
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);

    /**
     * 前台获取详细信息
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);
}
