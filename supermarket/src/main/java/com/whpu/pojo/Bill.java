package com.whpu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * （Bill）实体类
 */
@Data
@ToString
@AllArgsConstructor
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 账单编码
     */
    private String billCode;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品描述
     */
    private String productDesc;
    /**
     * 单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private BigDecimal productCount;
    /**
     * 账单总金额
     */
    private BigDecimal totalPrice;
    /**
     * 是否付款
     */
    private int isPayment;
    /**
     * 供应商ID
     */
    private Long providerId;
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

    public Bill() {
    }
}
