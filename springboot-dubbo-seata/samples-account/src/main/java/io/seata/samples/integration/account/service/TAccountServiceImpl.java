package io.seata.samples.integration.account.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.seata.samples.integration.account.entity.TAccount;
import io.seata.samples.integration.account.mapper.TAccountMapper;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.enums.RspStatusEnum;
import io.seata.samples.integration.common.response.ObjectResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

//import io.seata.samples.integration.account.action.TccActionAccount;
//import io.seata.spring.annotation.GlobalLock;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

    private static final Logger logger = LoggerFactory.getLogger(TAccountServiceImpl.class);

    @PostConstruct
    public void init() {
        logger.info("TAccountServiceImpt#decreaseAccount | 扣钱");
    }

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        logger.info("TAccountServiceImpt#decreaseAccount | 扣钱 | account: {}", JSON.toJSONString(accountDTO));
        int account = baseMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (account > 0){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }

    @Override
//    @GlobalLock
    @Transactional(rollbackFor = {Throwable.class})
    public void testGlobalLock() {
        baseMapper.testGlobalLock("1");
        System.out.println("Hi, i got lock, i will do some thing with holding this lock.");
    }
}
