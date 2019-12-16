package io.seata.samples.integration.account.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import io.seata.samples.integration.account.entity.WalletLogPO;

/**
 * t_wallet_log 表的操作接口
 * 
 * @author xiaoheng 2019-11-28
 */
public interface WalletLogDao {

    /**
     * 保存数据
     * 
     * @param po 要保存的对象
     */
    void insert(WalletLogPO po);


    /**
     * 修改数据，以主键更新
     * 
     * @param po - 要更新的数据
     * @return 更新的行数
     */
    int update(WalletLogPO po);

    /**
     * 根据主键读取记录
     */
    WalletLogPO get(@Param("logId") long logId);


    WalletLogPO getBySourceAndOrderId(@Param("source")short source, @Param("orderId")long orderId);

    int updateByStatus(@Param("logId") long logId, @Param("status")short status, @Param("oldStatus")short oldStatus);
}
