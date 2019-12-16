package io.seata.samples.integration.order.action.impl;

import com.alibaba.fastjson.JSON;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.common.enums.TccStatus;
import io.seata.samples.integration.order.action.OrderAction;
import io.seata.samples.integration.order.entity.GoodOrderPO;
import io.seata.samples.integration.order.service.GoodOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-28
 */
@Service
@Slf4j
public class OrderActionImpl implements OrderAction {

    public static final String PARAM_NAME = "orderId";

    @Autowired
    private GoodOrderService goodOrderService;

    @Override
    public boolean prepare(BusinessActionContext actionContext, Long orderId) {
        log.info("OrderActionImpl#prepare | try | content: {}", actionContext.getActionContext().get(PARAM_NAME));
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        log.info("OrderActionImpl#commit | confirm | content: {}", actionContext.getActionContext().get(PARAM_NAME));
        Integer value = (Integer) actionContext.getActionContext().get(PARAM_NAME);
        log.info("OrderActionImpl#commit | confirm-------------------- | content: {}", value);
        Long orderId = Long.valueOf(value);
        GoodOrderPO order = goodOrderService.getOrder(orderId);
        if (order.getStatus() == TccStatus.CONFIRM.getStatus()) {
            return true;
        }

        goodOrderService.updateStatus(orderId, TccStatus.CONFIRM, TccStatus.getInstance(order.getStatus()));
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        log.info("OrderActionImpl#rollback | cancel | content: {}", actionContext.getActionContext().get(PARAM_NAME));
        Integer value = (Integer) actionContext.getActionContext().get(PARAM_NAME);
        log.info("OrderActionImpl#commit | cancel-------------------- | content: {}", value);
        Long orderId = Long.valueOf(value);
        GoodOrderPO order = goodOrderService.getOrder(orderId);
        log.info("order------------: {}", JSON.toJSONString(order));
        if (order.getStatus() == TccStatus.CANCEL.getStatus()) {
            return true;
        }
        goodOrderService.updateStatus(orderId, TccStatus.CANCEL, TccStatus.getInstance(order.getStatus()));

        order = goodOrderService.getOrder(orderId);
        log.info("order------------: {}", JSON.toJSONString(order));
        return true;
    }
}
