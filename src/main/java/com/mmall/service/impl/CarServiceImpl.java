package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CartMapper;
import com.mmall.pojo.Cart;
import com.mmall.service.ICarService;
import com.mmall.vo.CartProductVo;
import com.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.service.impl
 * @Author: 爱迪生
 * @CreateTime: 2018-11-09 13:23
 * @Description: 购物车实现类
 */
@Service("iCarService")
public class CarServiceImpl implements ICarService {

    @Autowired
    private CartMapper cartMapper;

    public ServerResponse add(Integer userId,Integer productId,Integer count){

        Cart cart = cartMapper.selectCartByUserIdProductId(userId,productId);
        if(cart == null){
            //这个产品不在购物车里，需要新增一个产品的记录
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setProductId(productId);
            cartItem.setUserId(userId);
            cartMapper.insert(cartItem);
        }else{
            //这个产品已经在购物车里了，产品存在，数量增加
            count = cart.getQuantity()+count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return null;
    }

    private CartVo getCartVoLimit(Integer userId){

        CartVo cartVo = new CartVo();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = Lists.newArrayList();
        BigDecimal cartTotalPrice = new BigDecimal("0");

        return null;
    }
}
