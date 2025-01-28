package com.uptoser.spring.cloud.alibaba.seata.repo.dal.entitys;

import lombok.Data;

@Data
public class Repo {
    private Integer id;
    private String productCode;
    private String name;
    private Integer count;
}
