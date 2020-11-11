package com.youyuan.delayqueue.redisson.properties;


import org.redisson.config.ReadMode;
import org.redisson.config.SubscriptionMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：MultipleRedisServerConfig <br>
 * 类描述： redisson多节点配置 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:30<br>
 */
public class MultipleRedisServerConfig {

    /**
     * 负载均衡算法类的选择
     * <p>
     * 默认值： org.redisson.connection.balancer.RoundRobinLoadBalancer
     * <p>
     * 在多Redis服务节点的环境里，可以选用以下几种负载均衡方式选择一个节点：
     * org.redisson.connection.balancer.WeightedRoundRobinBalancer - 权重轮询调度算法
     * org.redisson.connection.balancer.RoundRobinLoadBalancer - 轮询调度算法
     * org.redisson.connection.balancer.RandomLoadBalancer - 随机调度算法
     */
    private String loadBalancer = "org.redisson.connection.balancer.RoundRobinLoadBalancer";


    /**
     * 从节点最小空闲连接数 默认值32
     * <p>
     * 多从节点的环境里，每个 从服务节点里用于普通操作（非 发布和订阅）的最小保持连接数（长连接）。长期保持一定数量的连接有利于提高瞬时读取反映速度。
     */
    private int slaveConnectionMinimumIdleSize = 32;


    /**
     * 从节点连接池大小 默认64
     * <p>
     * 多从节点的环境里，每个 从服务节点里用于普通操作（非 发布和订阅）连接的连接池最大容量。连接池的连接数量自动弹性伸缩。
     */
    private int slaveConnectionPoolSize = 64;


    /**
     * 主节点最小空闲连接数 默认32
     * <p>
     * 多节点的环境里，每个 主节点的最小保持连接数（长连接）。长期保持一定数量的连接有利于提高瞬时写入反应速度。
     */
    private int masterConnectionMinimumIdleSize = 32;


    /**
     * 主节点连接池大小 默认64
     * <p>
     * 多主节点的环境里，每个 主节点的连接池最大容量。连接池的连接数量自动弹性伸缩。
     */
    private int masterConnectionPoolSize = 64;


    /**
     * 只在从服务器读取
     * <p>
     * 注：在从服务节点里读取的数据说明已经至少有两个节点保存了该数据，确保了数据的高可用性。
     * 设置读取操作选择节点的模式。 可用值为： SLAVE - 只在从服务节点里读取。 MASTER - 只在主服务节点里读取。 MASTER_SLAVE - 在主从服务节点里都可以读取。
     */
    private ReadMode readMode = ReadMode.SLAVE;

    /**
     * 默认值：SLAVE（只在从服务节点里订阅）
     * <p>
     * 设置订阅操作选择节点的模式。 可用值为： SLAVE - 只在从服务节点里订阅。 MASTER - 只在主服务节点里订阅
     */
    private SubscriptionMode subscriptionMode = SubscriptionMode.SLAVE;

    /**
     * 默认值：1
     * <p>
     * 多从节点的环境里，每个 从服务节点里用于发布和订阅连接的最小保持连接数（长连接）。Redisson内部经常通过发布和订阅来实现许多功能。长期保持一定数量的发布订阅连接是必须的。
     */
    private Integer subscriptionConnectionMinimumIdleSize = 1;

    /**
     * 默认值：50
     *
     * 多从节点的环境里，每个 从服务节点里用于发布和订阅连接的连接池最大容量。连接池的连接数量自动弹性伸缩。
     */
    private Integer subscriptionConnectionPoolSize = 50;


    /**
     * 默认值：5000
     *
     * 用来指定检查节点DNS变化的时间间隔。使用的时候应该确保JVM里的DNS数据的缓存时间保持在足够低的范围才有意义。用-1来禁用该功能。
     */
    private Long dnsMonitoringInterval = 5000L;


    /**
     * 集群地址
     * redis://127.0.0.1:7000
     * 可以用"rediss://"来启用SSL连接
     */
    private List<String> nodeAddresses = new ArrayList<>();

    /**
     * 默认值： 1000
     * 集群,哨兵,云托管
     * 对Redis集群节点状态扫描的时间间隔。单位是毫秒。
     */
    private Integer scanInterval = 1000;

    /**
     * database（数据库编号）
     * 默认值：0
     * 哨兵模式,云托管,主从
     * 尝试连接的数据库编号。
     */
    private Integer database = 0;

    /**
     * masterName（主服务器的名称）
     * 主服务器的名称是哨兵进程中用来监测主从服务切换情况的。
     */
    private String masterName;


    public String getLoadBalancer() {
        return loadBalancer;
    }

    public void setLoadBalancer(String loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public int getSlaveConnectionMinimumIdleSize() {
        return slaveConnectionMinimumIdleSize;
    }

    public void setSlaveConnectionMinimumIdleSize(int slaveConnectionMinimumIdleSize) {
        this.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
    }

    public int getSlaveConnectionPoolSize() {
        return slaveConnectionPoolSize;
    }

    public void setSlaveConnectionPoolSize(int slaveConnectionPoolSize) {
        this.slaveConnectionPoolSize = slaveConnectionPoolSize;
    }

    public int getMasterConnectionMinimumIdleSize() {
        return masterConnectionMinimumIdleSize;
    }

    public void setMasterConnectionMinimumIdleSize(int masterConnectionMinimumIdleSize) {
        this.masterConnectionMinimumIdleSize = masterConnectionMinimumIdleSize;
    }

    public int getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }

    public void setMasterConnectionPoolSize(int masterConnectionPoolSize) {
        this.masterConnectionPoolSize = masterConnectionPoolSize;
    }

    public ReadMode getReadMode() {
        return readMode;
    }

    public void setReadMode(ReadMode readMode) {
        this.readMode = readMode;
    }

    public SubscriptionMode getSubscriptionMode() {
        return subscriptionMode;
    }

    public void setSubscriptionMode(SubscriptionMode subscriptionMode) {
        this.subscriptionMode = subscriptionMode;
    }

    public Integer getSubscriptionConnectionMinimumIdleSize() {
        return subscriptionConnectionMinimumIdleSize;
    }

    public void setSubscriptionConnectionMinimumIdleSize(Integer subscriptionConnectionMinimumIdleSize) {
        this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
    }

    public Integer getSubscriptionConnectionPoolSize() {
        return subscriptionConnectionPoolSize;
    }

    public void setSubscriptionConnectionPoolSize(Integer subscriptionConnectionPoolSize) {
        this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
    }

    public Long getDnsMonitoringInterval() {
        return dnsMonitoringInterval;
    }

    public void setDnsMonitoringInterval(Long dnsMonitoringInterval) {
        this.dnsMonitoringInterval = dnsMonitoringInterval;
    }

    public List<String> getNodeAddresses() {
        return nodeAddresses;
    }

    public void setNodeAddresses(List<String> nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }

    public Integer getScanInterval() {
        return scanInterval;
    }

    public void setScanInterval(Integer scanInterval) {
        this.scanInterval = scanInterval;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
}
