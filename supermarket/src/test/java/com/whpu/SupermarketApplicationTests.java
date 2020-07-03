package com.whpu;

import com.whpu.mapper.BillMapper;
import com.whpu.mapper.ProviderMapper;
import com.whpu.mapper.UserMapper;
import com.whpu.pojo.Bill;
import com.whpu.pojo.Provider;
import com.whpu.pojo.Result;
import com.whpu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SupermarketApplicationTests {
    @Autowired
    private ProviderMapper providerMapper;

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }


    @Test
    public void test1(){
        List<Provider> providers = providerMapper.findLike("武汉");
        for (Provider p :
                providers) {
            System.out.println(p);
        }
        List<Result> results = billMapper.findlikeProductName("笔");
        for (Result result : results) {
            System.out.println(result);
        }
        List<Result> results2 = billMapper.findallPro();
        for (Result result : results2) {
            System.out.println(result);
        }
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
