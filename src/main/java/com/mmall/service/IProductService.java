package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;

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
}
