package io.seata.samples.integration.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/14 17:26
 */
@Data
public class BuyReq implements Serializable {

    private long uid;

    private long goodId;

    private long price;

    private int num;

    private boolean isFlag;
}
