package com.uptoser.spring.cloud.alibaba.api.order;

import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.OrderDto;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;

public interface IOrderService {

    /**
     * 创建订单
     * @param orderDto
     * @return
     */
    ObjectResponse<OrderDto> createOrder(OrderDto orderDto);
}
