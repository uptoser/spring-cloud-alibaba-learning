package com.uptoser.spring.cloud.alibaba.seata.rest.service;

import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.OrderRequest;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;

public interface IRestOrderService {

    ObjectResponse handleBusiness(OrderRequest orderRequest) throws Exception;
}
