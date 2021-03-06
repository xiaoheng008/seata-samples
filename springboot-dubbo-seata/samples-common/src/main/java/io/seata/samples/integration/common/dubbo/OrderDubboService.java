package io.seata.samples.integration.common.dubbo;

import io.seata.samples.integration.common.dto.GoodOrder;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.response.ObjectResponse;

/**
 * @Author: heshouyou
 * @Description  订单服务接口
 * @Date Created in 2019/1/13 16:28
 */
public interface OrderDubboService {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);


    ObjectResponse<OrderDTO> createOrder2(OrderDTO orderDTO);

    GoodOrder tccGoodOrder(GoodOrder goodOrder);

}
