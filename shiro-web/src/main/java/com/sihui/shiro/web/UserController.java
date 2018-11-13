package com.sihui.shiro.web;

import com.sihui.shiro.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sihui.sha
 * @date 2018/11/13
 */
@Controller
public class UserController {

    @RequestMapping(value = "/subLogin", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public String subLogin(User user){
        System.out.println("user: "+user);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        if (subject.hasRole("admin")){
            return "有admin权限";
        }
        return "无admin权限";
    }
}
