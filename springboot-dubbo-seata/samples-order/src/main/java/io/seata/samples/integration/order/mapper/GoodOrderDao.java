package io.seata.samples.integration.order.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import io.seata.samples.integration.order.entity.GoodOrderPO;

/**
 * t_good_order 表的操作接口
 * 
 * @author xiaoheng 2019-11-28
 */
public interface GoodOrderDao {

    /**
     * 保存数据
     * 
     * @param po 要保存的对象
     */
    void insert(GoodOrderPO po);


    /**
     * 修改数据，以主键更新
     * 
     * @param po - 要更新的数据
     * @return 更新的行数
     */
    int update(GoodOrderPO po);

    /**
     * 根据主键读取记录
     */
    GoodOrderPO get(@Param("orderId") long orderId);

    int updateStatus(@Param("orderId") long orderId, @Param("status") short status, @Param("oldStatus") short oldStatus);
}
