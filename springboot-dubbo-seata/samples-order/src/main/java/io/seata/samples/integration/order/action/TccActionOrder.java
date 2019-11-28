package io.seata.samples.integration.order.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import io.seata.samples.integration.common.dto.OrderDTO;

/**
 * The interface Tcc action one.
 *
 * @author zhangsen
 */
@LocalTCC
public interface TccActionOrder {

    /**
     * Prepare boolean.
     *
     * @param actionContext the action context
     * @param orderDTO      the orderDTO
     * @return the boolean
     */
    @TwoPhaseBusinessAction(name = "TccActionOrder" , commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext,
                    @BusinessActionContextParameter(paramName = "orderDTO") OrderDTO orderDTO);

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
