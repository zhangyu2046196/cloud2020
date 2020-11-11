package com.youyuan.delayqueue.redisson.properties;


import com.youyuan.delayqueue.redisson.enums.RedisModelEnum;
import org.redisson.config.SslProvider;
import org.redisson.config.TransportMode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

/**
 * 类名称：RedissonProperties <br>
 * 类描述： redisson基础配置信息 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:31<br>
 */
@Configuration
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    // region 常用属性设置

    /**
     * Redis模式
     */
    private RedisModelEnum redisModel = RedisModelEnum.SINGLE;

    /**
     * 编码方式 默认org.redisson.codec.JsonJacksonCodec
     */
    private String codec = "org.redisson.codec.JsonJacksonCodec";

    /**
     * 默认值：当前处理核数量 * 2
     * <p>
     * 这个线程池数量被所有RTopic对象监听器，RRemoteService调用者和RExecutorService任务共同共享。默认2
     */
    private Integer threads;

    /**
     * 默认值：当前处理核数量 * 2
     * 这个线程池数量是在一个Redisson实例内，被其创建的所有分布式数据类型和服务，以及底层客户端所一同共享的线程池里保存的线程数量。默认2
     */
    private Integer nettyThreads;


    /**
     * 传输模式
     * <p>
     * 默认值：TransportMode.NIO
     * <p>
     * 可选参数：
     * TransportMode.NIO,
     * TransportMode.EPOLL - 需要依赖里有netty-transport-native-epoll包（Linux） TransportMode.KQUEUE - 需要依赖里有 netty-transport-native-kqueue包（macOS）
     */
    private TransportMode transportMode = TransportMode.NIO;


    /**
     * 分布式锁自动过期时间，防止死锁，默认30000
     */
    private int lockWatchdogTimeout;


    // endregion


    // region 公共参数

    /**
     * 连接空闲超时，单位：毫秒 默认10000
     * <p>
     * 如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
     */
    private int idleConnectionTimeout = 10000;

    /**
     * 同任何节点建立连接时的等待超时。时间单位是毫秒 默认10000
     */
    private int connectTimeout = 10000;

    /**
     * 等待节点回复命令的时间。该时间从命令发送成功时开始计时。默认3000
     */
    private int timeout = 3000;

    /**
     * 在Redis节点里显示的客户端名称。
     */
    private String clientName;

    /**
     * 命令失败重试次数
     * <p>
     * 如果尝试达到 retryAttempts（命令失败重试次数） 仍然不能将命令发送至某个指定的节点时，将抛出错误。如果尝试在此限制之内发送成功，则开始启用 timeout（命令等待超时） 计时
     */
    private int retryAttempts = 3;

    /**
     * 命令重试发送时间间隔，单位：毫秒
     * <p>
     * 在一条命令发送失败以后，等待重试发送的时间间隔。时间单位是毫秒。
     */
    private int retryInterval = 1500;


    /**
     * 密码
     */
    private String password;


    /**
     * 单个连接最大订阅数量
     */
    private int subscriptionsPerConnection = 5;


    /**
     * 从节点发布和订阅连接池大小 默认值50
     * <p>
     * 多从节点的环境里，每个 从服务节点里用于发布和订阅连接的连接池最大容量。连接池的连接数量自动弹性伸缩。
     */
    private int slaveSubscriptionConnectionPoolSize = 50;


    /**
     * 从节点发布和订阅连接的最小空闲连接数,默认值 1
     * <p>
     * 多从节点的环境里，每个 从服务节点里用于发布和订阅连接的最小保持连接数（长连接）。Redisson内部经常通过发布和订阅来实现许多功能。长期保持一定数量的发布订阅连接是必须的。
     */
    private int slaveSubscriptionConnectionMinimumIdleSize = 1;

    /**
     * sslEnableEndpointIdentification（启用SSL终端识别）
     * 默认值：true
     * <p>
     * 开启SSL终端识别能力。
     */
    private Boolean sslEnableEndpointIdentification = Boolean.TRUE;

    /**
     * 默认值：JDK
     *
     * 确定采用哪种方式（JDK或OPENSSL）来实现SSL连接。
     */
    private SslProvider sslProvider = SslProvider.JDK;

    /**
     *sslTruststore（SSL信任证书库路径）
     * 默认值：null
     *
     * 指定SSL信任证书库的路径。
     */
    private URL sslTruststore;

    /**
     * sslTruststorePassword（SSL信任证书库密码）
     * 默认值：null
     *
     * 指定SSL信任证书库的密码。
     */
    private String sslTruststorePassword;

    /**
     * sslKeystore（SSL钥匙库路径）
     * 默认值：null
     *
     * 指定SSL钥匙库的路径。
     */
    private URL sslKeystore;

    /**
     * sslKeystorePassword（SSL钥匙库密码）
     * 默认值：null
     *
     * 指定SSL钥匙库的密码。
     */
    private String sslKeystorePassword;

    // endregion

    // region 扩展参数
    @NestedConfigurationProperty
    private SingleRedisServerConfig singleConfig;

    @NestedConfigurationProperty
    private MultipleRedisServerConfig multipleConfig;
    // endregion


    public RedisModelEnum getRedisModel() {
        return redisModel;
    }

    public void setRedisModel(RedisModelEnum redisModel) {
        this.redisModel = redisModel;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public Integer getNettyThreads() {
        return nettyThreads;
    }

    public void setNettyThreads(Integer nettyThreads) {
        this.nettyThreads = nettyThreads;
    }

    public TransportMode getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(TransportMode transportMode) {
        this.transportMode = transportMode;
    }

    public int getLockWatchdogTimeout() {
        return lockWatchdogTimeout;
    }

    public void setLockWatchdogTimeout(int lockWatchdogTimeout) {
        this.lockWatchdogTimeout = lockWatchdogTimeout;
    }

    public int getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(int idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSubscriptionsPerConnection() {
        return subscriptionsPerConnection;
    }

    public void setSubscriptionsPerConnection(int subscriptionsPerConnection) {
        this.subscriptionsPerConnection = subscriptionsPerConnection;
    }

    public int getSlaveSubscriptionConnectionPoolSize() {
        return slaveSubscriptionConnectionPoolSize;
    }

    public void setSlaveSubscriptionConnectionPoolSize(int slaveSubscriptionConnectionPoolSize) {
        this.slaveSubscriptionConnectionPoolSize = slaveSubscriptionConnectionPoolSize;
    }

    public int getSlaveSubscriptionConnectionMinimumIdleSize() {
        return slaveSubscriptionConnectionMinimumIdleSize;
    }

    public void setSlaveSubscriptionConnectionMinimumIdleSize(int slaveSubscriptionConnectionMinimumIdleSize) {
        this.slaveSubscriptionConnectionMinimumIdleSize = slaveSubscriptionConnectionMinimumIdleSize;
    }

    public Boolean getSslEnableEndpointIdentification() {
        return sslEnableEndpointIdentification;
    }

    public void setSslEnableEndpointIdentification(Boolean sslEnableEndpointIdentification) {
        this.sslEnableEndpointIdentification = sslEnableEndpointIdentification;
    }

    public SslProvider getSslProvider() {
        return sslProvider;
    }

    public void setSslProvider(SslProvider sslProvider) {
        this.sslProvider = sslProvider;
    }

    public URL getSslTruststore() {
        return sslTruststore;
    }

    public void setSslTruststore(URL sslTruststore) {
        this.sslTruststore = sslTruststore;
    }

    public String getSslTruststorePassword() {
        return sslTruststorePassword;
    }

    public void setSslTruststorePassword(String sslTruststorePassword) {
        this.sslTruststorePassword = sslTruststorePassword;
    }

    public URL getSslKeystore() {
        return sslKeystore;
    }

    public void setSslKeystore(URL sslKeystore) {
        this.sslKeystore = sslKeystore;
    }

    public String getSslKeystorePassword() {
        return sslKeystorePassword;
    }

    public void setSslKeystorePassword(String sslKeystorePassword) {
        this.sslKeystorePassword = sslKeystorePassword;
    }

    public SingleRedisServerConfig getSingleConfig() {
        return singleConfig;
    }

    public void setSingleConfig(SingleRedisServerConfig singleConfig) {
        this.singleConfig = singleConfig;
    }

    public MultipleRedisServerConfig getMultipleConfig() {
        return multipleConfig;
    }

    public void setMultipleConfig(MultipleRedisServerConfig multipleConfig) {
        this.multipleConfig = multipleConfig;
    }
}
