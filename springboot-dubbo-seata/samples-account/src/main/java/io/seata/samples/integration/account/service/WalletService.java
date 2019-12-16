package io.seata.samples.integration.account.service;

import io.seata.samples.integration.account.entity.WalletLogPO;
import io.seata.samples.integration.account.entity.WalletPO;
import io.seata.samples.integration.account.mapper.WalletDao;
import io.seata.samples.integration.account.mapper.WalletLogDao;
import io.seata.samples.integration.common.enums.Oper;
import io.seata.samples.integration.common.enums.TccStatus;
import io.seata.samples.integration.common.enums.WalletSource;
import io.seata.samples.integration.common.utils.ParameterUtil;
import io.seata.samples.integration.common.utils.TimeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-28
 */
@Service
public class WalletService {

    @Autowired
    private WalletDao walletDao;

    @Autowired
    private WalletLogDao walletLogDao;


    public void create(long uid, long balance) {
        WalletPO walletPO = new WalletPO();
        walletPO.setUid(uid);
        walletPO.setBalance(balance);
        walletPO.setCreateTime(TimeUtil.getCurrTime());
        walletPO.setUpdateTime(TimeUtil.getCurrTime());

        walletDao.insert(walletPO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void subTry(long uid, long amount, long orderId, WalletSource source) {
        WalletPO walletPO = walletDao.get(uid);
        ParameterUtil.assertNotNull(walletPO, "can not find wallet: " + uid);

        ParameterUtil.assertTrue(walletPO.getBalance() >= amount, "Insufficient balance: " + uid);

        walletDao.sub(uid, amount);
        walletPO = walletDao.get(uid);

        WalletLogPO walletLogPO = new WalletLogPO();
        walletLogPO.setUid(uid);
        walletLogPO.setAmount(amount);
        walletLogPO.setBeforeAmount(walletPO.getBalance() + amount);
        walletLogPO.setAfterAmount(walletPO.getBalance());
        walletLogPO.setOper(Oper.SUB.getOper());
        walletLogPO.setStatus(TccStatus.TRY.getStatus());
        walletLogPO.setSource(source.getSource());
        walletLogPO.setOrderId(orderId);
        walletLogPO.setCreateTime(TimeUtil.getCurrTime());
        walletLogPO.setUpdateTime(TimeUtil.getCurrTime());

        walletLogDao.insert(walletLogPO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void subConfirm(long orderId, WalletSource source){
        WalletLogPO walletLogPO = walletLogDao.getBySourceAndOrderId(source.getSource(), orderId);
        ParameterUtil.assertNotNull(walletLogPO, "can not find wallet log: " + orderId + ", source: " + source.getSource());

        if(walletLogPO.getStatus() == TccStatus.CONFIRM.getStatus()) {
            return ;
        }

        ParameterUtil.assertTrue(walletLogPO.getStatus() == TccStatus.TRY.getStatus(), "wallet log status not try");

        int rows = walletLogDao.updateByStatus(walletLogPO.getLogId(), TccStatus.CONFIRM.getStatus(), walletLogPO.getStatus());
        ParameterUtil.assertTrue(rows == 1, "update wallet log error: " + orderId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void subCancel(long orderId, WalletSource source) {
        //logId不存在，直接结束
        WalletLogPO walletLogPO = walletLogDao.getBySourceAndOrderId(source.getSource(), orderId);
        if (walletLogPO == null) {
            return;
        }

        //状态已经是cancel，直接结束
        if (walletLogPO.getStatus() == TccStatus.CANCEL.getStatus()) {
            return;
        }

        ParameterUtil.assertTrue(walletLogPO.getStatus() == TccStatus.TRY.getStatus(), "status not try");

        //加钱
        int rows = walletDao.add(walletLogPO.getUid(), walletLogPO.getAmount());
        ParameterUtil.assertTrue(rows == 1, "update wallet error");

        //修改log status
        int i = walletLogDao.updateByStatus(walletLogPO.getLogId(), TccStatus.CANCEL.getStatus(), walletLogPO.getStatus());
        ParameterUtil.assertTrue(i == 1, "update wallet_log error");
    }
}
