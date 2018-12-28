package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.service
 * @Author: 爱迪生
 * @CreateTime: 2018-11-09 13:22
 * @Description: 购物车接口
 */
public interface ICarService {

    /**
     * 添加商品
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    /**
     * 购物车更新商品数量
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count);

    /**
     * 删除商品
     * @param userId
     * @param productIds
     * @return
     */
    ServerResponse<CartVo> deleteProduct(Integer userId,String productIds);
}
