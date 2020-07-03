package com.whpu.service;

import com.whpu.pojo.Bill;
import com.whpu.pojo.Result;

import java.util.List;

/**
 * @Description: 账单服务层接口
 * @author 10542
 * @date: 2020/6/30 22:41
 */
public interface BillService {

    List<Result> findall(String userCode);

    Bill findByProductName(String productName);

    Result findById(Integer id);

    List<Result> findlikeProductName(String condition);

    List<Result> findlikeProName(String condition);

    List<Result> findallPro();

    void addBill(Result result);

    void update(Result result);

    void delete(Integer id);

    List<Result> findLike(String condition1, String condition2, String condition3);
}
