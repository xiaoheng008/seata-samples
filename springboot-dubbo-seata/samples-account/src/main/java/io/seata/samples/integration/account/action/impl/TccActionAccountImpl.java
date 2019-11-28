package io.seata.samples.integration.account.action.impl;

import com.alibaba.fastjson.JSON;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.account.action.ResultHolder;
import io.seata.samples.integration.account.action.TccActionAccount;
import io.seata.samples.integration.common.dto.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The type Tcc action one.
 *
 * @author zhangsen
 */
@Component
public class TccActionAccountImpl implements TccActionAccount {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean prepare(BusinessActionContext actionContext, AccountDTO accountDTO) {
        String xid = actionContext.getXid();
        logger.info("TccActionAccount prepare, xid:" + xid + ", accountDTO:" + JSON.toJSONString(accountDTO));
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        logger.info("TccActionAccount commit, xid:" + xid + ", accountDTO:" + actionContext.getActionContext("accountDTO"));
        ResultHolder.setActionOneResult(xid, "T");
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        logger.info("TccActionAccount rollback, xid:" + xid + ", accountDTO:" + actionContext.getActionContext("accountDTO"));
        ResultHolder.setActionOneResult(xid, "R");
        return true;
    }
}
