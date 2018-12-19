package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICarService;
import com.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.controller.portal
 * @Author: 爱迪生
 * @CreateTime: 2018-11-09 13:15
 * @Description: 购物车
 */
@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private ICarService iCarService;

    /**
     * 添加商品
     * @param session
     * @param count
     * @param productId
     * @return
     */
    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId ){

        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCarService.add(user.getId(),productId,count);
    }
}
