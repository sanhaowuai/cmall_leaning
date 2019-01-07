package com.mmall.dao;

import com.mmall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    /**
     * 根据shippingId和userId删除地址，防止别的用户删除
     * @param userId
     * @param shippingId
     */
    int deleteByShippingIdUserId(@Param("userId") int userId,@Param("shippingId") int shippingId);

    /**
     * 根据shippingId和userId更新地址
     * @param shipping
     * @return
     */
    int updateByShipping(Shipping shipping);

    /**
     * 查询地址
     * @param userId
     * @param shippingId
     * @return
     */
    Shipping selectByShippingIdUserId(@Param("userId") int userId,@Param("shippingId") int shippingId);

    /**
     * 分页列表
     * @param userId
     * @return
     */
    List<Shipping> selectByUserId(@Param("userId") int userId);
}