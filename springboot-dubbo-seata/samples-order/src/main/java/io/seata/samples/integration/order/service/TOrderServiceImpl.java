package io.seata.samples.integration.order.service;

import java.util.UUID;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.dubbo.AccountDubboService;
import io.seata.samples.integration.common.enums.RspStatusEnum;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.order.entity.TOrder;
import io.seata.samples.integration.order.mapper.TOrderMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private AccountDubboService accountDubboService;

    @Autowired
    private ITAccountService itAccountService;

    private boolean flag;

    /**
     * 创建订单
     * @Param:  OrderDTO  订单对象
     * @Return:  OrderDTO  订单对象
     */
    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        ObjectResponse<OrderDTO> response = new ObjectResponse<>();

        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(orderDTO,tOrder);
        tOrder.setCount(orderDTO.getOrderCount());
        tOrder.setAmount(orderDTO.getOrderAmount().doubleValue());
        try {
            baseMapper.createOrder(tOrder);
        } catch (Exception e) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        ObjectResponse objectResponse = accountDubboService.decreaseAccount(accountDTO);

        if (objectResponse.getStatus() != 200) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.SUCCESS.getCode());
        response.setMessage(RspStatusEnum.SUCCESS.getMessage());
        return response;
    }

    /**
     * 创建订单 单机事务
     * @param orderDTO
     * @return
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ObjectResponse<OrderDTO> createOrder2(OrderDTO orderDTO) {
        ObjectResponse<OrderDTO> response = new ObjectResponse<>();

        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        //生成订单
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(orderDTO,tOrder);
        tOrder.setCount(orderDTO.getOrderCount());
        tOrder.setAmount(orderDTO.getOrderAmount().doubleValue());
        baseMapper.createOrder(tOrder);

        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        ObjectResponse objectResponse = itAccountService.decreaseAccount(accountDTO);

        if (objectResponse.getStatus() != 200) {
            response.setStatus(RspStatusEnum.FAIL.getCode());
            response.setMessage(RspStatusEnum.FAIL.getMessage());
            return response;
        }

        //打开注释测试事务发生异常后，全局回滚功能
        if (orderDTO.isFlag()) {
            logger.info("准备触发异常");
            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        }

        response.setStatus(RspStatusEnum.SUCCESS.getCode());
        response.setMessage(RspStatusEnum.SUCCESS.getMessage());
        return response;
    }
}
