package wang.l1n.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/16 18:44
 * @description：
 */
@RequestMapping("/shiro")
@Controller
public class ShiroController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            token.setRememberMe(true);
            try{
                currentUser.login(token);
            }catch (AuthenticationException ae){
                System.out.println(ae.getMessage());
            }
        }
        return "redirect:/index.jsp";
    }
}
