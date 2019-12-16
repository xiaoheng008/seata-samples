package io.seata.samples.integration.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：
 * 详细：
 *
 * @author linyi, 2018/9/13.
 */
public class BeanCopyUtil {

    public static <T> List<T> copy(List<?> list, Class<T> targetClass) {
        if (list == null) {
            return null;
        }

        List<T> result = new ArrayList<>(list.size());
        try {
            for (Object src : list) {
                T target = targetClass.newInstance();
                BeanUtils.copyProperties(src, target);
                result.add(target);
            }
        } catch (Exception e) {
            throw new RuntimeException("转换错误", e);
        }
        return result;
    }

    public static <T> T copy(Object src, Class<T> targetClass) {
        if (src == null) {
            return null;
        }
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(src, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("转换错误", e);
        }
    }
}
