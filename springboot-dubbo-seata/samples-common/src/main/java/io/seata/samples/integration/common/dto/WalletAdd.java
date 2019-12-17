package io.seata.samples.integration.common.dto;

import java.io.Serializable;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-12-17
 */
public class WalletAdd implements Serializable {
    private long uid;
    private long balance;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
