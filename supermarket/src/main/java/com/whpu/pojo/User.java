package com.whpu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
/**
 * （User）实体类
 */
@Data
@ToString
@AllArgsConstructor
public class User implements Serializable {

    private Long id;                //主键ID
    private String userCode;        //用户编码
    private String userName;        //用户名称
    private String userPassword;    //用户密码
    private Integer gender;         //性别
    private Date birthday;          //出生日期
    private String phone;           //手机
    private String address;         //地址
    private Integer userType;       //用户类型
    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 创建者（userId）
     */
    private Long createdBy;

    /**
     * 更新时间
     */
    private Date modifyDate;

    /**
     * 更新者
     */
    private Long modifyBy;

    public User() {
    }
}
