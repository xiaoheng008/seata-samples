package io.seata.samples.integration.order.action.impl;

import com.alibaba.fastjson.JSON;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.order.action.ResultHolder;
import io.seata.samples.integration.order.action.TccActionOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The type Tcc action one.
 *
 * @author zhangsen
 */
@Component
public class TccActionOrderImpl implements TccActionOrder {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean prepare(BusinessActionContext actionContext, OrderDTO orderDTO) {
        String xid = actionContext.getXid();
        logger.info("TccActionOrder prepare, xid:" + xid + ", order:" + JSON.toJSONString(orderDTO));
        return false;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        logger.info("TccActionOrder commit, xid:" + xid + ", orderDTO:" + actionContext.getActionContext("orderDTO"));
        ResultHolder.setActionOneResult(xid, "T");
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        logger.info("TccActionOrder rollback, xid:" + xid + ", orderDTO:" + actionContext.getActionContext("orderDTO"));
        ResultHolder.setActionOneResult(xid, "R");
        return true;
    }
}
