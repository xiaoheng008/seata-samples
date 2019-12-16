package io.seata.samples.integration.order.service;

import com.baomidou.mybatisplus.service.IService;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.order.entity.TAccount;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface ITAccountService extends IService<TAccount> {

    /**
     * 扣用户钱
     */
    ObjectResponse decreaseAccount(AccountDTO accountDTO);

    void testGlobalLock();
}
