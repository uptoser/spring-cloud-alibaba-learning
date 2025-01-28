package com.uptoser.spring.cloud.alibaba.seata.repo.dal.mappers;

import org.apache.ibatis.annotations.Param;

public interface RepoMapper {

    /**
     *
     * @param productCode
     * @param count
     * @return
     */
    int decreaseRepo(@Param("productCode") String productCode, @Param("count") Integer count);
}
