package io.seata.samples.integration.order.service;
import java.math.BigDecimal;

import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-10-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TOrderServiceImplTest {

    @Autowired
    private ITOrderService itOrderService;

    @Test
//    @Transactional
    public void createOrder2() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId("1");
        orderDTO.setCommodityCode("C201901140001");
        orderDTO.setOrderCount(1);
        orderDTO.setOrderAmount(new BigDecimal("1"));

        ObjectResponse<OrderDTO> order2 = itOrderService.createOrder2(orderDTO);
    }
}