package com.whpu.service.impl;

import com.whpu.mapper.ProviderMapper;
import com.whpu.pojo.Provider;
import com.whpu.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @ClassName ProviderServiceImpl
 * @Description: (provider)供应商业务层实现类
 * @author: RiceBall
 * @date: 2020/6/28 22:36
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;


//      查询所有供应商
    @Override
    public List<Provider> findAll() {
        return providerMapper.findAll();
    }


//      根据proName查询供应商是否存在
    @Override
    public Provider findByProName(String proName) {
        return providerMapper.findByProName(proName);
    }


//     保存供应商
    @Override
    public void saveProvider(Provider provider) {
        providerMapper.save(provider);
    }


//      通过id查询供应商（providerView页面的详情）
    @Override
    public Provider findById(Integer id) {
        return providerMapper.findById(id);
    }


//      修改供应商数据
    @Override
    public void updateProvider(Provider provider) {
        providerMapper.update(provider);
    }


//      删除供应商
    @Override
    public void delProvider(Integer id) {
        providerMapper.delete(id);
    }


//      根据条件模糊查询
    @Override
    public List<Provider> findLike(String condition) {
        return providerMapper.findLike(condition);
    }

}
