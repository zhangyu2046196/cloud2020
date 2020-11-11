package com.youyuan.delayqueue.redisson.config;

import com.youyuan.delayqueue.redisson.properties.MultipleRedisServerConfig;
import com.youyuan.delayqueue.redisson.properties.RedissonProperties;
import com.youyuan.delayqueue.redisson.properties.SingleRedisServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.config.*;
import org.redisson.connection.balancer.LoadBalancer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称：RedissonClientAutoConfiguration <br>
 * 类描述： Redisson配置 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:12<br>
 */
@Configuration
@EnableConfigurationProperties(value = RedissonProperties.class)
@ConditionalOnClass(RedissonProperties.class)
@Slf4j
public class RedissonClientAutoConfiguration {

    private RedissonProperties redissonProperties;

    public RedissonClientAutoConfiguration(RedissonProperties redissonProperties) {
        this.redissonProperties = redissonProperties;
    }

    /**
    * 方法名: redisson <br>
    * 方法描述: redisson基础配置 <br>
    *
    * @return {@link RedissonClient 返回redisson客户端 }
    * @date 创建时间: 2020/11/11 18:14 <br>
    * @author zhangyu
    */
    @Bean(destroyMethod = "shutdown")
    @ConditionalOnMissingBean(RedissonClient.class)
    public RedissonClient redisson() {
        Config config = new Config();
        try {
            config.setCodec((Codec) Class.forName(redissonProperties.getCodec()).getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            log.error("RedissonClient Bean setCodec error", e);
        }

        config.setTransportMode(redissonProperties.getTransportMode());
        if (redissonProperties.getThreads() != null) {
            config.setThreads(redissonProperties.getThreads());
        }
        if (redissonProperties.getNettyThreads() != null) {
            config.setNettyThreads(redissonProperties.getNettyThreads());
        }

        MultipleRedisServerConfig multipleServerConfig = redissonProperties.getMultipleConfig();
        switch (redissonProperties.getRedisModel()) {
            case SINGLE:
                SingleServerConfig singleServerConfig = config.useSingleServer();
                SingleRedisServerConfig param = redissonProperties.getSingleConfig();
                singleServerConfig.setAddress(param.getAddress());
                singleServerConfig.setConnectionMinimumIdleSize(param.getConnectionMinimumIdleSize());
                singleServerConfig.setConnectionPoolSize(param.getConnectionPoolSize());
                singleServerConfig.setDatabase(param.getDatabase());
                singleServerConfig.setDnsMonitoringInterval(param.getDnsMonitoringInterval());
                singleServerConfig.setSubscriptionConnectionMinimumIdleSize(param.getSubscriptionConnectionMinimumIdleSize());
                singleServerConfig.setSubscriptionConnectionPoolSize(param.getSubscriptionConnectionPoolSize());
                singleServerConfig.setClientName(redissonProperties.getClientName());
                singleServerConfig.setConnectTimeout(redissonProperties.getConnectTimeout());
                singleServerConfig.setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout());
                singleServerConfig.setPassword(redissonProperties.getPassword());
                singleServerConfig.setRetryAttempts(redissonProperties.getRetryAttempts());
                singleServerConfig.setRetryInterval(redissonProperties.getRetryInterval());
                singleServerConfig.setSslEnableEndpointIdentification(redissonProperties.getSslEnableEndpointIdentification());
                singleServerConfig.setSslKeystore(redissonProperties.getSslKeystore());
                singleServerConfig.setSslKeystorePassword(redissonProperties.getSslKeystorePassword());
                singleServerConfig.setSslProvider(redissonProperties.getSslProvider());
                singleServerConfig.setSslTruststore(redissonProperties.getSslTruststore());
                singleServerConfig.setSslTruststorePassword(redissonProperties.getSslTruststorePassword());
                singleServerConfig.setSubscriptionsPerConnection(redissonProperties.getSubscriptionsPerConnection());
                singleServerConfig.setTimeout(redissonProperties.getTimeout());
                break;
            case CLUSTER:
                ClusterServersConfig clusterServersConfig = config.useClusterServers();
                clusterServersConfig.setScanInterval(multipleServerConfig.getScanInterval());
                clusterServersConfig.setSlaveConnectionMinimumIdleSize(multipleServerConfig.getSlaveConnectionMinimumIdleSize());
                clusterServersConfig.setSlaveConnectionPoolSize(multipleServerConfig.getSlaveConnectionPoolSize());
                clusterServersConfig.setMasterConnectionMinimumIdleSize(multipleServerConfig.getMasterConnectionMinimumIdleSize());
                clusterServersConfig.setMasterConnectionPoolSize(multipleServerConfig.getMasterConnectionPoolSize());
                clusterServersConfig.setReadMode(multipleServerConfig.getReadMode());
                clusterServersConfig.setSubscriptionMode(multipleServerConfig.getSubscriptionMode());
                clusterServersConfig.setSubscriptionConnectionMinimumIdleSize(multipleServerConfig.getSubscriptionConnectionMinimumIdleSize());
                clusterServersConfig.setSubscriptionConnectionPoolSize(multipleServerConfig.getSubscriptionConnectionPoolSize());
                clusterServersConfig.setDnsMonitoringInterval(multipleServerConfig.getDnsMonitoringInterval());
                try {
                    clusterServersConfig.setLoadBalancer((LoadBalancer) Class.forName(multipleServerConfig.getLoadBalancer()).getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    log.error("RedissonClient Bean CLUSTER setLoadBalancer error", e);
                }
                for (String nodeAddress : multipleServerConfig.getNodeAddresses()) {
                    clusterServersConfig.addNodeAddress(nodeAddress);
                }
                clusterServersConfig.setClientName(redissonProperties.getClientName());
                clusterServersConfig.setConnectTimeout(redissonProperties.getConnectTimeout());
                clusterServersConfig.setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout());
                clusterServersConfig.setPassword(redissonProperties.getPassword());
                clusterServersConfig.setRetryAttempts(redissonProperties.getRetryAttempts());
                clusterServersConfig.setRetryInterval(redissonProperties.getRetryInterval());
                clusterServersConfig.setSslEnableEndpointIdentification(redissonProperties.getSslEnableEndpointIdentification());
                clusterServersConfig.setSslKeystore(redissonProperties.getSslKeystore());
                clusterServersConfig.setSslKeystorePassword(redissonProperties.getSslKeystorePassword());
                clusterServersConfig.setSslProvider(redissonProperties.getSslProvider());
                clusterServersConfig.setSslTruststore(redissonProperties.getSslTruststore());
                clusterServersConfig.setSslTruststorePassword(redissonProperties.getSslTruststorePassword());
                clusterServersConfig.setSubscriptionsPerConnection(redissonProperties.getSubscriptionsPerConnection());
                clusterServersConfig.setTimeout(redissonProperties.getTimeout());
                break;
            case SENTINEL:
                SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
                sentinelServersConfig.setDatabase(multipleServerConfig.getDatabase());
                sentinelServersConfig.setMasterName(multipleServerConfig.getMasterName());
                sentinelServersConfig.setScanInterval(multipleServerConfig.getScanInterval());
                sentinelServersConfig.setSlaveConnectionMinimumIdleSize(multipleServerConfig.getSlaveConnectionMinimumIdleSize());
                sentinelServersConfig.setSlaveConnectionPoolSize(multipleServerConfig.getSlaveConnectionPoolSize());
                sentinelServersConfig.setMasterConnectionMinimumIdleSize(multipleServerConfig.getMasterConnectionMinimumIdleSize());
                sentinelServersConfig.setMasterConnectionPoolSize(multipleServerConfig.getMasterConnectionPoolSize());
                sentinelServersConfig.setReadMode(multipleServerConfig.getReadMode());
                sentinelServersConfig.setSubscriptionMode(multipleServerConfig.getSubscriptionMode());
                sentinelServersConfig.setSubscriptionConnectionMinimumIdleSize(multipleServerConfig.getSubscriptionConnectionMinimumIdleSize());
                sentinelServersConfig.setSubscriptionConnectionPoolSize(multipleServerConfig.getSubscriptionConnectionPoolSize());
                sentinelServersConfig.setDnsMonitoringInterval(multipleServerConfig.getDnsMonitoringInterval());
                try {
                    sentinelServersConfig.setLoadBalancer((LoadBalancer) Class.forName(multipleServerConfig.getLoadBalancer()).newInstance());
                } catch (Exception e) {
                    log.error("RedissonClient Bean SENTINEL setLoadBalancer error", e);
                }
                for (String nodeAddress : multipleServerConfig.getNodeAddresses()) {
                    sentinelServersConfig.addSentinelAddress(nodeAddress);
                }
                sentinelServersConfig.setClientName(redissonProperties.getClientName());
                sentinelServersConfig.setConnectTimeout(redissonProperties.getConnectTimeout());
                sentinelServersConfig.setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout());
                sentinelServersConfig.setPassword(redissonProperties.getPassword());
                sentinelServersConfig.setRetryAttempts(redissonProperties.getRetryAttempts());
                sentinelServersConfig.setRetryInterval(redissonProperties.getRetryInterval());
                sentinelServersConfig.setSslEnableEndpointIdentification(redissonProperties.getSslEnableEndpointIdentification());
                sentinelServersConfig.setSslKeystore(redissonProperties.getSslKeystore());
                sentinelServersConfig.setSslKeystorePassword(redissonProperties.getSslKeystorePassword());
                sentinelServersConfig.setSslProvider(redissonProperties.getSslProvider());
                sentinelServersConfig.setSslTruststore(redissonProperties.getSslTruststore());
                sentinelServersConfig.setSslTruststorePassword(redissonProperties.getSslTruststorePassword());
                sentinelServersConfig.setSubscriptionsPerConnection(redissonProperties.getSubscriptionsPerConnection());
                sentinelServersConfig.setTimeout(redissonProperties.getTimeout());
                break;
            case REPLICATED:
                ReplicatedServersConfig replicatedServersConfig = config.useReplicatedServers();
                replicatedServersConfig.setDatabase(multipleServerConfig.getDatabase());
                replicatedServersConfig.setScanInterval(multipleServerConfig.getScanInterval());
                replicatedServersConfig.setSlaveConnectionMinimumIdleSize(multipleServerConfig.getSlaveConnectionMinimumIdleSize());
                replicatedServersConfig.setSlaveConnectionPoolSize(multipleServerConfig.getSlaveConnectionPoolSize());
                replicatedServersConfig.setMasterConnectionMinimumIdleSize(multipleServerConfig.getMasterConnectionMinimumIdleSize());
                replicatedServersConfig.setMasterConnectionPoolSize(multipleServerConfig.getMasterConnectionPoolSize());
                replicatedServersConfig.setReadMode(multipleServerConfig.getReadMode());
                replicatedServersConfig.setSubscriptionMode(multipleServerConfig.getSubscriptionMode());
                replicatedServersConfig.setSubscriptionConnectionMinimumIdleSize(multipleServerConfig.getSubscriptionConnectionMinimumIdleSize());
                replicatedServersConfig.setSubscriptionConnectionPoolSize(multipleServerConfig.getSubscriptionConnectionPoolSize());
                replicatedServersConfig.setDnsMonitoringInterval(multipleServerConfig.getDnsMonitoringInterval());
                try {
                    replicatedServersConfig.setLoadBalancer((LoadBalancer) Class.forName(multipleServerConfig.getLoadBalancer()).newInstance());
                } catch (Exception e) {
                    log.error("RedissonClient Bean REPLICATED setLoadBalancer error", e);
                }
                for (String nodeAddress : multipleServerConfig.getNodeAddresses()) {
                    replicatedServersConfig.addNodeAddress(nodeAddress);
                }
                replicatedServersConfig.setClientName(redissonProperties.getClientName());
                replicatedServersConfig.setConnectTimeout(redissonProperties.getConnectTimeout());
                replicatedServersConfig.setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout());
                replicatedServersConfig.setPassword(redissonProperties.getPassword());
                replicatedServersConfig.setRetryAttempts(redissonProperties.getRetryAttempts());
                replicatedServersConfig.setRetryInterval(redissonProperties.getRetryInterval());
                replicatedServersConfig.setSslEnableEndpointIdentification(redissonProperties.getSslEnableEndpointIdentification());
                replicatedServersConfig.setSslKeystore(redissonProperties.getSslKeystore());
                replicatedServersConfig.setSslKeystorePassword(redissonProperties.getSslKeystorePassword());
                replicatedServersConfig.setSslProvider(redissonProperties.getSslProvider());
                replicatedServersConfig.setSslTruststore(redissonProperties.getSslTruststore());
                replicatedServersConfig.setSslTruststorePassword(redissonProperties.getSslTruststorePassword());
                replicatedServersConfig.setSubscriptionsPerConnection(redissonProperties.getSubscriptionsPerConnection());
                replicatedServersConfig.setTimeout(redissonProperties.getTimeout());
                break;
            case MASTERSLAVE:
                MasterSlaveServersConfig masterSlaveServersConfig = config.useMasterSlaveServers();
                masterSlaveServersConfig.setDatabase(multipleServerConfig.getDatabase());
                masterSlaveServersConfig.setSlaveConnectionMinimumIdleSize(multipleServerConfig.getSlaveConnectionMinimumIdleSize());
                masterSlaveServersConfig.setSlaveConnectionPoolSize(multipleServerConfig.getSlaveConnectionPoolSize());
                masterSlaveServersConfig.setMasterConnectionMinimumIdleSize(multipleServerConfig.getMasterConnectionMinimumIdleSize());
                masterSlaveServersConfig.setMasterConnectionPoolSize(multipleServerConfig.getMasterConnectionPoolSize());
                masterSlaveServersConfig.setReadMode(multipleServerConfig.getReadMode());
                masterSlaveServersConfig.setSubscriptionMode(multipleServerConfig.getSubscriptionMode());
                masterSlaveServersConfig.setSubscriptionConnectionMinimumIdleSize(multipleServerConfig.getSubscriptionConnectionMinimumIdleSize());
                masterSlaveServersConfig.setSubscriptionConnectionPoolSize(multipleServerConfig.getSubscriptionConnectionPoolSize());
                masterSlaveServersConfig.setDnsMonitoringInterval(multipleServerConfig.getDnsMonitoringInterval());
                try {
                    masterSlaveServersConfig.setLoadBalancer((LoadBalancer) Class.forName(multipleServerConfig.getLoadBalancer()).newInstance());
                } catch (Exception e) {
                    log.error("RedissonClient Bean MASTERSLAVE setLoadBalancer error", e);
                }
                int index = 0;
                for (String nodeAddress : multipleServerConfig.getNodeAddresses()) {
                    if (index++ == 0) {
                        masterSlaveServersConfig.setMasterAddress(nodeAddress);
                    } else {
                        masterSlaveServersConfig.addSlaveAddress(nodeAddress);
                    }
                }
                masterSlaveServersConfig.setClientName(redissonProperties.getClientName());
                masterSlaveServersConfig.setConnectTimeout(redissonProperties.getConnectTimeout());
                masterSlaveServersConfig.setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout());
                masterSlaveServersConfig.setPassword(redissonProperties.getPassword());
                masterSlaveServersConfig.setRetryAttempts(redissonProperties.getRetryAttempts());
                masterSlaveServersConfig.setRetryInterval(redissonProperties.getRetryInterval());
                masterSlaveServersConfig.setSslEnableEndpointIdentification(redissonProperties.getSslEnableEndpointIdentification());
                masterSlaveServersConfig.setSslKeystore(redissonProperties.getSslKeystore());
                masterSlaveServersConfig.setSslKeystorePassword(redissonProperties.getSslKeystorePassword());
                masterSlaveServersConfig.setSslProvider(redissonProperties.getSslProvider());
                masterSlaveServersConfig.setSslTruststore(redissonProperties.getSslTruststore());
                masterSlaveServersConfig.setSslTruststorePassword(redissonProperties.getSslTruststorePassword());
                masterSlaveServersConfig.setSubscriptionsPerConnection(redissonProperties.getSubscriptionsPerConnection());
                masterSlaveServersConfig.setTimeout(redissonProperties.getTimeout());
                break;
            default:
                throw new RuntimeException("请配置RedisServer模式");
        }
        return Redisson.create(config);
    }
}
