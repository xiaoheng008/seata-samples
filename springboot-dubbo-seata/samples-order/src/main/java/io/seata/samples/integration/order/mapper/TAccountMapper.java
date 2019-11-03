package io.seata.samples.integration.order.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.seata.samples.integration.order.entity.TAccount;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface TAccountMapper extends BaseMapper<TAccount> {

    int decreaseAccount(@Param("userId") String userId, @Param("amount") Double amount);

    int testGlobalLock(@Param("userId") String userId);

    int insertOne(TAccount tAccount);
}
