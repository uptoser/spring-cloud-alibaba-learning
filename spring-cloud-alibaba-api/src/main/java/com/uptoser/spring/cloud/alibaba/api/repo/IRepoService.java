package com.uptoser.spring.cloud.alibaba.api.repo;

import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.ProductDto;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;

public interface IRepoService {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseRepo(ProductDto productDto);
}
