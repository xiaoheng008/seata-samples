package io.seata.samples.integration.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.order")
@EnableDiscoveryClient
@MapperScan({"io.seata.samples.integration.order.mapper"})
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.order")
@EnableTransactionManagement
public class OrderExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderExampleApplication.class, args);
    }

}

