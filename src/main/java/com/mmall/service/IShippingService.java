package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

/**
 * @description:地址管理接口
 * @author:zh
 * @date:2019/1/7
 */
public interface IShippingService {

    /**
     * 新增地址
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse add(int userId, Shipping shipping);

    /**
     * 根据用户删除地址
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse<String> del(int userId,int shippingId);

    /**
     * 根据用户更新
     * @param userId
     * @param shipping
     * @return
     */
    ServerResponse update(int userId, Shipping shipping);

    /**
     * 查询地址
     * @param userId
     * @param shippingId
     * @return
     */
    ServerResponse<Shipping> select(int userId, int shippingId);

    /**
     * 分页列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> list(int userId, int pageNum, int pageSize);
}
