package com.whpu.controller;

import com.whpu.pojo.User;
import com.whpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class FrameController {

    @Autowired
    private UserService userService;

    @GetMapping("/top")
    public String top() {
        return "top";
    }

    @GetMapping("/left")
    public String left() {
        return "left";
    }

    @GetMapping("/main")
    public String mian() {
        return "main";
    }

    @GetMapping("/index")
    public String userview() {
        return "frame";
    }

    //跳转到ProviderController里的list方法
    @RequestMapping("/toProviderList")
    public String toProviderList() {
        return "redirect:/provider/list";
    }

    //跳转到BillController里的list方法
    @RequestMapping("/toBillList")
    public String toBillList() {
        return "redirect:/bill/list";
    }

    //跳转到UserController里的list方法
    @RequestMapping("/toUserlist")
    public String toUserlist() {
        return "redirect:/user/list";
    }


    @RequestMapping("/toUpdatePwd")
    public String toUpdatePwd(HttpSession session, Model model) {
        Long userid = (Long) session.getAttribute("user");
        Integer id = userid.intValue();
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "updatePwd";
    }


//      登录
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpSession session, Model model) throws IOException {

        //获取前端用户账号和密码
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        //访问后端userService的findByMobileAndPwd方法
        User user = userService.findByMobileAndPwd(userName, userPassword);
        if (user == null) {
            //登录失败
            //model.addAttribute("error", "登录失败");
            //out.print("<script language=\"javascript\">alert('登录失败！');</script>");
            return "login";

        } else {
            session.setAttribute("user", user.getId());
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("userCode", user.getUserCode());
            return "frame";
        }
    }
}
