package io.seata.samples.integration.storage.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import io.seata.samples.integration.storage.entity.GoodPO;

/**
 * t_good 表的操作接口
 * 
 * @author xiaoheng 2019-11-28
 */
public interface GoodDao {

    /**
     * 保存数据
     * 
     * @param po 要保存的对象
     */
    void insert(GoodPO po);


    /**
     * 修改数据，以主键更新
     * 
     * @param po - 要更新的数据
     * @return 更新的行数
     */
    int update(GoodPO po);

    /**
     * 根据主键读取记录
     */
    GoodPO get(@Param("id") long id);
}
