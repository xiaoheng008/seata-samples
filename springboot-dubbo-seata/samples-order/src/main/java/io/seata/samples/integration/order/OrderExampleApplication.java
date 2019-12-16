package io.seata.samples.integration.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "io.seata.samples.integration")
@EnableTransactionManagement
public class OrderExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderExampleApplication.class, args);
    }

}

