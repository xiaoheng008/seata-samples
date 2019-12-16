package io.seata.samples.integration.account.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import io.seata.samples.integration.account.entity.WalletPO;

/**
 * t_wallet 表的操作接口
 * 
 * @author xiaoheng 2019-11-28
 */
public interface WalletDao {

    /**
     * 保存数据
     * 
     * @param po 要保存的对象
     */
    void insert(WalletPO po);


    /**
     * 修改数据，以主键更新
     * 
     * @param po - 要更新的数据
     * @return 更新的行数
     */
    int update(WalletPO po);

    /**
     * 根据主键读取记录
     */
    WalletPO get(@Param("uid") long uid);

    int sub(@Param("uid")long uid, @Param("amount") long amount);

    int add(@Param("uid")long uid, @Param("amount") long amount);
}
