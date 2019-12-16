package io.seata.samples.integration.account.action.impl;

import com.alibaba.fastjson.JSON;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.account.action.WalletAction;
import io.seata.samples.integration.account.service.WalletService;
import io.seata.samples.integration.common.enums.WalletSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-29
 */
@Slf4j
@Service
public class WalletActionImpl implements WalletAction {

    @Autowired
    private WalletService walletService;

    @Override
    public boolean prepare(BusinessActionContext actionContext, long uid, long amount, long orderId) {
        walletService.subTry(uid, amount, orderId, WalletSource.ORDER);
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        Map<String, Object> param = actionContext.getActionContext();
        Object orderId = param.get("orderId");
        walletService.subConfirm((Integer) orderId, WalletSource.ORDER);
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        Map<String, Object> param = actionContext.getActionContext();
        Object orderId = param.get("orderId");
        walletService.subCancel((Integer) orderId, WalletSource.ORDER);
        return true;
    }
}
