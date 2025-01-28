package com.uptoser.spring.cloud.alibaba.seata.account.dal.entitys;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private String userId;
    private Double balance;
}
