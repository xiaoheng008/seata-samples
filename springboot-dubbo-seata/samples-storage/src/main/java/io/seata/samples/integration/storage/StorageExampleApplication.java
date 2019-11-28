package io.seata.samples.integration.storage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.storage")
@EnableDiscoveryClient
@MapperScan({"io.seata.samples.integration.storage.mapper"})
public class StorageExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageExampleApplication.class, args);
    }

}

