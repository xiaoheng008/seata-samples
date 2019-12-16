package io.seata.samples.integration.order.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import io.seata.samples.integration.common.dto.OrderDTO;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-28
 */
@LocalTCC
public interface OrderAction {

    @TwoPhaseBusinessAction(name = "OrderAction" , commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext,
                    @BusinessActionContextParameter(paramName = "orderId") Long orderId);

    /**
     * Commit boolean.
     *
     * @param actionContext the action context
     * @return the boolean
     */
    boolean commit(BusinessActionContext actionContext);

    /**
     * Rollback boolean.
     *
     * @param actionContext the action context
     * @return the boolean
     */
    boolean rollback(BusinessActionContext actionContext);
}
