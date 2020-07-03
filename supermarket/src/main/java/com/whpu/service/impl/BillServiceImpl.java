package com.whpu.service.impl;

import com.whpu.mapper.BillMapper;
import com.whpu.pojo.Bill;
import com.whpu.pojo.Provider;
import com.whpu.pojo.Result;
import com.whpu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: (Bill)账单业务层实现类
 * @author 10542
 * @date: 2020/6/30/22:46
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;
    //登录
    @Override
    public Bill findByProductName(String productName) {
        return billMapper.findByProductName(productName);
    }

    //账单显示  访问billMapper的findall
    @Override
    public List<Result> findall(String userCode) {
        return billMapper.findall(userCode);
    }

    //添加账单  访问billMapper的add
    @Override
    public void addBill(Result result) {
        billMapper.add(result);
    }

    //显示账单详情
    @Override
    public Result findById(Integer id) {
        return billMapper.findById(id);
    }




//    获取所有供应商信息，添加账单的下拉框使用
    @Override
    public List<Result> findallPro() {
        return billMapper.findallPro();
    }



//  修改账单详情
    @Override
    public void update(Result result) {
        billMapper.update(result);
    }


//    删除账单
    @Override
    public void delete(Integer id) {
        billMapper.delete(id);
    }



//    模糊查询组合
    @Override
    public List<Result> findLike(String condition1, String condition2, String condition3) {
        return billMapper.findLike(condition1,condition2,condition3);
    }

//    用于商品名称的模糊查询
    @Override
    public List<Result> findlikeProductName(String condition) {
        return billMapper.findlikeProductName(condition);
    }

//      用于供应商名称的模糊查询
    @Override
    public List<Result> findlikeProName(String condition) {
        return billMapper.findlikeProName(condition);
    }

}
