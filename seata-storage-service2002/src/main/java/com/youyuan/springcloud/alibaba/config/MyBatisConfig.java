package com.youyuan.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangy
 * @version 1.0
 * @description  配置mybatis
 * @date 2020/4/22 17:59
 */
@Configuration
@MapperScan({"com.youyuan.springcloud.alibaba.dao"})
public class MyBatisConfig {
//    @Value("${mybatis.mapper-locations}")
//    private String mapperLocations;
//
//    /**
//     * @param sqlSessionFactory SqlSessionFactory
//     * @return SqlSessionTemplate
//     */
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    /**
//     * 从配置文件获取属性构造datasource，注意前缀，这里用的是druid，根据自己情况配置,
//     * 原生datasource前缀取"spring.datasource"
//     *
//     * @return
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        return new DruidDataSource();
//    }
//
//    /**
//     * 构造datasource代理对象，替换原来的datasource
//     *
//     * @param druidDataSource
//     * @return
//     */
//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSourceProxy);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources(mapperLocations));
//
//        SqlSessionFactory factory;
//        try {
//            factory = bean.getObject();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return factory;
//    }
}
