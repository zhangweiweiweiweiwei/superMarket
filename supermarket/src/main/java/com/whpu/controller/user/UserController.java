package com.whpu.controller.user;

import com.alibaba.fastjson.JSON;
import com.whpu.pojo.Result;
import com.whpu.pojo.User;
import com.whpu.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProviderController
 * @Description: (Provider)控制类
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


//      返回到首页（无实际意义）
    @RequestMapping("/index")
    public String test(){
        return "frame";
    }


//      用户控制界面（显示用户信息）
    @RequestMapping("/list")
    public String userPage(Model model,Model model2){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        //System.out.println(users.size());
        model2.addAttribute("length",users.size());
        return "userList";
    }

//      去增加用户页面
    @RequestMapping("/toUserAdd")
    public String toAddPage(){
        return "userAdd";
    }


//     去用户详情页面
    @RequestMapping("/toUserView/{id}")
    public String toBillView(@PathVariable("id") Integer id , Model model){
        System.out.println(id);
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "userView";
    }


//      判断用户是否存在  若存在不可添加
    @RequestMapping("/exist/{userName}")
    public User exist(@PathVariable("userName") String userName){
        System.out.println(userName);
        User user = userService.findByUserName(userName);
        return user;
    }



//     增加用户
    @RequestMapping("/add")
    public String addUser(@RequestParam Map<String, String> maps, HttpSession session, HttpServletRequest request){
        //User user = map2User(request);
        User user = JSON.parseObject(JSON.toJSONString(maps), User.class);
        //设置两个日期
        Date date = new Date();
        user.setCreationDate(date);
        user.setModifyDate(date);
        // 获取session，设置人名
        Long user2 = (Long) session.getAttribute("user");
        user.setCreatedBy(user2);
        user.setModifyBy(user2);
        //设置编号
        String UserCode = request.hashCode() + "";
        user.setUserCode(UserCode);
        userService.save(user);
        return "redirect:list";
    }


//      删除用户
    @RequestMapping("/userDelete/{id}")
    public String providerDelete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/user/list";
    }


//      去修改页面
    @RequestMapping("/toUserUpdate/{id}")
    public String toProviderUpdate(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        //展示ID对应账单的信息
        model.addAttribute("user", user);
//        List<Result> bills = userService.findallPro();
//        //展示bills的下拉列表
//        model2.addAttribute("bills",bills);
        return "userUpdate";
    }


//      修改用户，并返回到用户详情页面
    @RequestMapping("/updateUser")
    public String updateProvider(@RequestParam Map<String, String> maps,HttpSession session){
        //User user = map2User(request);
        User user = JSON.parseObject(JSON.toJSONString(maps), User.class);
        Long id = user.getId();
        System.out.println(id);
        //设置修改日期
        Date date = new Date();
        user.setModifyDate(date);
        // 获取session，设置人名
        Long user2 = (Long) session.getAttribute("user");
        user.setModifyBy(user2);
        //设置编号
        userService.update(user);
        return "redirect:/user/toUserView/" + id;
    }


//      根据条件模糊查询
    @RequestMapping("/findLike")
    public String findlike(HttpServletRequest request,Model model){
        String userName = request.getParameter("userName");
        List<User> users = userService.findLike(userName);
        model.addAttribute("users",users);
        return "userList";
    }


//      修改密码
    @RequestMapping("/toPwdUpdate/{newPwd}")
    @ResponseBody
    public String toProviderUpdate(@PathVariable("newPwd") String newPwd,HttpSession session) {
        Long userid = (Long) session.getAttribute("user");
        Integer id = userid.intValue();
        userService.updatePwd(newPwd,id);
        String flag = "登录成功";
        //修改完密码重新登录
        return flag;
    }


    /**
     * 将前端表单数据map集合封装成User对象，并返回 已使用更高效方法
     */
    /*private User map2User(HttpServletRequest request) throws ParseException {
        //从request中获取参数
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
        String Id = request.getParameter("id");
        String birthdayDate = request.getParameter("birthday");
        Date birthday = dateFormat.parse(birthdayDate);
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        Integer gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Integer userType = Integer.parseInt(request.getParameter("userType"));
        //将参数赋值给user
        User user = new User();
        if(Id != null)
        {
            Long id = Long.valueOf(Id);
            user.setId(id);
        }
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserType(userType);
        return user;
    }*/
}
