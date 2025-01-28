package com.uptoser.spring.cloud.alibaba.api.account;

import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.AccountDto;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;

public interface IAccountService {

    /**
     * 从账户扣款
     * @param accountDto
     * @return
     */
    ObjectResponse decreaseAccount(AccountDto accountDto);
}
