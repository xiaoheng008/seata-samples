package io.seata.samples.integration.account.mapper;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.seata.samples.integration.account.entity.TAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-09-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TAccountMapperTest extends ServiceImpl<TAccountMapper, TAccount> {

    @Test
    public void addTest() {
        for(int i = 1; i<= 10000; i++) {
            TAccount tAccount = new TAccount();
            tAccount.setUserId("" + i);
            tAccount.setAmount(100.0D);

            baseMapper.insertOne(tAccount);
        }

    }
}
