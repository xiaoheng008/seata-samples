package io.seata.samples.integration.order.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: heshouyou
 * @Description  seata global configuration
 * @Date Created in 2019/1/24 10:28
 */
@Configuration
public class SeataAutoConfig {

    /**
     * autowired datasource config
     */
//    @Autowired
//    private DataSourceProperties dataSourceProperties;

    /**
     * init durid datasource
     *
     * @Return: druidDataSource  datasource instance
     */
//    @Bean(name = "dataSource")
//    @Primary
//    @ConfigurationProperties("spring.datasource")
//    public DataSource druidDataSource(){
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    /**
//     * init datasource proxy
//     * @Param: druidDataSource  datasource bean instance
//     * @Return: DataSourceProxy  datasource proxy
//     */
//    @Bean(name = "dataSourceProxy")
//    public DataSourceProxy dataSourceProxy(@Qualifier("dataSource")DataSource dataSource){
//        return new DataSourceProxy(dataSource);
//    }
//
//    /**
//     * init mybatis sqlSessionFactory
//     * @Param: dataSourceProxy  datasource proxy
//     * @Return: DataSourceProxy  datasource proxy
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceProxy") DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSourceProxy);
//        factoryBean.setTypeAliasesPackage("io.seata.samples.integration.order");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/*.xml"));
//        factoryBean.setTransactionFactory(new JdbcTransactionFactory());
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer cfg = new MapperScannerConfigurer();
//        cfg.setBasePackage("io.seata.samples.integration.order.mapper");
//        cfg.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        return cfg;
//    }
//
//    @Bean("txManager")
//    public PlatformTransactionManager annotationDrivenTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    /**
     * init global transaction scanner
     *
     * @Return: GlobalTransactionScanner
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("order-gts-seata-example", "my_test_tx_group");
    }
}
