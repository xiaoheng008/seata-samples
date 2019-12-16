package io.seata.samples.integration.call.controller;

import io.seata.samples.integration.call.service.BusinessService;
import io.seata.samples.integration.call.service.CountService;
import io.seata.samples.integration.common.dto.BusinessDTO;
import io.seata.samples.integration.common.dto.BuyReq;
import io.seata.samples.integration.common.response.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: heshouyou
 * @Description  Dubbo业务执行入口
 * @Date Created in 2019/1/14 17:15
 */
@RestController
@RequestMapping("/business/dubbo")
@Slf4j
public class BusinessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessController.class);


    @Autowired
    private BusinessService businessService;

    @Autowired
    private BusinessService tccBusinessService;

    @Autowired
    private CountService countService;

    @PostMapping("/tccbuy")
    public ObjectResponse tcc(@RequestBody BuyReq buyReq) {
        long start = System.currentTimeMillis();
        ObjectResponse objectResponse = new ObjectResponse();

        try {
            objectResponse = tccBusinessService.buy(buyReq);
//            countService.success(System.currentTimeMillis() - start);
        }catch (Exception e) {
//            countService.failure(System.currentTimeMillis() - start);
            //如果不会滚的情况下报错了，要打印
            if(!buyReq.isFlag()){
                LOGGER.error("请求失败：{}",e);
            }

        }

        long use = System.currentTimeMillis() - start;
        objectResponse.setOthenTime(objectResponse.getTime());
        objectResponse.setTime(use);
        LOGGER.info("分布式事务执行时间: {}, flag: {}", use, buyReq.isFlag());

        return objectResponse;
    }

    /**
     * 模拟用户购买商品下单业务逻辑流程
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    public ObjectResponse handleBusiness(@RequestBody BusinessDTO businessDTO){
        LOGGER.info("请求参数：{}",businessDTO.toString());

        long start = System.currentTimeMillis();
        ObjectResponse objectResponse = new ObjectResponse();
        try {
            objectResponse = businessService.handleBusiness(businessDTO);
//            countService.success(System.currentTimeMillis() - start);
        }catch (Exception e) {
//            countService.failure(System.currentTimeMillis() - start);
            //如果不会滚的情况下报错了，要打印
            if(!businessDTO.isFlag()){
                LOGGER.error("请求失败：{}",e);
            }

        }
        long use = System.currentTimeMillis() - start;
        objectResponse.setTime(use);
        LOGGER.info("分布式事务执行时间: {}, flag: {}", use, businessDTO.isFlag());

        return objectResponse;
    }

    /**
     * 模拟用户购买商品下单业务逻辑流程 单机版
     * @Param:
     * @Return:
     */
    @PostMapping("/buy2")
    public ObjectResponse handleBusiness2(@RequestBody BusinessDTO businessDTO){
        LOGGER.info("请求参数：{}",businessDTO.toString());

        long start = System.currentTimeMillis();
        ObjectResponse objectResponse = new ObjectResponse();
        try {
            objectResponse = businessService.handleBusiness2(businessDTO);
//            countService.success(System.currentTimeMillis() - start);
        }catch (Exception e) {
//            countService.failure(System.currentTimeMillis() - start);
            //如果不会滚的情况下报错了，要打印
            if(!businessDTO.isFlag()){
                LOGGER.error("请求失败：{}",e);
            }
        }
        long use = System.currentTimeMillis() - start;
        objectResponse.setTime(use);
        LOGGER.info("单机事务执行时间: {}, flag: {}", use, businessDTO.isFlag());

        return objectResponse;
    }

    @PostMapping("/test")
    public ObjectResponse test(@RequestBody BusinessDTO businessDTO){
        LOGGER.info("请求参数：{}",businessDTO.toString());

        return new ObjectResponse();
    }
}
