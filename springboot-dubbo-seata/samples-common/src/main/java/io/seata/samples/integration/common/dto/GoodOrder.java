package io.seata.samples.integration.common.dto;

import java.io.Serializable;
import java.math.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单表
 * 
 */
public class GoodOrder implements Serializable {

    private static final long serialVersionUID = -3074457346184586177L;

    /** 订单id */
    private long orderId;

    /** uid */
    private long uid;

    /** 商品id */
    private long goodId;

    /** 数量 */
    private int number;

    /** 单价 */
    private long price;

    /** 总金额 */
    private long amount;

    /** 状态:1-try 2-confirm 3-cancel */
    private long status;

    /** 备注 */
    private String remark;

    /** 创建时间 */
    private int createTime;

    /** 更新时间 */
    private int updateTime;

    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return uid;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    public long getGoodId() {
        return goodId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getStatus() {
        return status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
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
