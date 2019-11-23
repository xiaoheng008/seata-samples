package io.seata.samples.integration.order.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.dubbo.AccountDubboService;
import io.seata.samples.integration.common.dubbo.OrderDubboService;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.order.action.TccActionOrder;
import io.seata.samples.integration.order.entity.TOrder;
import io.seata.samples.integration.order.service.ITOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 15:59
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
        timeout = 3000)
public class OrderDubboServiceImpl implements OrderDubboService {

    @Autowired
    private ITOrderService orderService;

    @Autowired
    private TccActionOrder tccActionOrder;

    @Reference(version = "1.0.0")
    private AccountDubboService accountDubboService;

    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return orderService.createOrder(orderDTO);
    }

    @Override
    public ObjectResponse<OrderDTO> createOrder2(OrderDTO orderDTO) {
        System.out.println("单机事务，全局id ：" + RootContext.getXID());
        return orderService.createOrder2(orderDTO);
    }

    @Override
    public ObjectResponse<OrderDTO> tccCreateOrder(OrderDTO orderDTO) {
        ObjectResponse<OrderDTO> objectObjectResponse = new ObjectResponse<>();

        BusinessActionContext businessActionContext = new BusinessActionContext();
        businessActionContext.setXid(RootContext.getXID());

        tccActionOrder.prepare(businessActionContext, orderDTO);

        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(orderDTO,tOrder);
        tOrder.setCount(orderDTO.getOrderCount());
        tOrder.setAmount(orderDTO.getOrderAmount().doubleValue());
        //生成订单

        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        accountDubboService.tccDecreaseAccount(accountDTO);

        return objectObjectResponse;
    }
}
