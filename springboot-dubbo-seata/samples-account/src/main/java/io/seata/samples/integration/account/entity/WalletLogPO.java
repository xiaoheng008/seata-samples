package io.seata.samples.integration.account.entity;

import java.io.Serializable;


/**
 * 钱包日志表
 * 
 * <pre>
 *     自动生成代码: 表名 t_wallet_log, 日期: 2019-11-28
 *     log_id <PK>            bigint(20)
 *     uid              bigint(20)
 *     amount           bigint(20)
 *     before_amount    bigint(20)
 *     after_amount     bigint(20)
 *     oper             tinyint(4)
 *     status           tinyint(4)
 *     source           tinyint(4)
 *     order_id         bigint(20)
 *     create_time      int(11)
 *     update_time      int(11)
 * </pre>
 */
public class WalletLogPO implements Serializable {

    private static final long serialVersionUID = -3074457343534188181L;

    /** 钱包日志表 */
    private long logId;

    /** uid */
    private long uid;

    /** 操作的额度 */
    private long amount;

    /** 操作前的数量 */
    private long beforeAmount;

    /** 操作后的数量 */
    private long afterAmount;

    /** 操作，1-减，2-加 */
    private short oper;

    /** 状态：1-try，2-confirm，3-cancel */
    private short status;

    /** 操作来源 */
    private short source;

    /** 订单id */
    private long orderId;

    /** 创建时间 */
    private int createTime;

    /** 更新时间 */
    private int updateTime;

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public long getLogId() {
        return logId;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return uid;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setBeforeAmount(long beforeAmount) {
        this.beforeAmount = beforeAmount;
    }

    public long getBeforeAmount() {
        return beforeAmount;
    }

    public void setAfterAmount(long afterAmount) {
        this.afterAmount = afterAmount;
    }

    public long getAfterAmount() {
        return afterAmount;
    }

    public void setOper(short oper) {
        this.oper = oper;
    }

    public short getOper() {
        return oper;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public short getStatus() {
        return status;
    }

    public void setSource(short source) {
        this.source = source;
    }

    public short getSource() {
        return source;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
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
