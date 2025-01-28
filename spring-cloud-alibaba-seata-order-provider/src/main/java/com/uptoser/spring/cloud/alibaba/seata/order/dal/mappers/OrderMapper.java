package com.uptoser.spring.cloud.alibaba.seata.order.dal.mappers;


import com.uptoser.spring.cloud.alibaba.seata.order.dal.entitys.Order;

public interface OrderMapper {

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}
