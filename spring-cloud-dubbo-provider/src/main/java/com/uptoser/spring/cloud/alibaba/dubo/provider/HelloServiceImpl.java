package com.uptoser.spring.cloud.alibaba.dubo.provider;

import com.uptoser.spring.cloud.alibaba.api.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * Dubbo默认提供了6种容错模式，默认为Failover Cluster。
 * • Failover Cluster，失败自动切换。当服务调用失败后，会切换到集群中的其他机器进行重试，默认重试次数为2，通过属性retries=2可以修改次数，但是重试次数增加会带来更长的响应延迟。这种容错模式通常用于读操作，因为事务型操作会带来数据重复问题。
 * • Failfast Cluster，快速失败。当服务调用失败后，立即报错，也就是只发起一次调用。通常用于一些幂等的写操作，比如新增数据，因为当服务调用失败时，很可能这个请求已经在服务器端处理成功，只是因为网络延迟导致响应失败，为了避免在结果不确定的情况下导致数据重复插入的问题，可以使用这种容错机制。
 * • Failsafe Cluster，失败安全。也就是出现异常时，直接忽略异常。
 * • Failback Cluster，失败后自动回复。服务调用出现异常时，在后台记录这条失败的请求定时重发。这种模式适合用于消息通知操作，保证这个请求一定发送成功。
 * • Forking Cluster，并行调用集群中的多个服务，只要其中一个成功就返回。可以通过forks=2来设置最大并行数。
 * • Broadcast Cluster，广播调用所有的服务提供者，任意一个服务报错则表示服务调用失败。这种机制通常用于通知所有的服务提供者更新缓存或者本地资源信息。
 * 查询语句容错策略建议使用默认的Failover Cluster，而增删改操作建议使用Failfast Cluster或者使用Failover Cluster（retries="0"）策略，防止出现数据重复添加等其他问题
 *
 * 在Dubbo中提供了4种负载均衡策略，默认负载均衡策略是random。
 * • Random LoadBalance，随机算法。可以针对性能较好的服务器设置较大的权重值，权重值越大，随机的概率也会越大。
 * • RoundRobin LoadBalance，轮询。按照公约后的权重设置轮询比例。
 * • LeastActive LoadBalance，最少活跃调用书。处理较慢的节点将会收到更少的请求。
 * • ConsistentHash LoadBalance，一致性Hash。相同参数的请求总是发送到同一个服务提供者。
 */
@DubboService(cluster = "failfast",loadbalance="roundrobin")
public class HelloServiceImpl implements IHelloService {
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        System.out.printf("The message received is [%s]\n", name);
        return String.format("[%s]：Hello,%s", serviceName, name);
    }
}
