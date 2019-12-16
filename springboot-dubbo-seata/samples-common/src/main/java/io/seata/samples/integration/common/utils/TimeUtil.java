package io.seata.samples.integration.common.utils;

import io.seata.samples.integration.common.consts.GlobalConstants;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by liangziyan on 2018/2/5.
 */
public class TimeUtil {

    public static final int SECOND_IN_DAY = 60 * 60 * 24;

    public static final int SECOND_IN_HOUR = 60 * 60;


    /**
     * 获取明天0点时间
     *
     * @return
     */
    public static long getTomorrowTime() {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取昨天0点的时间戳
     *
     * @param time
     * @return
     */
    public static int getLastDayTime(int time) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(time * 1000L));
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return (int) (calendar.getTimeInMillis() / 1000L);
    }

    /**
     * 获取今天0点的时间戳
     *
     * @param time
     * @return
     */
    public static int getTodayTime(int time) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(time * 1000L));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return (int) (calendar.getTimeInMillis() / 1000L);
    }

    /**
     * 获取今天0点的时间戳
     *
     * @param time
     * @return
     */
    public static int getTodayTime(int time, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(time * 1000L));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return (int) (calendar.getTimeInMillis() / 1000L);
    }

    /**
     * 获取今天0点时间
     *
     * @return
     */
    public static long getTodayTime() {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis() / 1000 * 1000;
    }

    /**
     * 获取离今天distance天的距离
     *
     * @return
     */
    public static long getDate(Date date, int distance) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        if (date == null) {
            calendar.setTime(new Date());
        }
        if (distance != 0) {
            calendar.add(Calendar.DATE, distance);
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return year * 10000 + (month + 1) * 100 + day;
    }

    /**
     * 获取某一天零点的unixtime
     *
     * @return
     */
    public static int getZeroTime(Date date) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        if (date == null) {
            calendar.setTime(new Date());
        } else {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (int) (calendar.getTime().getTime() / 1000L);
    }

    /**
     * 根据时间戳，获取日期
     *
     * @param ms 时间戳，毫秒
     * @return 返回的日期格式如：20190323
     * @author lizhixiong 2019/03/29
     */
    public static int getDate(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return year * 10000 + (month + 1) * 100 + day;
    }

    /**
     * 根据时间戳和时区，获取日期
     *
     * @param ms       时间戳，毫秒
     * @param timeZone 返回的日期格式如：20190323
     * @return
     */
    public static int getDate(long ms, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(ms));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return year * 10000 + (month + 1) * 100 + day;
    }

    /**
     * 根据时间戳，获取周日的时间
     *
     * @param ms 时间戳，毫秒
     * @return 返回的日期格式如：20190325
     */
    public static int getSundayDate(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return year * 10000 + (month + 1) * 100 + day;
    }

    /**
     * 根据时间戳，获取周日的时间
     *
     * @param ms 时间戳，毫秒
     * @return 返回的日期格式如：20190325
     */
    public static int getSundayDate(long ms, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(ms));
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        return year * 10000 + (month + 1) * 100 + day;
    }

    /**
     * 根据时间获取周一的0点时间戳
     *
     * @param s 时间戳，秒
     * @return 返回周一0点的时间戳，秒
     */
    public static int getMondayTime(int s) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date((long) s * 1000L));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        return (int) (calendar.getTime().getTime() / 1000);
    }

    /**
     * 根据时间戳，获取月份
     *
     * @param ms 时间戳，毫秒
     * @return 返回的日期格式如：201903
     * @author lizhixiong 2019/03/29
     */
    public static int getMonthDate(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year * 100 + (month + 1);
    }

    /**
     * 根据时间戳和时区获取月份
     *
     * @param ms
     * @param timeZone
     * @return
     */
    public static int getMonthDate(long ms, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(ms));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year * 100 + (month + 1);
    }

    /**
     * 根据时间戳，获取上个月份
     *
     * @param ms 时间戳，毫秒
     * @return 返回的日期格式如：201903
     * @author lizhixiong 2019/03/29
     */
    public static int getLastMonthDate(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        calendar.add(Calendar.MONTH, -1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year * 100 + (month + 1);
    }

    public static int getLastMonthDate(long ms, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(ms));
        calendar.add(Calendar.MONTH, -1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year * 100 + (month + 1);
    }

    /**
     * 根据时间获取下周一的0点时间戳
     *
     * @param ms 时间戳，毫秒
     * @return 返回下周一0点的时间戳，毫秒
     */
    public static long getNextMondayTime(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        calendar.add(Calendar.DATE, 7);
        return calendar.getTime().getTime();
    }

    /**
     * 获取下个月1号0点的时间
     *
     * @param ms 时间戳，毫秒
     * @return 返回下个月1号0点的时间戳，毫秒
     */
    public static long getNextMonthTime(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 根据时间戳上周一0点的时间
     *
     * @param ms 时间戳，毫秒
     * @return 上周一0点时间戳，秒
     */
    public static int getLastMonday(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        calendar.add(Calendar.DATE, -7);
        return (int) (calendar.getTime().getTime() / 1000L);
    }

    /**
     * 获取当前时间戳，秒
     *
     * @return
     */
    public static int getCurrTime() {
        return (int) (System.currentTimeMillis() / 1000L);
    }

    /**
     * 获取 明天的0点时间
     *
     * @param ms
     * @return 返回毫秒
     */
    public static long getNextDayTime(long ms) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(ms));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime().getTime();
    }

    /**
     * 获取当前时间所在周的开始日期
     *
     * @param timestamp
     * @return
     */
    public static int getFirstDayOfWeek(int timestamp) {
        Calendar c = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTimeInMillis(timestamp * 1000L);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return (int) (c.getTimeInMillis() / 1000);
    }


    /**
     * 获取当前时间下一周的开始时间
     *
     * @param timestamp
     * @return
     */
    public static int getFirstDayOfNextWeek(int timestamp) {
        Calendar c = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTimeInMillis(timestamp * 1000L);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        c.add(Calendar.DAY_OF_YEAR, 7);
        return (int) (c.getTimeInMillis() / 1000);
    }

    /**
     * 根据时间戳获取明天零点的时间戳
     *
     * @param timestamp
     * @return
     */
    public static int getNextStartTime(int timestamp) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(timestamp * 1000L));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, 1);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    /**
     * 获取当前月份，格式201801
     *
     * @param calendar
     * @return
     */
    public static long getCurrentMonth(Calendar calendar) {
        if (calendar == null) {
            calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        }
        return calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取月份
     *
     * @param calendar
     * @param distance
     * @return
     */
    public static long getMonth(Calendar calendar, int distance) {
        if (calendar == null) {
            calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        }
        calendar.add(Calendar.MONTH, distance);
        long month = calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.MONTH) + 1;
        calendar.add(Calendar.MONTH, -distance);
        return month;
    }

    /**
     * 获取当天日期，格式20190101
     *
     * @param calendar
     * @return
     */
    public static long getCurrentDay(Calendar calendar) {
        if (calendar == null) {
            calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        }
        return calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.DATE);
    }

    /**
     * 获取日期
     *
     * @param calendar
     * @param distance
     * @return
     */
    public static long getDay(Calendar calendar, int distance) {
        if (calendar == null) {
            calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        }
        calendar.add(Calendar.DATE, distance);
        long day = calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE, -distance);
        return day;
    }

    /**
     * 获取这个月1号0点的时间
     *
     * @param timestamp
     * @return 返回这个月1号0点的时间戳，毫秒
     */
    public static int getThisMonthStartTime(int timestamp) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(timestamp * 1000L));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (int) (calendar.getTime().getTime() / 1000);
    }

    /**
     * 获取下个月1号0点的时间
     *
     * @param timestamp
     * @return 返回下个月1号0点的时间戳，毫秒
     */
    public static int getNextMonthStartTime(int timestamp) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(timestamp * 1000L));
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (int) (calendar.getTime().getTime() / 1000);
    }

    /**
     * 获取上个月1号0点的时间
     *
     * @param timestamp
     * @return 返回上个月1号0点的时间戳，毫秒
     */
    public static int getLastMonthStartTime(int timestamp) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(timestamp * 1000L));
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (int) (calendar.getTime().getTime() / 1000);
    }

    /**
     * 获取月1号0点的时间
     *
     * @param timestamp
     * @param interval
     * @return 返回这个月1号0点的时间戳，毫秒
     */
    public static int getMonthStartTime(int timestamp, int interval) {
        Calendar calendar = Calendar.getInstance(GlobalConstants.DEFAULT_TIMEZONE);
        calendar.setTime(new Date(timestamp * 1000L));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + interval);
        return (int) (calendar.getTime().getTime() / 1000);
    }
}
