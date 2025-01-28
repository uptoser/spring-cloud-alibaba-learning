package com.uptoser.spring.cloud.alibaba.seata.repo.impl;


import com.uptoser.spring.cloud.alibaba.api.repo.IRepoService;
import com.uptoser.spring.cloud.alibaba.api.seata.common.constants.ResCode;
import com.uptoser.spring.cloud.alibaba.api.seata.common.dto.ProductDto;
import com.uptoser.spring.cloud.alibaba.api.seata.common.response.ObjectResponse;
import com.uptoser.spring.cloud.alibaba.seata.repo.dal.mappers.RepoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@DubboService
public class RepoServiceImpl implements IRepoService {
    @Autowired
    RepoMapper repoMapper;

    @Override
    public ObjectResponse decreaseRepo(ProductDto productDto) {
        ObjectResponse response=new ObjectResponse();
        try {
            int repo = repoMapper.decreaseRepo(productDto.getProductCode(), productDto.getCount());
            if(repo>0){
                response.setMsg(ResCode.SUCCESS.getMessage());
                response.setCode(ResCode.SUCCESS.getCode());
                return response;
            }
            response.setMsg(ResCode.FAILED.getMessage());
            response.setCode(ResCode.FAILED.getCode());
        }catch (Exception e){
            log.error("decreaseRepo Occur Exception:"+e);
            response.setCode(ResCode.SYSTEM_EXCEPTION.getCode());
            response.setMsg(ResCode.SYSTEM_EXCEPTION.getMessage()+"-"+e.getMessage());
        }
        return response;
    }
}
