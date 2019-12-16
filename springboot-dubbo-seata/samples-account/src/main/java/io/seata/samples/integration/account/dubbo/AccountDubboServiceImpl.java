package io.seata.samples.integration.account.dubbo;


import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.samples.integration.account.action.TccActionAccount;
import io.seata.samples.integration.account.action.WalletAction;
import io.seata.samples.integration.account.service.ITAccountService;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.dto.GoodOrder;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.dubbo.AccountDubboService;
import io.seata.samples.integration.common.response.ObjectResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: heshouyou
 * @Description Dubbo Api Impl
 * @Date Created in 2019/1/23 14:40
 */
@Service
public class AccountDubboServiceImpl implements AccountDubboService {

    @Autowired
    private ITAccountService accountService;

    @Autowired
    private TccActionAccount tccActionAccount;

    @Autowired
    private WalletAction walletAction;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return accountService.decreaseAccount(accountDTO);
//        return null;
    }

    @Override
    public void tccDecreaseAccount(GoodOrder goodOrder) {
        walletAction.prepare(null, goodOrder.getUid(), goodOrder.getAmount(), goodOrder.getOrderId());
    }
}
