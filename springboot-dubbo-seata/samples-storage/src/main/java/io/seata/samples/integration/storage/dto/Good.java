package io.seata.samples.integration.storage.dto;

import java.io.Serializable;
import java.math.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品库存表
 * 
 */
public class Good implements Serializable {

    private static final long serialVersionUID = -3074457346604289302L;

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

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
