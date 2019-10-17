package io.seata.samples.integration.storage.mapper;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.seata.samples.integration.storage.entity.TStorage;
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
public class TStorageMapperTest extends ServiceImpl<TStorageMapper, TStorage> {

    @Test
    public void test() {
        for(int i = 2; i <= 10000; i++) {
            TStorage tStorage = new TStorage();
            tStorage.setId(i);
            tStorage.setCommodityCode("C20" + i);
            tStorage.setName("商品"+i);
            tStorage.setCount(100);

            baseMapper.insertOne(tStorage);
        }
    }
}
