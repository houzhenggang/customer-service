/**
 * 数值型工具类文件
 *
 * @title: FileUtil.java
 * @author 邢治理
 * @date 2016年2月24日 下午3:10:52
 */
package com.hshc.kfpub.comm;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 数值型工具类
 * 
 * @className NumberUtil
 * @author 邢治理
 * @version V1.0 2016年2月24日 下午3:10:52
 * @since 2016年2月24日 下午3:10:52
 */
public final class NumberUtil {

    /**
     * 字符串转int类型
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return int
     * 
     */
    public int toInt(String str) {
        return NumberUtils.toInt(str);
    }

    /**
     * 字符串转int类型.注:如果str=null,则使用默认值,否则使用str的值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @param defaultValue
     * @return int
     */
    public int toInt(String str, int defaultValue) {
        return NumberUtils.toInt(str, defaultValue);
    }

    /**
     * 字符串转long类型
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return long
     */
    public long toLong(String str) {
        return NumberUtils.toLong(str);
    }

    /**
     * 字符串转long类型.注:如果str=null,则使用默认值,否则使用str的值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @param defaultValue
     * @return long
     */
    public long toLong(String str, long defaultValue) {
        return NumberUtils.toLong(str, defaultValue);
    }

    /**
     * 字符串转float类型
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return float
     */
    public float toFloat(String str) {
        return NumberUtils.toFloat(str);
    }

    /**
     * 字符串转float类型.注:如果str=null,则使用默认值,否则使用str的值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @param defaultValue
     * @return float
     */
    public float toFloat(String str, float defaultValue) {
        return NumberUtils.toFloat(str, defaultValue);
    }

    /**
     * 字符串转double类型
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return double
     */
    public double toDouble(String str) {
        return NumberUtils.toDouble(str);
    }

    /**
     * 字符串转float类型.注:如果str=null,则使用默认值,否则使用str的值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @param defaultValue
     * @return double
     */
    public double toDouble(String str, double defaultValue) {
        return NumberUtils.toDouble(str, defaultValue);
    }

    /**
     * 字符串转byte类型
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return byte
     */
    public byte toByte(String str) {
        return NumberUtils.toByte(str);
    }

    /**
     * 字符串转byte类型.注:如果str=null,则使用默认值,否则使用str的值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @param defaultValue
     * @return byte
     */
    public byte toByte(String str, byte defaultValue) {
        return NumberUtils.toByte(str, defaultValue);
    }

    /**
     * 字符串转short类型
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return short
     */
    public short toShort(String str) {
        return NumberUtils.toShort(str);
    }

    /**
     * 字符串转byte类型.注:如果str=null,则使用默认值,否则使用str的值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @param defaultValue
     * @return short
     */
    public short toShort(String str, short defaultValue) {
        return NumberUtils.toShort(str, defaultValue);
    }

    /**
     * 通过字符串创建Number类型的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return Number
     */
    public Number createNumber(String str) {
        return NumberUtils.createNumber(str);
    }

    /**
     * 用字符串构造一个Float类型数据,如果str=null,返回null,否则返回Float类型数据
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return Float
     */
    public Float createFloat(String str) {
        return NumberUtils.createFloat(str);
    }

    /**
     * 用字符串构造一个Double类型数据,如果str=null,返回null,否则返回Double类型数据
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return Double
     */
    public Double createDouble(String str) {
        return NumberUtils.createDouble(str);
    }

    /**
     * 用字符串构造一个Integer类型数据,如果str=null,返回null,否则返回Integer类型数据
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return Integer
     */
    public Integer createInteger(String str) {
        return NumberUtils.createInteger(str);
    }

    /**
     * 用字符串构造一个Long类型数据,如果str=null,返回null,否则返回Long类型数据
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return Long
     */
    public Long createLong(String str) {
        return NumberUtils.createLong(str);
    }

    /**
     * 用字符串构造一个BigInteger类型数据,如果str=null,返回null,否则返回BigInteger类型数据
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return BigInteger
     */
    public BigInteger createBigInteger(String str) {
        return NumberUtils.createBigInteger(str);
    }

    /**
     * 用字符串构造一个BigDecimal类型数据,如果str=null,返回null,否则返回BigDecimal类型数据
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return BigDecimal
     */
    public BigDecimal createBigDecimal(String str) {
        return NumberUtils.createBigDecimal(str);
    }

    /**
     * 找出long数组中最小的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return long
     */
    public long min(long[] array) {
        return NumberUtils.min(array);
    }

    /**
     * 找出int数组中最小的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return int
     */
    public int min(int[] array) {
        return NumberUtils.min(array);
    }

    /**
     * 找出short数组中最小的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return short
     */
    public short min(short[] array) {
        return NumberUtils.min(array);
    }

    /**
     * 找出byte数组中最小的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return byte
     */
    public byte min(byte[] array) {
        return NumberUtils.min(array);
    }

    /**
     * 找出double数组中最小的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return double
     */
    public double min(double[] array) {
        return NumberUtils.min(array);
    }

    /**
     * 找出float数组中最小的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return float
     */
    public float min(float[] array) {
        return NumberUtils.min(array);
    }

    /**
     * 找出long数组中最大的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return long
     */
    public long max(long[] array) {
        return NumberUtils.max(array);
    }

    /**
     * 找出int数组中最大的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return int
     */
    public int max(int[] array) {
        return NumberUtils.max(array);
    }

    /**
     * 找出short数组中最大的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return short
     */
    public short max(short[] array) {
        return NumberUtils.max(array);
    }

    /**
     * 找出byte数组中最大的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return byte
     */
    public byte max(byte[] array) {
        return NumberUtils.max(array);
    }

    /**
     * 找出double数组中最大的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return double
     */
    public double max(double[] array) {
        return NumberUtils.max(array);
    }

    /**
     * 找出float数组中最大的一个数值返回
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param array
     * @return float
     */
    public float max(float[] array) {
        return NumberUtils.max(array);
    }

    /**
     * 三个long类型的数据比较大小,返回最小的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return long
     */
    public long min(long a, long b, long c) {
        return NumberUtils.min(a, b, c);
    }

    /**
     * 三个int类型的数据比较大小,返回最小的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return int
     */
    public int min(int a, int b, int c) {
        return NumberUtils.min(a, b, c);
    }

    /**
     * 三个short类型的数据比较大小,返回最小的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return short
     */
    public short min(short a, short b, short c) {
        return NumberUtils.min(a, b, c);
    }

    /**
     * 三个byte类型的数据比较大小,返回最小的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return byte
     */
    public byte min(byte a, byte b, byte c) {
        return NumberUtils.min(a, b, c);
    }

    /**
     * 三个double类型的数据比较大小,返回最小的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return double
     */
    public double min(double a, double b, double c) {
        return NumberUtils.min(a, b, c);
    }

    /**
     * 三个float类型的数据比较大小,返回最小的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return float
     */
    public float min(float a, float b, float c) {
        return NumberUtils.min(a, b, c);
    }

    /**
     * 三个long类型的数据比较大小,返回最大的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return long
     */
    public long max(long a, long b, long c) {
        return NumberUtils.max(a, b, c);
    }

    /**
     * 三个int类型的数据比较大小,返回最大的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return int
     */
    public int max(int a, int b, int c) {
        return NumberUtils.max(a, b, c);
    }

    /**
     * 三个short类型的数据比较大小,返回最大的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return short
     */
    public short max(short a, short b, short c) {
        return NumberUtils.max(a, b, c);
    }

    /**
     * 三个byte类型的数据比较大小,返回最大的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return byte
     */
    public byte max(byte a, byte b, byte c) {
        return NumberUtils.max(a, b, c);
    }

    /**
     * 三个double类型的数据比较大小,返回最大的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return double
     */
    public double max(double a, double b, double c) {
        return NumberUtils.max(a, b, c);
    }

    /**
     * 三个float类型的数据比较大小,返回最大的数值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param a
     * @param b
     * @param c
     * @return float
     */
    public float max(float a, float b, float c) {
        return NumberUtils.max(a, b, c);
    }

    /**
     * 判断字符串中是否全为数字
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return boolean
     */
    public boolean isDigits(String str) {
        return NumberUtils.isDigits(str);
    }

    /**
     * 判断字符串是否是数字
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return boolean
     */
    public boolean isNumber(String str) {
        return NumberUtils.isNumber(str);
    }

    /**
     * 判断字符串是否是合法数字 注:如果str=123.,则返回false,否则返回true
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param str
     * @return boolean
     */
    public boolean isParsable(String str) {
        return NumberUtils.isParsable(str);
    }

    /**
     * 两个int类型比较大小,如果x等于y,返回0;如果x小于y,返回-1;如果x大于y,返回1
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param x
     * @param y
     * @return int
     */
    public int compare(int x, int y) {
        return NumberUtils.compare(x, y);
    }

    /**
     * 两个long类型比较大小,如果x等于y,返回0;如果x小于y,返回-1;如果x大于y,返回1
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param x
     * @param y
     * @return int
     */
    public int compare(long x, long y) {
        return NumberUtils.compare(x, y);
    }

    /**
     * 两个short类型比较大小,如果x等于y,返回0;如果x小于y,返回-1;如果x大于y,返回1
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param x
     * @param y
     * @return int
     */
    public int compare(short x, short y) {
        return NumberUtils.compare(x, y);
    }

    /**
     * 两个int类型比较大小,如果x等于y,返回0;如果x小于y,返回负值;如果x大于y,返回正值
     * 
     * @author 邢治理
     * @version V1.0 2016年2月24日 下午3:10:52
     * @since 2016年2月24日 下午3:10:52
     * @param x
     * @param y
     * @return int
     */
    public int compare(byte x, byte y) {
        return NumberUtils.compare(x, y);
    }
}
