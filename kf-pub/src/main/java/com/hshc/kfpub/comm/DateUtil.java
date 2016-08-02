/**
 * 日期型工具类文件
 *
 * @title: DateUtil.java
 * @author 邢治理
 * @date 2016年2月24日 下午3:10:52
 */
package com.hshc.kfpub.comm;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期型工具类文件
 * 
 * @className DateUtil
 * @author 邢治理
 * @version V1.0 2016年2月24日 下午3:10:52
 * @since 2016年2月24日 下午3:10:52
 */
public final class DateUtil {

    // 默认日期时间格式
    private final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间对象
     * 
     * @return
     * @author 邢治理
     * @since 2016年3月7日
     */
    public Date getCurrDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取当前日期时间字符串，格式：yyyy-MM-dd HH:mm:ss
     * 
     * @return
     * @author 邢治理
     * @since 2016年3月7日
     */
    public String getCurrDateTimeStr() {
        return getCurrDateTimeStr(null);
    }

    /**
     * 获取当前日期时间，返回指定格式的字符串
     * 如果formatStr为""或null，则以默认格式返回
     * 
     * @param formatStr 格式化字符串
     * @return
     * @author 邢治理
     * @since 2016年3月7日
     */
    public String getCurrDateTimeStr(String formatStr) {
        return this.format(getCurrDate(), formatStr);
    }

    /**
     * 转换日期格式化字符串
     * 
     * @param oldStr 原日期串
     * @param oldFormat 原日期格式
     * @param newFormat 新日期格式
     * @return 新日期串
     * @author 邢治理
     * @since 2016年3月11日
     */
    public String convertDateStr(String oldStr, String oldFormat, String newFormat) {
        Date date = this.parseDate(oldStr, oldFormat);
        String newStr = this.format(date, newFormat);
        return newStr;
    }

    /**
     * 将日期串解析为日期对象
     * 
     * @param dateStr 日期串
     * @param format 日期格式, 为空时取默认日期时间格式:YYYYMMDDHHMMSS
     * @return 日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date parseDate(String dateStr, String format) {
        if (U.STR.isEmpty(format)) {
            format = YYYYMMDDHHMMSS;
        }
        try {
            Date date = DateUtils.parseDate(dateStr, format);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期串解析为日期对象,使用默认日期时间格式:YYYYMMDDHHMMSS
     * 
     * @param dateStr 日期串
     * @return 日期
     * @throws Exception
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date parseDate(String dateStr) throws Exception {

        Date date = DateUtils.parseDate(dateStr, YYYYMMDDHHMMSS);
        return date;
    }

    /**
     * 将日期对象转换为日期字符串
     * 
     * @param date 日期
     * @param format 日期格式, 为空时取默认日期时间格式:YYYYMMDDHHMMSS
     * @return 日期
     * @throws Exception
     * @author 邢治理
     * @since 2016年3月11日
     */
    public String format(Date date, String format) {
        if (U.STR.isEmpty(format)) {
            format = YYYYMMDDHHMMSS;
        }
        return DateFormatUtils.format(date, format);
    }

    /**
     * 将日期对象转换为日期字符串,使用默认日期时间格式:YYYYMMDDHHMMSS
     * 
     * @param date 日期
     * @return 日期
     * @throws Exception
     * @author 邢治理
     * @since 2016年3月11日
     */
    public String format(Date date) {
        return DateFormatUtils.format(date, YYYYMMDDHHMMSS);
    }

    /**
     * 计算两个日期对象之差(天数)=date1-date2 结果可能为负<BR>
     * 计算时不考虑时分秒,即2016-03-11 23:59:59 与 2016-03-12 00:00:00之间的差为1天
     * 
     * @param date1 日期1
     * @param date2 日期2
     * @return 日期之差(天)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long daysBetween(Date date1, Date date2) {
        date1 = this.setHours(date1, 0);
        date1 = this.setMinutes(date1, 0);
        date1 = this.setSeconds(date1, 0);
        date1 = this.setMilliseconds(date1, 0);

        date2 = this.setHours(date2, 0);
        date2 = this.setMinutes(date2, 0);
        date2 = this.setSeconds(date2, 0);
        date2 = this.setMilliseconds(date2, 0);

        return this.millisecondsBetween(date1, date2) / (1000 * 3600 * 24);
    }

    /**
     * 计算两个日期对象之差(天数)=cal1-cal2 结果可能为负<BR>
     * 计算时不考虑时分秒,即2016-03-11 23:59:59 与 2016-03-12 00:00:00之间的差为1天
     * 
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 日期之差(天)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long daysBetween(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("求两个日期之间的差时,日期不能为空!");
        }
        return this.daysBetween(cal1.getTime(), cal2.getTime());
    }

    /**
     * 计算两个日期对象之差(天数)=dateStr1-dateStr2 结果可能为负<BR>
     * 计算时不考虑时分秒,即2016-03-11 23:59:59 与 2016-03-12 00:00:00之间的差为1天
     * 
     * @param dateStr1 日期字符串1
     * @param dateStr2 日期字符串2
     * @param format 日期字符串格式化
     * @return 日期之差(天)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long daysBetween(String dateStr1, String dateStr2, String format) {
        Date date1 = this.parseDate(dateStr1, format);
        Date date2 = this.parseDate(dateStr2, format);
        return this.daysBetween(date1, date2);
    }

    /**
     * 计算两个日期对象之差(天数)=dateStr1-dateStr2 结果可能为负<BR>
     * 计算时不考虑时分秒,即2016-03-11 23:59:59 与 2016-03-12 00:00:00之间的差为1天
     * 
     * @param dateStr1 日期字符串1
     * @param dateStr2 日期字符串2
     * @return 日期之差(天)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long daysBetween(String dateStr1, String dateStr2) {
        return this.daysBetween(dateStr1, dateStr2, null);
    }

    /**
     * 计算两个日期对象之差(秒数)=date1-date2 结果可能为负<BR>
     * 计算时不考虑毫秒数,即2016-03-11 23:59:59 999 与 2016-03-12 00:00:00 000之间的差为1秒
     * 
     * @param date1 日期1
     * @param date2 日期2
     * @return 日期之差(秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long secondsBetween(Date date1, Date date2) {
        date1 = this.setMilliseconds(date1, 0);
        date2 = this.setMilliseconds(date2, 0);
        return this.millisecondsBetween(date1, date2) / 1000;
    }

    /**
     * 计算两个日期对象之差(秒数)=cal1-cal2 结果可能为负<BR>
     * 计算时不考虑毫秒数,即2016-03-11 23:59:59 999 与 2016-03-12 00:00:00 000之间的差为1秒
     * 
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 日期之差(秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long secondsBetween(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("求两个日期之间的差时,日期不能为空!");
        }
        return this.secondsBetween(cal1.getTime(), cal2.getTime());
    }

    /**
     * 计算两个日期对象之差(秒数)=dateStr1-dateStr2 结果可能为负<BR>
     * 计算时不考虑毫秒数,即2016-03-11 23:59:59 999 与 2016-03-12 00:00:00 000之间的差为1秒
     * 
     * @param dateStr1 日期字符串1
     * @param dateStr2 日期字符串2
     * @param format 日期字符串格式化
     * @return 日期之差(秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long secondsBetween(String dateStr1, String dateStr2, String format) {
        Date date1 = this.parseDate(dateStr1, format);
        Date date2 = this.parseDate(dateStr2, format);
        return this.secondsBetween(date1, date2);
    }

    /**
     * 计算两个日期对象之差(秒数)=dateStr1-dateStr2 结果可能为负<BR>
     * 计算时不考虑毫秒数,即2016-03-11 23:59:59 999 与 2016-03-12 00:00:00 000之间的差为1秒
     * 
     * @param dateStr1 日期字符串1
     * @param dateStr2 日期字符串2
     * @return 日期之差(秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long secondsBetween(String dateStr1, String dateStr2) {
        return this.secondsBetween(dateStr1, dateStr2, null);
    }

    /**
     * 计算两个日期对象之差(毫秒数)=date1-date2 结果可能为负<BR>
     * 
     * @param date1 日期1
     * @param date2 日期2
     * @return 日期之差(毫秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long millisecondsBetween(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("求两个日期之间的差时,日期不能为空!");
        }
        return date1.getTime() - date2.getTime();

    }

    /**
     * 计算两个日期对象之差(毫秒数)=cal1-cal2 结果可能为负<BR>
     * 
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 日期之差(毫秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long millisecondsBetween(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("求两个日期之间的差时,日期不能为空!");
        }
        return this.millisecondsBetween(cal1.getTime(), cal2.getTime());
    }

    /**
     * 计算两个日期对象之差(毫秒数)=dateStr1-dateStr2 结果可能为负<BR>
     * 
     * @param dateStr1 日期字符串1
     * @param dateStr2 日期字符串2
     * @param format 日期字符串格式化
     * @return 日期之差(毫秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long millisecondsBetween(String dateStr1, String dateStr2, String format) {
        Date date1 = this.parseDate(dateStr1, format);
        Date date2 = this.parseDate(dateStr2, format);
        return this.millisecondsBetween(date1, date2);
    }

    /**
     * 计算两个日期对象之差(毫秒数)=dateStr1-dateStr2 结果可能为负<BR>
     * 
     * @param dateStr1 日期字符串1
     * @param dateStr2 日期字符串2
     * @return 日期之差(毫秒)
     * @author 邢治理
     * @since 2016年3月11日
     */
    public long millisecondsBetween(String dateStr1, String dateStr2) {
        return this.millisecondsBetween(dateStr1, dateStr2, null);
    }

    /**
     * 计算两个日期对象是否是同一天<BR>
     * 
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 日期对象是否是同一天
     * @author 邢治理
     * @since 2016年3月11日
     */
    public boolean isSameDay(Calendar cal1, Calendar cal2) {
        return DateUtils.isSameDay(cal1, cal2);
    }

    /**
     * 计算两个日期对象是否是同一天<BR>
     * 
     * @param date1 日期1
     * @param date2 日期2
     * @return 日期对象是否是同一天
     * @author 邢治理
     * @since 2016年3月11日
     */
    public boolean isSameDay(Date date1, Date date2) {
        return DateUtils.isSameDay(date1, date2);
    }

    /**
     * 计算两个日期对象是否是同一时刻,即毫秒级相等<BR>
     * 
     * @param date1 日期1
     * @param date2 日期2
     * @return 日期对象是否是同一天
     * @author 邢治理
     * @since 2016年3月11日
     */
    public static boolean isSameInstant(Date date1, Date date2) {
        return DateUtils.isSameInstant(date1, date2);
    }

    /**
     * 计算两个日期对象是否是同一时刻,即毫秒级相等<BR>
     * 
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 日期对象是否是同一天
     * @author 邢治理
     * @since 2016年3月11日
     */
    public static boolean isSameInstant(Calendar cal1, Calendar cal2) {
        return DateUtils.isSameInstant(cal1, cal2);
    }

    /**
     * 返回日期date的amount年后的日期
     * 
     * @param date 日期
     * @param amount 年数
     * @return amount年后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addYears(Date date, int amount) {
        return DateUtils.addYears(date, amount);
    }

    /**
     * 返回日期date的amount月后的日期
     * 
     * @param date 日期
     * @param amount 月数
     * @return amount月后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addMonths(Date date, int amount) {
        return DateUtils.addMonths(date, amount);
    }

    /**
     * 返回日期date的amount周后的日期
     * 
     * @param date 日期
     * @param amount 周数
     * @return amount周后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addWeeks(Date date, int amount) {
        return DateUtils.addWeeks(date, amount);
    }

    /**
     * 返回日期date的amount天后的日期
     * 
     * @param date 日期
     * @param amount 天数
     * @return amount天后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addDays(Date date, int amount) {
        return DateUtils.addDays(date, amount);
    }

    /**
     * 返回日期date的amount小时后的日期
     * 
     * @param date 日期
     * @param amount 小时数
     * @return amount小时后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addHours(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    /**
     * 返回日期date的amount分钟后的日期
     * 
     * @param date 日期
     * @param amount 分钟数
     * @return amount分钟后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addMinutes(Date date, int amount) {
        return DateUtils.addMinutes(date, amount);
    }

    /**
     * 返回日期date的amount秒后的日期
     * 
     * @param date 日期
     * @param amount 秒数
     * @return amount秒后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addSeconds(Date date, int amount) {
        return DateUtils.addSeconds(date, amount);
    }

    /**
     * 返回日期date的amount毫秒后的日期
     * 
     * @param date 日期
     * @param amount 毫秒数
     * @return amount毫秒后的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date addMilliseconds(Date date, int amount) {
        return DateUtils.addMilliseconds(date, amount);
    }

    /**
     * 设置日期date的年份为amount
     * 
     * @param date 日期
     * @param amount 年数
     * @return 新日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date setYears(Date date, int amount) {
        return DateUtils.setYears(date, amount);
    }

    /**
     * 设置日期date的月份为amount
     * 
     * @param date 日期
     * @param amount 月数
     * @return 新日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date setMonths(Date date, int amount) {
        return DateUtils.setMonths(date, amount);
    }

    /**
     * 设置日期date的当前月份天数为amount
     * 
     * @param date 日期
     * @param amount 天数
     * @return 新日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date setDays(Date date, int amount) {
        return DateUtils.setDays(date, amount);
    }

    /**
     * 设置日期date的小时数为amount
     * 
     * @param date 日期
     * @param amount 小时数
     * @return 新日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date setHours(Date date, int amount) {
        return DateUtils.setHours(date, amount);
    }

    /**
     * 设置日期date的分钟数为amount
     * 
     * @param date 日期
     * @param amount 分钟数
     * @return 新日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date setMinutes(Date date, int amount) {
        return DateUtils.setMinutes(date, amount);
    }

    /**
     * 设置日期date的秒数为amount
     * 
     * @param date 日期
     * @param amount 秒数
     * @return 新日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date setSeconds(Date date, int amount) {
        return DateUtils.setSeconds(date, amount);
    }

    /**
     * 设置日期date的毫秒数为amount
     * 
     * @param date 日期
     * @param amount 毫秒数
     * @return 新日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date setMilliseconds(Date date, int amount) {
        return DateUtils.setMilliseconds(date, amount);
    }

    /**
     * 返回两个日期间的较大的日期
     * 
     * @param date1 日期
     * @param date2 日期
     * @return 较大的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date max(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("日期作比较时不能为空!");
        }

        if (date1.getTime() > date2.getTime()) {
            return date1;
        } else {
            return date2;
        }

    }

    /**
     * 返回两个日期间的较小的日期
     * 
     * @param date1 日期
     * @param date2 日期
     * @return 较小的日期
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Date min(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("日期作比较时不能为空!");
        }

        if (date1.getTime() < date2.getTime()) {
            return date1;
        } else {
            return date2;
        }

    }
}
