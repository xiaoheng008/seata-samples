package io.seata.samples.integration.call.service;


import io.seata.core.context.RootContext;
import io.seata.samples.integration.common.dto.BusinessDTO;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.dubbo.OrderDubboService;
import io.seata.samples.integration.common.dubbo.StorageDubboService;
import io.seata.samples.integration.common.enums.RspStatusEnum;
import io.seata.samples.integration.common.exception.DefaultException;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: heshouyou
 * @Description  Dubbo业务发起方逻辑
 * @Date Created in 2019/1/14 18:36
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(version = "1.0.0")
    private StorageDubboService storageDubboService;

    @Reference(version = "1.0.0")
    private OrderDubboService orderDubboService;

    private boolean flag;

    /**
     * 处理业务逻辑
     * @Param:
     * @Return:
     */
    @Override
    @GlobalTransactional(timeoutMills = 10000, name = "dubbo-gts-seata-example")
    public ObjectResponse handleBusiness(BusinessDTO businessDTO) {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        ObjectResponse<Object> objectResponse = new ObjectResponse<>();
        //1、扣减库存 暂时不要库存，只要创建订单跟扣钱 2019-10-28
//        CommodityDTO commodityDTO = new CommodityDTO();
//        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
//        commodityDTO.setCount(businessDTO.getCount());
//        ObjectResponse storageResponse = storageDubboService.decreaseStorage(commodityDTO);

        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        ObjectResponse<OrderDTO> response = orderDubboService.createOrder(orderDTO);

        //打开注释测试事务发生异常后，全局回滚功能
        if (businessDTO.isFlag()) {
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        }else{
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        storageResponse.getStatus() != 200 ||
        if (response.getStatus() != 200) {
            throw new DefaultException(RspStatusEnum.FAIL);
        }

        objectResponse.setStatus(RspStatusEnum.SUCCESS.getCode());
        objectResponse.setMessage(RspStatusEnum.SUCCESS.getMessage());
        objectResponse.setData(response.getData());
        return objectResponse;
    }

    /**
     * 处理业务逻辑
     * @Param:
     * @Return:
     */
    @Override
    @GlobalTransactional(timeoutMills = 10000, name = "dubbo-gts-seata-example")
    public ObjectResponse handleBusiness2(BusinessDTO businessDTO) {
        ObjectResponse<Object> objectResponse = new ObjectResponse<>();

        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        orderDTO.setFlag(businessDTO.isFlag());
        logger.info("准备创建订单");
        ObjectResponse<OrderDTO> response = orderDubboService.createOrder2(orderDTO);
        logger.info("创建完订单");

        if (response.getStatus() != 200) {
            throw new DefaultException(RspStatusEnum.FAIL);
        }

        objectResponse.setStatus(RspStatusEnum.SUCCESS.getCode());
        objectResponse.setMessage(RspStatusEnum.SUCCESS.getMessage());
        objectResponse.setData(response.getData());
        return objectResponse;
    }
}
