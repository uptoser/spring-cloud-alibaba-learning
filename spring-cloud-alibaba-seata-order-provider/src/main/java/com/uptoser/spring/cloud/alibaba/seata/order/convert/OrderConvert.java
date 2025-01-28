package com.uptoser.spring.cloud.alibaba.seata.order.convert;

import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.OrderDto;
import com.uptoser.spring.cloud.alibaba.seata.order.dal.entitys.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderConvert {

    @Mappings({
        @Mapping(source = "orderCount",target = "count"),
        @Mapping(source = "orderAmount",target = "amount")
    })
    Order dto2Order(OrderDto orderDto);
}
