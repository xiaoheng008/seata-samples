package io.seata.samples.integration.account;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import io.seata.samples.integration.account.config.SeataAutoConfig;
import io.seata.samples.integration.account.controller.TAccountController;
import io.seata.samples.integration.account.service.ITAccountService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan({"io.seata.samples.integration.account.mapper"})
@EnableDubbo
public class AccountExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountExampleApplication.class, args);
    }

}

