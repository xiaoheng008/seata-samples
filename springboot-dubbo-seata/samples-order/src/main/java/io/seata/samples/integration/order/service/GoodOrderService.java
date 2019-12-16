package io.seata.samples.integration.order.service;

import io.seata.samples.integration.common.enums.TccStatus;
import io.seata.samples.integration.common.exception.ServiceException;
import io.seata.samples.integration.common.utils.ParameterUtil;
import io.seata.samples.integration.common.utils.TimeUtil;
import io.seata.samples.integration.order.entity.GoodOrderPO;
import io.seata.samples.integration.order.mapper.GoodOrderDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-28
 */
@Service
@Slf4j
public class GoodOrderService {

    @Autowired
    private GoodOrderDao goodOrderDao;

    public GoodOrderPO createOrder(long uid, long goodId, int number, long price) {
        GoodOrderPO goodOrderPO = new GoodOrderPO();
        goodOrderPO.setUid(uid);
        goodOrderPO.setGoodId(goodId);
        goodOrderPO.setNumber(number);
        goodOrderPO.setPrice(price);
        goodOrderPO.setAmount(price * number);
        goodOrderPO.setRemark("");
        goodOrderPO.setStatus(TccStatus.TRY.getStatus());
        goodOrderPO.setCreateTime(TimeUtil.getCurrTime());
        goodOrderPO.setUpdateTime(TimeUtil.getCurrTime());

        goodOrderDao.insert(goodOrderPO);

        return goodOrderPO;
    }

    public GoodOrderPO getOrder(long orderId) {
        GoodOrderPO goodOrderPO = goodOrderDao.get(orderId);
        return goodOrderPO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(long orderId, TccStatus status, TccStatus oldStatus) {
        log.info("update-------------, orderId: {}, status: {}, oldStatus: {}", orderId, status.getStatus(), oldStatus.getStatus());

        int i = goodOrderDao.updateStatus(orderId, status.getStatus(), oldStatus.getStatus());
        if(i != 1) {
            log.info("update order error: orderId: {}, status: {}, oldStatus: {}", orderId, status, oldStatus);
            throw new ServiceException("update order error");
        }else {
            log.info("update success ----------------");
        }
    }
}
