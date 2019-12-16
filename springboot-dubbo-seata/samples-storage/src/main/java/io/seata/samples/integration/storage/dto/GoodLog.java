package io.seata.samples.integration.storage.dto;

import java.io.Serializable;
import java.math.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品库存日志表
 * 
 */
public class GoodLog implements Serializable {

    private static final long serialVersionUID = -3074457346719512716L;

    /** 库存日志表 */
    private long logId;

    /** 商品id */
    private long goodId;

    /** 操作的数量 */
    private long number;

    /** 操作前的数量 */
    private long beforeNumber;

    /** 操作后的数量 */
    private long afterNumber;

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

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    public long getGoodId() {
        return goodId;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setBeforeNumber(long beforeNumber) {
        this.beforeNumber = beforeNumber;
    }

    public long getBeforeNumber() {
        return beforeNumber;
    }

    public void setAfterNumber(long afterNumber) {
        this.afterNumber = afterNumber;
    }

    public long getAfterNumber() {
        return afterNumber;
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

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
