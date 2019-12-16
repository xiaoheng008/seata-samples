package io.seata.samples.integration.account.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletServiceTest {

    @Autowired
    private WalletService walletService;

    @Test
    public void create() {
        for(int i = 0; i < 10000; i++){
            walletService.create(10000 + i, 1000000);
        }

    }
}