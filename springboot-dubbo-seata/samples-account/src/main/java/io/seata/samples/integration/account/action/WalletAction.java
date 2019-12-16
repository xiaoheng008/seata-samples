package io.seata.samples.integration.account.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import io.seata.samples.integration.common.dto.AccountDTO;

/**
 * The interface Tcc action one.
 *
 * @author zhangsen
 */
@LocalTCC
public interface WalletAction {

    /**
     * Prepare boolean.
     *
     * @param actionContext the action context
     * @param uid
     * @param amount
     * @param orderId
     * @return the boolean
     */
    @TwoPhaseBusinessAction(name = "WalletAction" , commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext,
                    @BusinessActionContextParameter(paramName = "uid") long uid,
                    @BusinessActionContextParameter(paramName = "amount") long amount,
                    @BusinessActionContextParameter(paramName = "orderId") long orderId);

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
