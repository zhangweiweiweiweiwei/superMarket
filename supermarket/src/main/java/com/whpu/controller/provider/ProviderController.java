package com.whpu.controller.provider;

import com.alibaba.fastjson.JSON;
import com.whpu.pojo.Provider;
import com.whpu.service.ProviderService;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: (Provider)控制类
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

//    返回到首页（无实际意义）
    @RequestMapping("/index")
    public String test() {
        return "frame";
    }


//      供应商管理页面
    @RequestMapping("/list")
    public String providerPage(Model model) {
        List<Provider> providers = providerService.findAll();
        model.addAttribute("providers", providers);
        return "providerList";
    }


//      去增加供应商页面
    @RequestMapping("/toProviderAdd")
    public String toAddPage() {
        return "providerAdd";
    }


//      判断供应商是否存在  若存在不可增加
    @RequestMapping("/provider.do")
    @ResponseBody
    public boolean isisExist(String proName) {
        Provider provider = providerService.findByProName(proName);
        if (provider != null) {
            return true;
        } else {
            return false;
        }
    }


//      增加供应商
    @RequestMapping("/add")
    public String addProvider(@RequestParam Map<String, String> maps, HttpServletRequest request, HttpSession session) {
        //Provider provider = map2Provider(request);
        Provider provider = JSON.parseObject(JSON.toJSONString(maps), Provider.class);
        //设置两个日期
        Date date = new Date();
        provider.setCreationdate(date);
        provider.setModifyDate(date);
        // 获取session，设置人名
        Long user = (Long) session.getAttribute("user");
        provider.setCreatedBy(user);
        provider.setModifyBy(user);
        //设置编号
        String proCode = request.hashCode() + "";
        provider.setProCode(proCode);
        providerService.saveProvider(provider);
        return "redirect:list";
    }


//      去供应商详情页面
    @RequestMapping("/toProviderView/{id}")
    public String toProviderView(@PathVariable("id") Integer id, Model model) {
        Provider provider = providerService.findById(id);
        model.addAttribute("provider", provider);
        return "providerView";
    }


//      去供应商修改页面
    @RequestMapping("/toProviderUpdate/{id}")
    public String toProviderUpdate(@PathVariable("id") Integer id, Model model) {
        Provider provider = providerService.findById(id);
        model.addAttribute("provider", provider);
        return "providerUpdate";
    }


//      修改供应商，并返回到供应商详情页面
    @RequestMapping("/updateProvider")
    public String updateProvider(@RequestParam Map<String, String> maps, HttpServletRequest request, HttpSession session) {
        //Provider provider = map2Provider(request);
        Provider provider = JSON.parseObject(JSON.toJSONString(maps), Provider.class);
        //提供供应商详情ID
        Long id = provider.getId();
        //设置更新者
        Long user = (Long) session.getAttribute("user");
        provider.setModifyBy(user);
        //设置更新时间
        provider.setModifyDate(new Date());
        System.out.println(provider);
        providerService.updateProvider(provider);
        return "redirect:/provider/toProviderView/" + id;
    }


//      删除供应商，并返回到list页面
    @RequestMapping("/providerDelete/{id}")
    public String providerDelete(@PathVariable("id") Integer id) {
        providerService.delProvider(id);
        return "redirect:/provider/list";
    }

    //供应商模糊查询
    @RequestMapping("/findLike")
    public String findLike(HttpServletRequest request,Model model){
        String proName = request.getParameter("proName");
        List<Provider> providers = providerService.findLike(proName);
        model.addAttribute("providers",providers);
        return "providerList";
    }

    /**
     * 将前端表单数据map集合封装成Provider对象，并返回 已使用更高效方法
     */
    /*private Provider map2Provider(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Provider provider = new Provider();
        try {
            BeanUtils.populate(provider, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return provider;
    }*/


}
