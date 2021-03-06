package io.seata.samples.integration.call.service;


import io.seata.core.context.RootContext;
import io.seata.samples.integration.common.dto.BusinessDTO;
import io.seata.samples.integration.common.dto.BuyReq;
import io.seata.samples.integration.common.dto.GoodOrder;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.dubbo.AccountDubboService;
import io.seata.samples.integration.common.dubbo.OrderDubboService;
import io.seata.samples.integration.common.dubbo.StorageDubboService;
import io.seata.samples.integration.common.exception.ServiceException;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.common.utils.TimeUtil;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-22
 */
@Service("tccBusinessService")
public class TccBusinessServiceImpl implements BusinessService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private StorageDubboService storageDubboService;

    @Reference
    private OrderDubboService orderDubboService;

    @Reference
    private AccountDubboService accountDubboService;


    @Override
    @GlobalTransactional()
    public ObjectResponse handleBusiness(BusinessDTO businessDTO) {
        logger.info("开始全局事务，XID = " + RootContext.getXID());
        ObjectResponse<Object> objectResponse = new ObjectResponse<>();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        orderDTO.setFlag(businessDTO.isFlag());

//        ObjectResponse<OrderDTO> orderDTOObjectResponse = orderDubboService.tccGoodOrder(new GoodOrder());

        return null;
    }

    @Override
    public ObjectResponse handleBusiness2(BusinessDTO businessDTO) {
        return null;
    }

    @Override
    @GlobalTransactional(timeoutMills = 3000)
    public ObjectResponse buy(BuyReq buyReq) {
        GoodOrder goodOrder = new GoodOrder();
        goodOrder.setFlag(buyReq.isFlag());
        goodOrder.setUid(buyReq.getUid());
        goodOrder.setGoodId(buyReq.getGoodId());
        goodOrder.setNumber(buyReq.getNum());
        goodOrder.setPrice(buyReq.getPrice());

        long t1 = System.currentTimeMillis();

        GoodOrder order = orderDubboService.tccGoodOrder(goodOrder);


        accountDubboService.tccDecreaseAccount(order);

        long t2 = System.currentTimeMillis();

        if(buyReq.isFlag()) {
            throw new ServiceException("主动抛出异常");
        }

        ObjectResponse objectResponse = new ObjectResponse();
        objectResponse.setData(order);
        objectResponse.setStatus(0);
        objectResponse.setMessage("success");
        objectResponse.setTime(t2 - t1);

        return objectResponse;
    }
}
