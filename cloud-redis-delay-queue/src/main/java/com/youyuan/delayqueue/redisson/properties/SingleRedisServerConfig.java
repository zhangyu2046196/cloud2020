package com.youyuan.delayqueue.redisson.properties;

/**
 * 类名称：SingleRedisServerConfig <br>
 * 类描述： redisson单节点配置 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:31<br>
 */
public class SingleRedisServerConfig {

    /**
     * address（节点地址）
     * 可以通过host:port的格式来指定节点地址。
     */
    private String address;

    /**
     * ubscriptionConnectionMinimumIdleSize（发布和订阅连接的最小空闲连接数）
     * 默认值：1
     *
     * 用于发布和订阅连接的最小保持连接数（长连接）。Redisson内部经常通过发布和订阅来实现许多功能。长期保持一定数量的发布订阅连接是必须的。
     */
    private Integer subscriptionConnectionMinimumIdleSize = 1;

    /**
     * subscriptionConnectionPoolSize（发布和订阅连接池大小）
     * 默认值：50
     *
     * 用于发布和订阅连接的连接池最大容量。连接池的连接数量自动弹性伸缩。
     */
    private Integer subscriptionConnectionPoolSize = 50;

    /**
     * connectionMinimumIdleSize（最小空闲连接数）
     * 默认值：32
     *
     * 最小保持连接数（长连接）。长期保持一定数量的连接有利于提高瞬时写入反应速度。
     */
    private Integer connectionMinimumIdleSize = 32;

    /**
     * connectionPoolSize（连接池大小）
     * 默认值：64
     *
     * 连接池最大容量。连接池的连接数量自动弹性伸缩。
     */
    private Integer connectionPoolSize = 64;

    /**
     * database（数据库编号）
     * 默认值：0
     *
     * 尝试连接的数据库编号
     */
    private Integer database = 0;


    /**
     * dnsMonitoringInterval（DNS监测时间间隔，单位：毫秒）
     * 默认值：5000
     *
     * 监测DNS的变化情况的时间间隔。
     */
    private Long dnsMonitoringInterval = 5000L;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getConnectionMinimumIdleSize() {
        return connectionMinimumIdleSize;
    }

    public void setConnectionMinimumIdleSize(Integer connectionMinimumIdleSize) {
        this.connectionMinimumIdleSize = connectionMinimumIdleSize;
    }

    public Integer getConnectionPoolSize() {
        return connectionPoolSize;
    }

    public void setConnectionPoolSize(Integer connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public Long getDnsMonitoringInterval() {
        return dnsMonitoringInterval;
    }

    public void setDnsMonitoringInterval(Long dnsMonitoringInterval) {
        this.dnsMonitoringInterval = dnsMonitoringInterval;
    }
}
