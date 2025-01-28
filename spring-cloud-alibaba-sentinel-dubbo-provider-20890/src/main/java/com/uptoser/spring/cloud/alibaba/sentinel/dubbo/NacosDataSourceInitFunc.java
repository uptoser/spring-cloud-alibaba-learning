package com.uptoser.spring.cloud.alibaba.sentinel.dubbo;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * Dubbo服务限流规则配置
 */
public class NacosDataSourceInitFunc implements InitFunc{

    @Override
    public void init() throws Exception {
        loadNacosData();
    }
    private void loadNacosData(){
        String serverAddr = "192.168.3.200:8848";
        String groupId = "DEFAULT_GROUP";
        String dataId = "spring-cloud-sentinel-dubbo-provider-sentinel-flow";
        ReadableDataSource<String,List<FlowRule>> flowRuleDataSource=
                new NacosDataSource<>(serverAddr, groupId, dataId, source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }
}
