package com.whpu.controller.bill;

import com.alibaba.fastjson.JSON;
import com.whpu.pojo.Result;
import com.whpu.service.BillService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

//    返回到首页（无实际意义）
    @RequestMapping("/index")
    public String test(){
        return "frame";
    }


//      账单管理页面（显示账单信息） 从session中获取userCode编码，访问billService的findall
    @RequestMapping("/list")
    public String billPage(Model model,HttpSession session){
        String userCode = (String) session.getAttribute("userCode");
        List<Result> bills = billService.findall(userCode);

        model.addAttribute("bills",bills);
        return "billList";
    }



//  增加账单
    @RequestMapping("/add")
    public String addBill(@RequestParam Map<String, String> maps, HttpServletRequest request, HttpSession session){
        //Result result = map2Result(request);
        Result result = JSON.parseObject(JSON.toJSONString(maps), Result.class);
        //设置两个日期
        Date date = new Date();
        result.setCreationDate(date);
        result.setModifyDate(date);
        // 获取session，设置人名
        Long user = (Long) session.getAttribute("user");
        String userCode = (String) session.getAttribute("userCode");
        result.setCreatedBy(user);
        result.setModifyBy(user);
        //设置编号
        result.setBillCode(userCode);
        billService.addBill(result);
        return "redirect:list";
    }


//  显示增加账单页面 主要为该页面的下拉框供应商属性获取数据
    @RequestMapping("/toBillAdd")
    public String toBillPage(Model model){
        List<Result> bills = billService.findallPro();
        model.addAttribute("bills",bills);
        //System.out.println("进入跳转");
        return "billAdd";
    }


//   去账单修改页面
    @RequestMapping("/toBillUpdate/{id}")
    public String toProviderUpdate(@PathVariable("id") Integer id, Model model,Model model2) {
        Result bill = billService.findById(id);
        //展示ID对应账单的信息
        model.addAttribute("bill", bill);
        List<Result> bills = billService.findallPro();
        //展示bills的下拉列表
        model2.addAttribute("bills",bills);
        return "billUpdate";
    }


//   修改账单，并返回到账单详情页面
    @RequestMapping("/updateBill")
    public String updateProvider(@RequestParam Map<String, String> maps,HttpServletRequest request, HttpSession session) {
        //Result result = map2Result(request);
        Result result = JSON.parseObject(JSON.toJSONString(maps), Result.class);
        Long id = result.getId();
        System.out.println(id);
        //设置修改日期
        Date date = new Date();
        result.setModifyDate(date);
        // 获取session，设置人名
        Long user = (Long) session.getAttribute("user");
        result.setModifyBy(user);
        //设置编号
        billService.update(result);
        return "redirect:/bill/toBillView/" + id;
    }


//  显示账单详情页面
    @RequestMapping("/toBillView/{id}")
    public String toBillView(@PathVariable("id") Integer id ,Model model){
        System.out.println(id);
        Result bill = billService.findById(id);
        model.addAttribute("bill",bill);
        return "billView";
    }

//      删除账单，并返回到list页面
    @RequestMapping("/billDelete/{id}")
    public String providerDelete(@PathVariable("id") Integer id) {
        billService.delete(id);
        return "redirect:/bill/list";
    }


//      根据条件模糊查询
    @RequestMapping("/findLike")
    public String findlike(HttpServletRequest request,Model model){
        String proName = request.getParameter("proName");
        String productName = request.getParameter("productName");
        String isPayment = request.getParameter("isPayment");
        List<Result> results = billService.findLike(productName,proName,isPayment);
        model.addAttribute("bills",results);
        return "billList";
    }

/**
 * 封装前端表单数据map结合封装为Result对象，并返回 已使用更高效方法
 */
    /*private Result map2Result(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        Result result = new Result();
        try {
            BeanUtils.populate(result, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }*/
}
