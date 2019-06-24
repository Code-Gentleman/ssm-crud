package wang.l1n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wang.l1n.entity.User;
import wang.l1n.service.UserService;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/2 11:51
 * @description：
 */


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 跳转登录
     * @return
     */
    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    /**
     * 登录检测
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("checkLogin")
    @ResponseBody
    public String checkLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model){
        System.out.println(username+":"+password);

        User user = userService.checkLogin(username,password);
        if (user!= null){
//            model.addAttribute("msg", "登陆成功");
            return "success";
        }else {
//            model.addAttribute("msg", "登录失败");
            return "failed";
        }
    }

    @RequestMapping("toRegist")
    public String toRegist(String username,String password){
        return "register";
    }

    @RequestMapping("regist")
    @ResponseBody
    public String regist(String username,String password){
        System.out.println(username+":"+password);
        userService.addUser(username,password);
        return "success";
    }
}