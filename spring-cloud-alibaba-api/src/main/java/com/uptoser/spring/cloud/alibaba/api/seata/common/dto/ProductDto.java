package com.uptoser.spring.cloud.alibaba.api.seata.common.dto;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable{
    private static final long serialVersionUID = 5842131055690625955L;
    private Integer id;
    private String productCode;
    private String name;
    private Integer count;
}
