package com.uptoser.spring.cloud.alibaba.sentinel.base;

import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 手动配置流控规则，可以借助Sentinel的InitFunc SPI扩展接口来实现，
 * 只需要实现自己的InitFunc接口，并在init方法中编写规则加载的逻辑即可。
 */
public class FlowRuleInitFunc implements InitFunc{
    @Override
    public void init() throws Exception {
        List<FlowRule> rules=new ArrayList<>();
        FlowRule rule=new FlowRule();
        rule.setCount(1);
        rule.setResource("hello");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
        /*
        针对资源hello，通过init设置限流规则，其中参数的含义如下。
        • Grade：限流阈值类型，QPS模式（1）或并发线程数模式（0）。
        • count：限流阈值。
        • resource：设置需要保护的资源。这个资源的名称必须和SphU.entry中使用的名称保持一致。
        上述代码的意思是，针对资源hello，每秒最多允许通过1个请求，也就是QPS为1。
         */
    }
}
