package com.whpu.mapper;

import com.whpu.pojo.Provider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 供货商mapper
 */
@Repository
public interface ProviderMapper {

//      查询所有供应商
    @Select("select * from smbms_provider")
    List<Provider> findAll();


//      根据proName查询供应商
    @Select("select * from smbms_provider where proName =#{proName}")
    Provider findByProName(String proName);


//      根据id查询供应商
    @Select("select * from smbms_provider where id = #{id}")
    Provider findById(Integer id);


//      根据条件模糊查询
    @Select("select * from smbms_provider where proName like concat('%',#{condition},'%')")
    List<Provider> findLike(String condition);


//      保存供应商
    @Insert("insert into smbms_provider values(#{id},#{proCode},#{proName},#{proDesc},#{proContact},#{proPhone},#{proAddress},#{proFax},#{createdBy},#{creationdate},#{modifyBy},#{modifyDate})")
    void save(Provider provider);


//      修改供应商
    @Update("update smbms_provider set proDesc=#{proDesc},proContact=#{proContact},proPhone=#{proPhone},proAddress=#{proAddress},proFax=#{proFax},modifyBy=#{modifyBy},modifyDate=#{modifyDate} where id = #{id}")
    void update(Provider provider);


//      删除供应商
    @Delete("delete from smbms_provider where id=#{id} ")
    void delete(Integer id);

}
