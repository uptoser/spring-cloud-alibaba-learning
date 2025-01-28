package com.uptoser.spring.cloud.alibaba.api.seata.common.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ObjectResponse<T> extends AbstractResonse implements Serializable {

    private T data;

}
