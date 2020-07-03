package com.whpu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Provider)实体类
 */
@Data
@ToString
@AllArgsConstructor
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 供应商编码
     */
    private String proCode;
    /**
     * 供应商名称
     */
    private String proName;
    /**
     * 供应商描述信息
     */
    private String proDesc;
    /**
     * 供应商联系人
     */
    private String proContact;
    /**
     * 联系电话
     */
    private String proPhone;
    /**
     * 地址
     */
    private String proAddress;
    /**
     * 传真
     */
    private String proFax;
    /**
     * 创建者（userId）
     */
    private Long createdBy;
    /**
     * 创建时间
     */
    private Date creationdate;
    /**
     * 更新者
     */
    private Long modifyBy;
    /**
     * 更新时间
     */
    private Date modifyDate;

    public Provider() {

    }
}