package io.seata.samples.integration.storage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import io.seata.samples.integration.storage.entity.GoodLogPO;

/**
 * t_good_log 表的操作接口
 * 
 * @author xiaoheng 2019-11-28
 */
public interface GoodLogDao {

    /**
     * 保存数据
     * 
     * @param po 要保存的对象
     */
    void insert(GoodLogPO po);


    /**
     * 修改数据，以主键更新
     * 
     * @param po - 要更新的数据
     * @return 更新的行数
     */
    int update(GoodLogPO po);

    /**
     * 根据主键读取记录
     */
    GoodLogPO get(@Param("logId") long logId);
}
