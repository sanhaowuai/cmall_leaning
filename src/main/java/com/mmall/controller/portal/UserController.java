package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.controller.portal
 * @Author: sanhaowuai
 * @CreateTime: 2018-10-13 16:44
 * @Description: 用户
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;
    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){

        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * 登出功能
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){

        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 注册功能
     * @param user
     * @return
     */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user){

        return iUserService.register(user);
    }

    /**
     * 实时校验用户名与email
     * @param str
     * @param type
     * @return
     */
    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str,String type){

        return iUserService.checkValid(str,type);
    }

    /**
     * 获取用户信息
     * @param session
     * @return
     */
    @RequestMapping(value = "get_user_info.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息");
    }

    /**
     * 获取密码提示问题
     * @param username
     * @return
     */
    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username){

        return iUserService.selectQuestion(username);
    }

    /**
     * 校验回答问题是否正确(忘记密码的重置密码时需要)
     * @param username
     * @param question
     * @param answer
     * @return
     */
    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){

        return iUserService.checkAnswer(username,question,answer);
    }

    /**
     * 忘记密码的重置密码
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken){

        return iUserService.forgetResetPassword(username,passwordNew,forgetToken);
    }

    /**
     * 登陆状态下重置密码
     * @param session
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return iUserService.resetPassword(passwordOld,passwordNew,user);
    }

    /**
     * 更新用户个人信息
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> update_information(HttpSession session,User user){

        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        user.setId(currentUser.getId());
        ServerResponse<User> response = iUserService.updateInformation(user);
        //更新session
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * 获取用户详细信息
     * @param session
     * @return
     */
    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> get_information(HttpSession session){
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录，需强制登陆status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }
}
