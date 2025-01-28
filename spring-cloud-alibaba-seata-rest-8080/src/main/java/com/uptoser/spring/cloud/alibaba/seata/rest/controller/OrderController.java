package com.uptoser.spring.cloud.alibaba.seata.rest.controller;

import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.OrderRequest;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;
import com.uptoser.spring.cloud.alibaba.seata.rest.service.IRestOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class OrderController {

    @Autowired
    IRestOrderService restOrderService;

    @PostMapping("/order")
    ObjectResponse order(@RequestBody OrderRequest orderRequest) throws Exception {
        return restOrderService.handleBusiness(orderRequest);
    }
}
