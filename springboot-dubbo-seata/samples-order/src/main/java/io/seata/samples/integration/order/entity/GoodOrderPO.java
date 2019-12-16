package io.seata.samples.integration.order.entity;

import java.io.Serializable;


/**
 * 订单表
 * 
 * <pre>
 *     自动生成代码: 表名 t_good_order, 日期: 2019-11-28
 *     order_id <PK>        bigint(20)
 *     uid            bigint(20)
 *     good_id        bigint(20)
 *     number         int(11)
 *     price          bigint(20)
 *     amount         bigint(20)
 *     status         bigint(20)
 *     remark         varchar(100)
 *     create_time    int(11)
 *     update_time    int(11)
 * </pre>
 */
public class GoodOrderPO implements Serializable {

    private static final long serialVersionUID = -3074457344666696273L;

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
    private short status;

    /** 备注 */
    private String remark;

    /** 创建时间 */
    private int createTime;

    /** 更新时间 */
    private int updateTime;

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

    public void setStatus(short status) {
        this.status = status;
    }

    public short getStatus() {
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

}
