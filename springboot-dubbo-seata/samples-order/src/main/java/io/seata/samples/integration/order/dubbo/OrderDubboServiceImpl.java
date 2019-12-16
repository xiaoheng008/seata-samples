package io.seata.samples.integration.order.dubbo;


import com.alibaba.fastjson.JSON;
import io.seata.core.context.RootContext;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.dubbo.AccountDubboService;
import io.seata.samples.integration.common.dubbo.OrderDubboService;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.common.utils.BeanCopyUtil;
import io.seata.samples.integration.order.action.OrderAction;
import io.seata.samples.integration.order.action.TccActionOrder;
import io.seata.samples.integration.common.dto.GoodOrder;
import io.seata.samples.integration.order.entity.GoodOrderPO;
import io.seata.samples.integration.order.service.GoodOrderService;
import io.seata.samples.integration.order.service.ITOrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 15:59
 */
@Service
public class OrderDubboServiceImpl implements OrderDubboService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ITOrderService orderService;

    @Autowired
    private TccActionOrder tccActionOrder;

    @Reference
    private AccountDubboService accountDubboService;

    @Autowired
    private OrderAction orderAction;

    @Autowired
    private GoodOrderService goodOrderService;

    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return orderService.createOrder(orderDTO);
//        return null;
    }

    @Override
    public ObjectResponse<OrderDTO> createOrder2(OrderDTO orderDTO) {
        System.out.println("单机事务，全局id ：" + RootContext.getXID());
        return orderService.createOrder2(orderDTO);
    }

    /**
     * 走tcc的下单流程
     *
     * @param goodOrder
     * @return
     */
    @Override
    public GoodOrder tccGoodOrder(GoodOrder goodOrder) {
        ObjectResponse<OrderDTO> objectObjectResponse = new ObjectResponse<>();

        GoodOrderPO order = goodOrderService.createOrder(goodOrder.getUid(), goodOrder.getGoodId(), goodOrder.getNumber(),
                goodOrder.getPrice());

        // TODO: 2019-11-28 获取商品价格
        long t1 = System.currentTimeMillis();
        orderAction.prepare(null, order.getOrderId());
        long t2 = System.currentTimeMillis();
        GoodOrder copy = BeanCopyUtil.copy(order, GoodOrder.class);
        long t3 = System.currentTimeMillis();
        logger.info("orderAction#prepare | 1: {}, 2: {}, all: {}", t2-t1, t3-t2, t3-t1);
        return copy;
    }
}
