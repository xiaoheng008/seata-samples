package io.seata.samples.integration.storage.dubbo;

import io.seata.core.context.RootContext;
import io.seata.samples.integration.common.dto.CommodityDTO;
import io.seata.samples.integration.common.dubbo.StorageDubboService;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.storage.service.ITStorageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 16:13
 */
@Service
public class StorageDubboServiceImpl implements StorageDubboService {

    @Autowired
    private ITStorageService storageService;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }
}
