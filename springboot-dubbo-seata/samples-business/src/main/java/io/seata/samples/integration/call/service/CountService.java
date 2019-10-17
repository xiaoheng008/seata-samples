package io.seata.samples.integration.call.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-09-24
 */
@Service
public class CountService {

    private int success = 0;

    private int failure = 0;

    private List<Long> successTimeList = new ArrayList();
    private List<Long> failureTimeList = new ArrayList();

    public synchronized void success(long ms) {
        success+=1;
        successTimeList.add(ms);
    }

    public synchronized  void failure(long ms) {
        failure+=1;
        failureTimeList.add(ms);
    }

    @Override
    public String toString() {
        Collections.sort(successTimeList);
        Collections.sort(failureTimeList);

        long successLeng99 = successTimeList.size() * 99 / 100;
        long failureLeng99 = failureTimeList.size() * 99 / 100;

        long successLeng95 = successTimeList.size() * 95 / 100;
        long failureLeng95 = failureTimeList.size() * 95 / 100;

        OptionalDouble successAvg = successTimeList.stream().mapToLong(Long::longValue).average();
        OptionalDouble failureAvg = failureTimeList.stream().mapToLong(Long::longValue).average();

        List<Long> success99List = successTimeList.subList(0, (int) successLeng99);
        List<Long> failure99List = failureTimeList.subList(0, (int) failureLeng99);

        OptionalDouble success99Avg = success99List.stream().mapToLong(Long::longValue).average();
        OptionalDouble failure99Avg = failure99List.stream().mapToLong(Long::longValue).average();

        List<Long> success95List = successTimeList.subList(0, (int) successLeng95);
        List<Long> failure95List = failureTimeList.subList(0, (int) failureLeng95);

        OptionalDouble success95Avg = success95List.stream().mapToLong(Long::longValue).average();
        OptionalDouble failure95Avg = failure95List.stream().mapToLong(Long::longValue).average();

        return "success: "+ success + ", failure: " + failure +
                "\n" +
                "success: " + JSON.toJSONString(successTimeList) +
                "\n" +
                "failure: " + JSON.toJSONString(failureTimeList) +
                "\n" +
                "success avg : " + successAvg+
                "\n" +
                "failure avg : " + failureAvg +
                "\n" +
                "success99 avg : " + success99Avg+
                "\n" +
                "failure99 avg : " + failure99Avg +
                "\n" +
                "success95 avg : " + success95Avg+
                "\n" +
                "failure96 avg : " + failure95Avg;
    }
}
