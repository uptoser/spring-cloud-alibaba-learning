package com.uptoser.spring.cloud.alibaba.seata.order.impl;

import com.uptoser.spring.cloud.alibaba.api.account.IAccountService;
import com.uptoser.spring.cloud.alibaba.api.order.IOrderService;
import com.uptoser.spring.cloud.alibaba.api.seata.common.constants.ResCode;
import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.AccountDto;
import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.OrderDto;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;
import com.uptoser.spring.cloud.alibaba.seata.order.convert.OrderConvert;
import com.uptoser.spring.cloud.alibaba.seata.order.dal.entitys.Order;
import com.uptoser.spring.cloud.alibaba.seata.order.dal.mappers.OrderMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Slf4j
@DubboService
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderConvert orderConvert;
    @DubboReference
    IAccountService accountService;
    @Override
    public ObjectResponse<OrderDto> createOrder(OrderDto orderDto) {
        log.info("全局事务ID："+ RootContext.getXID());
        ObjectResponse response=new ObjectResponse();
        try {
            //账户扣款
            AccountDto accountDto = new AccountDto();
            accountDto.setUserId(orderDto.getUserId());
            accountDto.setBalance(orderDto.getOrderAmount());
            ObjectResponse accountRes = accountService.decreaseAccount(accountDto);
            //创建订单
            Order order=orderConvert.dto2Order(orderDto);
            order.setOrderNo(UUID.randomUUID().toString());
            orderMapper.createOrder(order);
            //判断扣款状态(判断可以前置）
            if(accountRes.getCode()!= ResCode.SUCCESS.getCode()){
                response.setMsg(ResCode.FAILED.getMessage());
                response.setCode(ResCode.FAILED.getCode());
                return response;
            }
            response.setMsg(ResCode.SUCCESS.getMessage());
            response.setCode(ResCode.SUCCESS.getCode());
        }catch (Exception e){
            log.error("createOrder Occur Exception:"+e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMsg(ResCode.SYSTEM_EXCEPTION.getMessage()+"-"+e.getMessage());
        }
        return response;
    }
}
