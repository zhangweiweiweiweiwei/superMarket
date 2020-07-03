package com.whpu.mapper;

import com.whpu.pojo.Bill;
import com.whpu.pojo.Provider;
import com.whpu.pojo.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账单mapper
 */
@Repository
public interface BillMapper {

//     查询所有账单，匹配billcode和usercode(查询bill表以及provider表的proName 组合为实体类Result)
    @Select("SELECT b.*,p.proName from smbms_bill b, smbms_provider p WHERE b.providerId = p.id and b.billCode =#{userCode}")
    List<Result> findall(String userCode);


//      根据商品名称查询账单
    @Select("select * from smbms_bill where productName =#{productName}")
    Bill findByProductName(String productName);




//    查询所有供应商
    @Select("SELECT distinct p.proName,b.providerId from smbms_bill b,smbms_provider p WHERE b.providerId = p.id")
    List<Result> findallPro();

//      根据条件模糊查询账单，用于查询productName
    @Select("SELECT b.*,p.proName from smbms_bill b,smbms_provider p WHERE b.providerId = p.id and productName like concat('%',#{condition},'%')")
    List<Result> findlikeProductName(String condition);

//      根据条件模糊查询，用于查询proName
    @Select("SELECT b.*,p.proName from smbms_bill b,smbms_provider p WHERE b.providerId = p.id and proName like concat('%',#{condition},'%')")
    List<Result> findlikeProName(String condition);

//      组合模糊查询，用于同时查询
    @Select("SELECT b.*,p.proName from smbms_bill b,smbms_provider p WHERE b.providerId = p.id and productName like concat('%',#{condition1},'%') and proName like concat('%',#{condition2},'%') and isPayment like concat('%',#{condition3},'%')")
    List<Result> findLike(String condition1,String condition2,String condition3);


//      保存账单
    @Insert("insert into smbms_bill values(#{id},#{billCode},#{productName},#{productDesc},#{productUnit},#{productCount},#{totalPrice},#{isPayment},#{providerId},#{creationDate},#{createdBy},#{modifyDate},#{modifyBy})")
    void add(Result result);

//      根据id查询账单
    @Select("select b.*,p.proName from smbms_bill b,smbms_provider p WHERE b.providerId = p.id and b.id = #{id}")
    Result findById(Integer id);

//      修改账单
    @Update("update smbms_bill set productName=#{productName},productUnit=#{productUnit},productCount=#{productCount},totalPrice=#{totalPrice},isPayment=#{isPayment},modifyBy=#{modifyBy},modifyDate=#{modifyDate} where id = #{id}")
    void update(Result result);


//      删除账单
    @Delete("delete from smbms_bill where id=#{id} ")
    void delete(Integer id);

}
