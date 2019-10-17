package io.seata.samples.integration.call.service;

import java.math.BigDecimal;

import io.seata.samples.integration.common.dto.BusinessDTO;
import io.seata.samples.integration.common.response.ObjectResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-09-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessServiceTest {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private CountService countService;

    @Test
    public void singleTest() {
        for(int i = 1; i <= 10000; i++) {
            long start = System.currentTimeMillis();
            try {
//                        Thread.sleep(i);
                BusinessDTO businessDTO = new BusinessDTO();
                businessDTO.setUserId("" + (i));
                businessDTO.setCommodityCode("C20" + i);
                businessDTO.setName("商品" + i);
                businessDTO.setCount(1);
                businessDTO.setAmount(new BigDecimal("1"));
                ObjectResponse objectResponse = businessService.handleBusiness(businessDTO);
                countService.success(System.currentTimeMillis() - start);
            } catch (Exception e) {
                countService.failure(System.currentTimeMillis() - start);
                e.printStackTrace();
            }
        }

        System.out.println(countService.toString());
    }

    @Test
    public void Multitest() {
        for(int j = 1; j <= 10; j++) {
            IntStream.rangeClosed(1, 1)
                    .parallel()
                    .forEach(i -> {
                        long start = System.currentTimeMillis();
                        try {
//                        Thread.sleep(i);
                            BusinessDTO businessDTO = new BusinessDTO();
                            businessDTO.setUserId("" + (i));
                            businessDTO.setCommodityCode("C20" + i);
                            businessDTO.setName("商品" + i);
                            businessDTO.setCount(1);
                            businessDTO.setAmount(new BigDecimal("1"));
                            ObjectResponse objectResponse = businessService.handleBusiness(businessDTO);
                            countService.success(System.currentTimeMillis() - start);
                        } catch (Exception e) {
                            countService.failure(System.currentTimeMillis() - start);
                            e.printStackTrace();
                        }

                    });
        }


        System.out.println(countService.toString());
    }
}
