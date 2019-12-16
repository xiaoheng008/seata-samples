package io.seata.samples.integration.storage.entity;

import java.io.Serializable;


/**
 * 商品库存表
 * 
 * <pre>
 *     自动生成代码: 表名 t_good, 日期: 2019-11-28
 *     id <PK>              bigint(20)
 *     name           varchar(20)
 *     price          bigint(20)
 *     number         int(11)
 *     create_time    int(11)
 * </pre>
 */
public class GoodPO implements Serializable {

    private static final long serialVersionUID = -3074457345234424412L;

    /** id */
    private long id;

    /** 商品名称 */
    private String name;

    /** 商品价格 */
    private long price;

    /** 商品数量 */
    private int number;

    /** 创建时间 */
    private int createTime;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getCreateTime() {
        return createTime;
    }

}
