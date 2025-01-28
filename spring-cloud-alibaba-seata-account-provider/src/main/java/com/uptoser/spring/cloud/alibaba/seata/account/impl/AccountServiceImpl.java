package com.uptoser.spring.cloud.alibaba.seata.account.impl;

import com.uptoser.spring.cloud.alibaba.api.account.IAccountService;
import com.uptoser.spring.cloud.alibaba.api.seata.common.constants.ResCode;
import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.AccountDto;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;
import com.uptoser.spring.cloud.alibaba.seata.account.dal.mappers.AccountMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@DubboService
public class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public ObjectResponse decreaseAccount(AccountDto accountDto) {
        log.info("事务ID:"+ RootContext.getXID());
        ObjectResponse response=new ObjectResponse();
        try{
            int rs=accountMapper.decreaseAccount(accountDto.getUserId(),accountDto.getBalance().doubleValue());
            if(rs>0){
                response.setMsg(ResCode.SUCCESS.getMessage());
                response.setCode(ResCode.SUCCESS.getCode());
                return response;
            }
            response.setMsg(ResCode.FAILED.getMessage());
            response.setCode(ResCode.FAILED.getCode());
        }catch (Exception e){
            log.error("decreaseAccount Occur Exception:"+e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMsg(ResCode.SYSTEM_EXCEPTION.getMessage()+"-"+e.getMessage());
        }
        return response;
    }
}
