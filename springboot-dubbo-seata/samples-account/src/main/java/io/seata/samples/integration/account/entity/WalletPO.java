package io.seata.samples.integration.account.entity;

import java.io.Serializable;


/**
 * 钱包表
 * 
 * <pre>
 *     自动生成代码: 表名 t_wallet, 日期: 2019-11-28
 *     uid <PK>             bigint(20)
 *     balance        bigint(20)
 *     create_time    int(11)
 *     update_time    int(11)
 * </pre>
 */
public class WalletPO implements Serializable {

    private static final long serialVersionUID = -3074457343585479603L;

    /** uid */
    private long uid;

    /** 余额 */
    private long balance;

    /** 创建时间 */
    private int createTime;

    /** 更新时间 */
    private int updateTime;

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return uid;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

}
