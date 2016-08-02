/**
 * 字符型工具类文件
 *
 * @title: FileUtil.java
 * @author 邢治理
 * @date 2016年2月24日 下午3:10:52
 */
package com.hshc.kfpub.comm;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符型工具类，方法出现顺序规则：以方法名字母排序
 * 
 * @className StringUtil
 * @author 邢治理
 * @version V1.0 2016年2月24日 下午3:07:19
 */
public final class StringUtil {

    /**
     * 判断字符串是否为空串或null
     * 
     * @param cs 字符串
     * @return boolean 空则返回true，否则返回false
     */
    public boolean isEmpty(String cs) {
        return StringUtils.isEmpty(cs);
    }

    /**
     * 判断某字符串是否为非空，等于 !isEmpty(String cs)
     * 
     * @param cs 字符串
     * @return boolean 非空则返回true，否则返回false
     */
    public boolean isNotEmpty(String cs) {
        return StringUtils.isNotEmpty(cs);
    }

    /**
     * 判断字符串数组中是否有空串或null
     * 
     * @param css 字符串数组
     * @return boolean 空则返回true，否则返回false
     */
    public boolean isAnyEmpty(String[] css) {
        return StringUtils.isAnyEmpty(css);
    }

    /**
     * 判断字符串数组中是否没有空串或null
     * 
     * @param css 字符串数组
     * @return boolean 没有空返回true，否则返回false
     */
    public boolean isNoneEmpty(String[] css) {
        return StringUtils.isNoneEmpty(css);
    }

    /**
     * 去掉字符串两端的空白
     * 如果参数为null，则返回null
     * 如果参数为""，则返回""
     * 
     * @param str 字符串
     * @return String
     */
    public String trim(String str) {
        return StringUtils.trim(str);
    }

    /**
     * 去掉字符串两端的空白
     * 如果参数为null，返回null
     * 如果参数为""，返回null
     * 
     * @param str 字符串
     * @return
     */
    public String trimToNull(String str) {
        return StringUtils.trimToNull(str);
    }

    /**
     * 去掉字符串两端的空白
     * 如果参数为null，返回""
     * 如果参数为""，返回""
     * 
     * @param str 字符串
     * @return
     */
    public String trimToEmpty(String str) {
        return StringUtils.trimToEmpty(str);
    }

    /**
     * 对字符串数组中的每个字符串进行strip(String str)
     * 如果strs为null或strs长度为0，则返回strs本身
     * 
     * @param strs
     * @return String[]
     */
    public String[] stripAll(String[] strs) {
        return StringUtils.stripAll(strs);
    }

    /**
     * 对字符串数组中的每个字符串进行strip(String str, String stripChars)。
     * 如果strs为null或strs长度为0，则返回strs本身
     * 
     * @param strs
     * @param stripChars
     * @return String[]
     */
    public String[] stripAll(String[] strs, String stripChars) {
        return StringUtils.stripAll(strs, stripChars);
    }

    /**
     * 去掉参数中的一些特殊符号如： 'à' 会被替换为 'a'
     * 
     * @param input
     * @return String
     */
    public static String stripAccents(String input) {
        return StringUtils.stripAccents(input);
    }

    /**
     * 比较两个字符串是否相等
     * 
     * @param cs1
     * @param cs2
     * @return boolean
     */
    public boolean equals(String cs1, String cs2) {
        return StringUtils.equals(cs1, cs2);
    }

    /**
     * 比较两个字符串是否相等，忽略大小写 。
     * 
     * @param str1
     * @param str2
     * @return boolean
     */
    public boolean equalsIgnoreCase(String str1, String str2) {
        return StringUtils.equalsIgnoreCase(str1, str2);
    }

    /**
     * 返回字符的ASCII码searchChar在字符串seq中第一次出现的位置。从seq的0位置开始搜索
     * 如果searchChar没有在seq中出现则返回-1，如果seq为null或""，则也返回-1
     * 
     * @param seq 目标字符串
     * @param searchChar 匹配字符的ASCII码
     * @return int 下标值
     */
    public int indexOf(String seq, int searchChar) {
        return StringUtils.indexOf(seq, searchChar);
    }

    /**
     * 返回字符的ASCII码searchChar在字符串seq中第一次出现的位置。从seq的startPos位置开始搜索
     * 
     * @param seq 目标字符串
     * @param searchChar 匹配字符的ASCII码
     * @param startPos 开始位置
     * @return int 下标值
     */
    public int indexOf(String seq, int searchChar, int startPos) {
        return StringUtils.indexOf(seq, searchChar, startPos);
    }

    /**
     * 返回字符串searchSeq在字符串seq中第一次出现的位置 。从字符串seq的0位置搜索
     * 
     * @param seq 目标字符串
     * @param searchSeq 匹配字符串
     * @return int 下标值
     */
    public int indexOf(String seq, String searchSeq) {
        return StringUtils.indexOf(seq, searchSeq);
    }

    /**
     * 返回字符串searchSeq在字符串seq中第一次出现的位置 。从字符串seq的startPos位置搜索
     * 
     * @param seq 目标字符串
     * @param searchSeq 匹配字符串
     * @param startPos 开始位置
     * @return int 下标值
     */
    public int indexOf(String seq, String searchSeq, int startPos) {
        return StringUtils.indexOf(seq, searchSeq, startPos);
    }

    /**
     * 返回字符串searchStr在字符串str中第ordinal次出现的位置
     * 
     * @param str 目标字符串
     * @param searchStr 匹配字符串
     * @param ordinal 出现次数
     * @return int 下标值
     */
    public int ordinalIndexOf(String str, String searchStr, int ordinal) {
        return StringUtils.ordinalIndexOf(str, searchStr, ordinal);
    }

    /**
     * 返回字符串searchStr在字符串str中第一次出现的位置，忽略大小写
     * 
     * @param str 目标字符串
     * @param searchStr 匹配字符串
     * @return int 下标值
     */
    public int indexOfIgnoreCase(String str, String searchStr) {
        return StringUtils.indexOfIgnoreCase(str, searchStr);
    }

    /**
     * 返回字符串searchStr在字符串str中第一次出现的位置，忽略大小写，从str的startPos位置开始搜索
     * 
     * @param str 目标字符串
     * @param searchStr 匹配字符串
     * @param startPos 开始位置
     * @return int 下标值
     */
    public int indexOfIgnoreCase(String str, String searchStr, int startPos) {
        return StringUtils.indexOfIgnoreCase(str, searchStr, startPos);
    }

    /**
     * 返回字符searchChar在字符串seq中最后一次出现的位置
     * 
     * @param seq 目标字符串
     * @param searchChar 匹配字符的ASCII码
     * @return int 下标值
     */
    public int lastIndexOf(String seq, int searchChar) {
        return StringUtils.lastIndexOf(seq, searchChar);
    }

    /**
     * 返回字符searchChar在字符串seq中最后一次出现的位置 。从seq的startPos位置开始搜索
     * 
     * @param seq 目标字符串
     * @param searchChar 匹配字符的ASCII码
     * @param startPos 开始位置
     * @return int 下标值
     */
    public int lastIndexOf(String seq, int searchChar, int startPos) {
        return StringUtils.lastIndexOf(seq, searchChar, startPos);
    }

    /**
     * 返回字符串searchSeq在字符串seq中最后一次出现的位置
     * 
     * @param seq 目标字符串
     * @param searchSeq 匹配字符串
     * @return int 下标值
     */
    public int lastIndexOf(String seq, String searchSeq) {
        return StringUtils.lastIndexOf(seq, searchSeq);
    }

    /**
     * 返回字符串searchStr在字符串str中最后ordinal次出现的位置
     * 
     * @param str 目标字符串
     * @param searchStr 匹配字符串
     * @param ordinal 重复次数
     * @return int 下标值
     */
    public int lastOrdinalIndexOf(String str, String searchStr, int ordinal) {
        return StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);
    }

    /**
     * 在字符串seq的startPos之前的字符串中，找到最后一次出现searchSeq的位置
     * 当startPos的长度超过字符串的总长度时，会在整个str中查找
     * 
     * @param seq 被检查的字符串，
     * @param searchSeq 要找的字符串，
     * @param startPos 指定开始的位置，负数会被识别的0
     * @return int 下标值
     */
    public int lastIndexOf(String seq, String searchSeq, int startPos) {
        return StringUtils.lastIndexOf(seq, searchSeq, startPos);
    }

    /**
     * 返回字符串searchStr在字符串str中最后一次出现的位置，忽略大小写
     * 
     * @param str 目标字符串
     * @param searchStr 匹配字符串
     * @return int 下标值
     */
    public int lastIndexOfIgnoreCase(String str, String searchStr) {
        return StringUtils.lastIndexOfIgnoreCase(str, searchStr);
    }

    /**
     * 在字符串str的startPos之前的字符串中，找到最后一次出现searchStr的位置， 忽略大小写
     * 当startPos的长度超过字符串的总长度时，会在整个str中查找
     * 
     * @param str 目标字符串
     * @param searchStr 匹配字符串
     * @param startPos 开始位置
     * @return int 下标值
     */
    public int lastIndexOfIgnoreCase(String str, String searchStr, int startPos) {
        return StringUtils.lastIndexOfIgnoreCase(str, searchStr, startPos);
    }

    /**
     * 当字符串seq包含指定的字符searchChar时，返回 true
     * 
     * @param seq 目标字符串
     * @param searchChar 匹配字符的ASCII码
     * @return boolean
     */
    public boolean contains(String seq, int searchChar) {
        return StringUtils.contains(seq, searchChar);
    }

    /**
     * 当字符串seq中包含指定的字符串searchSeq时，返回 true
     * 
     * @param seq 目标字符串
     * @param searchSeq 匹配字符串
     * @return boolean
     */
    public boolean contains(String seq, String searchSeq) {
        return StringUtils.contains(seq, searchSeq);
    }

    /**
     * 当字符串数组seqs中只要有一个元素包含指定的字符串searchSeq时，返回 true
     * 
     * @param seqs
     * @param searchSeq
     * @return
     * @author 邢治理
     * @since 2016年3月7日
     */
    public boolean contains(String[] seqs, String searchSeq) {
        if ((seqs.length < 1) || (searchSeq == null)) {
            return false;
        }
        boolean isContain = false;
        for (int i = 0; i < seqs.length; i++) {
            if (StringUtils.contains(seqs[i], searchSeq)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    /**
     * 当字符串数组seqs中只要有一个元素与指定的字符串searchSeq相同时，返回 true
     * 
     * @param seqs
     * @param searchSeq
     * @return
     * @author 邢治理
     * @since 2016年3月7日
     */
    public boolean containsElement(String[] seqs, String searchSeq) {
        if ((seqs.length < 1) || (searchSeq == null)) {
            return false;
        }
        boolean isContain = false;
        for (int i = 0; i < seqs.length; i++) {
            if (searchSeq.equals(seqs[i])) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    /**
     * 当字符串seqs中有一个元素为""（空串）时，返回 true
     * 
     * @param seqs
     * @return
     */
    public boolean containsEmptyStr(String[] seqs) {
        if (seqs.length < 1) {
            return false;
        }
        boolean isContain = false;
        for (int i = 0; i < seqs.length; i++) {
            if ("".equals(seqs[i])) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    /**
     * 当字符串seqs中有一个元素trim后为""（空串）时，返回 true
     * 
     * @param seqs
     * @return
     */
    public boolean containsEmptyStrWithTrim(String[] seqs) {
        if (seqs.length < 1) {
            return false;
        }
        boolean isContain = false;
        for (int i = 0; i < seqs.length; i++) {
            if ("".equals(StringUtils.trim(seqs[i]))) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    /**
     * 当字符串str中包含指定的字符串searchStr时，返回 true 。忽略大小写
     * 
     * @param str 目标字符串
     * @param searchStr 要找的字符串，
     * @return boolean
     */
    public boolean containsIgnoreCase(String str, String searchStr) {
        return StringUtils.containsIgnoreCase(str, searchStr);
    }

    /**
     * 当字符串数组seqs中有一个元素包含指定的字符串searchSeq时，返回 true，忽略大小写
     * 
     * @param seqs
     * @param searchSeq
     * @return
     * @author 邢治理
     * @since 2016年3月7日
     */
    public boolean containsIgnoreCase(String[] seqs, String searchSeq) {
        if ((seqs.length < 1) || (searchSeq == null)) {
            return false;
        }
        boolean isContain = false;
        for (int i = 0; i < seqs.length; i++) {
            if (StringUtils.containsIgnoreCase(seqs[i], searchSeq)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    /**
     * 当字符串数组seqs中有一个元素与指定的字符串searchSeq相同时，返回 true，忽略大小写
     * 
     * @param seqs
     * @param searchSeq
     * @return
     * @author 邢治理
     * @since 2016年3月7日
     */
    public boolean containsElementIgnoreCase(String[] seqs, String searchSeq) {
        if ((seqs.length < 1) || (searchSeq == null)) {
            return false;
        }
        boolean isContain = false;
        for (int i = 0; i < seqs.length; i++) {
            if (searchSeq.equalsIgnoreCase(seqs[i])) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    /**
     * 检查字符串seq是否不为空并且包含至少一个空白字符
     * 
     * @param seq 目标字符串
     * @return boolean
     */
    public boolean containsWhitespace(String seq) {
        return StringUtils.containsWhitespace(seq);
    }

    /**
     * 找出字符数组searchChars中的字符第一次出现在字符串cs中的位置
     * 如果字符数组中的字符都不在字符串中，则返回-1
     * 如果字符串为null或""，则返回-1
     * 
     * @param cs 目标字符串
     * @param searchChars 匹配字符数组
     * @return int 下标值
     */
    public int indexOfAny(String cs, char[] searchChars) {
        return StringUtils.indexOfAny(cs, searchChars);
    }

    /**
     * 找出字符串searchChars中的字符第一次出现在字符串cs中的位置
     * 如果字符串searchChars中的字符都不在字符串str中，则返回-1
     * 如果searchChars或str为null或为""，则返回-1
     * 
     * @param cs 目标字符串
     * @param searchChars 匹配字符串
     * @return int 下标值
     */
    public int indexOfAny(String cs, String searchChars) {
        return StringUtils.indexOfAny(cs, searchChars);
    }

    /**
     * 检查字符串cs中是否包含searchChars中的一个或几个字符
     * 
     * @param cs 目标字符串
     * @param searchChars 匹配字符数组
     * @return boolean
     */
    public boolean containsAny(String cs, char[] searchChars) {
        return StringUtils.containsAny(cs, searchChars);
    }

    /**
     * 检查字符串cs中是否包含searchChars中的一个或几个字符
     * 
     * @param cs 目标字符串
     * @param searchChars 匹配字符串
     * @return boolean
     */
    public boolean containsAny(String cs, String searchChars) {
        return StringUtils.containsAny(cs, searchChars);
    }

    /**
     * 检查字符串cs中是否包含searchStrings中的一个或几个字符
     * 
     * @param cs 目标字符串
     * @param searchStrings 匹配字符串数组
     * @return boolean
     */
    public boolean containsAny(String cs, String[] searchStrings) {
        return StringUtils.containsAny(cs, searchStrings);
    }

    /**
     * 搜索字符串cs，找第一个不在给定的字符集searchChars 中的字符的位置
     * 
     * @param cs 目标字符串
     * @param searchChars 匹配字符数组
     * @return int 下标值
     */
    public int indexOfAnyBut(String cs, char[] searchChars) {
        return StringUtils.indexOfAnyBut(cs, searchChars);
    }

    /**
     * 判断字符串cs是否只包含字符数组valid中的字符
     * 
     * @param cs 目标字符串
     * @param valid 字符数组
     * @return boolean
     */
    public boolean containsOnly(String cs, char[] valid) {
        return StringUtils.containsOnly(cs, valid);
    }

    /**
     * 判断字符串cs是否只包含字符串validChars中的字符
     * 
     * @param cs 目标字符串
     * @param validChars 匹配字符串
     * @return boolean
     */
    public boolean containsOnly(String cs, String validChars) {
        return StringUtils.containsOnly(cs, validChars);
    }

    /**
     * 判断字符串cs是否不包含字符数组searchChars中的任何一个字符，如果包含则返回false
     * 
     * @param cs 目标字符串
     * @param searchChars 匹配字符数组
     * @return boolean
     */
    public boolean containsNone(String cs, char[] searchChars) {
        return StringUtils.containsNone(cs, searchChars);
    }

    /**
     * 判断字符串cs是否不包含字符串invalidChars中的任何一个字符，如果包含则返回false
     * 
     * @param cs 目标字符串
     * @param invalidChars 匹配字符串
     * @return boolean
     */
    public boolean containsNone(String cs, String invalidChars) {
        return StringUtils.containsNone(cs, invalidChars);
    }

    /**
     * 找出字符数组searchChars中的字符串第一次出现在字符串str中的位置
     * 如果字符串数组searchStrs中的字符串都不在字符串str中，则返回-1
     * 如果searchStrs或str为null或为""，则返回-1
     * 
     * @param str 目标字符串
     * @param searchStrs 字符串数组
     * @return int 下标值
     */
    public int indexOfAny(String str, String[] searchStrs) {
        return StringUtils.indexOfAny(str, searchStrs);
    }

    /**
     * 找出字符数组searchStrs中的字符串最后一次出现在字符串str中的位置
     * 
     * @param str 目标字符串
     * @param searchStrs 字符串数组
     * @return int 下标值
     */
    public int lastIndexOfAny(String str, String[] searchStrs) {
        return StringUtils.lastIndexOfAny(str, searchStrs);
    }

    /**
     * 得到字符串str的子串。 如果start小于0，位置是从后往前数的第|start|个
     * 如果str为null或""，则返回它本身
     * 
     * @param str 目标字符串
     * @param start 开始截取的位置
     * @return String
     */
    public String substring(String str, int start) {
        return StringUtils.substring(str, start);
    }

    /**
     * 得到字符串str的子串。 如果start小于0，位置是从后往前数的第|start|个
     * 如果end小于0，位置是从后往前数的第|end|个
     * 如果str为null或""，则返回它本身
     * 
     * @param str 目标字符串
     * @param start 开始下标
     * @param end 结束下标
     * @return String
     */
    public String substring(String str, int start, int end) {
        return StringUtils.substring(str, start, end);
    }

    /**
     * 得到字符串str从左边数len长度的子串。如果str为null或为""，则返回它本身
     * 如果len小于0，则返回""
     * 
     * @param str 目标字符串
     * @param len 想获取字符串的长度
     * @return String
     */
    public String left(String str, int len) {
        return StringUtils.left(str, len);
    }

    /**
     * 得到字符串str从右边数len长度的子串。
     * 如果str为null或为""，则返回它本身
     * 如果len小于0，则返回""
     * 
     * @param str 目标字符串
     * @param len 想获取字符串的长度
     * @return String
     */
    public String right(String str, int len) {
        return StringUtils.right(str, len);
    }

    /**
     * 得到字符串str从pos开始len长度的子串
     * 如果str为null或为""，则返回它本身
     * 如果len小于0或pos大于srt的长度，则返回""
     * 如果pos小于0，则pos设为0
     * 
     * @param str 目标字符串
     * @param pos 开始截取的位置，负数将视为0
     * @param len 想获取字符串的长度
     * @return String
     */
    public String mid(String str, int pos, int len) {
        return StringUtils.mid(str, pos, len);
    }

    /**
     * 得到字符串str的在字符串separator出现前的字串，且separator不包括在内
     * 如果str为null或为""，则返回它本身
     * 如果separator为null，则返回str本身
     * 
     * @param str 目标字符串
     * @param separator 分隔字符串，
     * @return String
     */
    public String substringBefore(String str, String separator) {
        return StringUtils.substringBefore(str, separator);
    }

    /**
     * 得到字符串str的在字符串separator出现后的字符串，且separator不包括在内
     * 如果str为null或为""，则返回它本身
     * 如果separator为null，则返回""
     * 
     * @param str 目标字符串
     * @param separator 分隔字符串，
     * @return String
     */
    public String substringAfter(String str, String separator) {
        return StringUtils.substringAfter(str, separator);
    }

    /**
     * 得到字符串str的在字符串separator最后一次出现前的字符串，且separator不包括在内
     * 如果str为null或为""，则返回它本身
     * 如果separator为null，则返回str本身
     * 
     * @param str 目标字符串
     * @param separator 分隔字符串
     * @return String
     */
    public String substringBeforeLast(String str, String separator) {
        return StringUtils.substringBeforeLast(str, separator);
    }

    /**
     * 得到字符串str的在字符串separator最后一次出现后的字符串，且separator不包括在内
     * 如果str为null或为""，则返回它本身
     * 如果separator为null，则返回""
     * 
     * @param str 目标字符串
     * @param separator 分隔字符串
     * @return String
     */
    public String substringAfterLast(String str, String separator) {
        return StringUtils.substringAfterLast(str, separator);
    }

    /**
     * 得到str中的在两个字符串tag中间的字符串，即str中的tag所夹的串
     * 如果str为null或tag为null，返回null
     * 
     * @param str 目标字符串
     * @param tag 子字符串前和后的字符串，可能为空
     * @return String
     */
    public String substringBetween(String str, String tag) {
        return StringUtils.substringBetween(str, tag);
    }

    /**
     * 得到str中的在两个字符串open和close中间的字符串，即open和close所夹的串，只返回第一个匹配的结果
     * 如果str为null或open为null或close为null，返回null
     * 
     * @param str 目标字符串
     * @param open 子字符串前的字符串，可能为空
     * @param close 子字符串后的字符串，可能为空
     * @return String
     */
    public String substringBetween(String str, String open, String close) {
        return StringUtils.substringBetween(str, open, close);
    }

    /**
     * 得到str中的在两个字符串open和close中间的字符串，即open和close所夹的串， 把所有符合的结果放在数组中返回
     * 
     * @param str 目标字符串
     * @param open 子字符串前的字符串， 空 返回 null
     * @param close 子字符串后的字符串， 空 返回 null
     * @return String[]
     */
    public String[] substringsBetween(String str, String open, String close) {
        return StringUtils.substringsBetween(str, open, close);
    }

    /**
     * 把字符串拆分成一个字符串数组，用空白符(whitespace)作为分隔符
     * 如果字符串为null，返回null,如果字符串为""，返回空数组{}
     * 
     * @param str 目标字符串
     * @return String[]
     */
    public String[] split(String str) {
        return StringUtils.split(str);
    }

    /**
     * 把字符串拆分成一个字符串数组，用指定的字符separatorChar作为分隔符
     * 
     * @param str 目标字符串
     * @param separatorChar 用来分隔的字符
     * @return String[]
     */
    public String[] split(String str, char separatorChar) {
        return StringUtils.split(str, separatorChar);
    }

    /**
     * 把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符
     * 如果字符串str为null，返回null,如果字符串str为""，返回空数组{}
     * 如果separatorChars为null，则默认为空白符
     * 
     * @param str 目标字符串
     * @param separatorChars 用来分隔的字符
     * @return String[]
     */
    public String[] split(String str, String separatorChars) {
        return StringUtils.split(str, separatorChars);
    }

    /**
     * 把字符串拆分成一个字符串数组，用指定的字符串separatorChars作为分隔符，数组的最大长度为max
     * 如果字符串str为null，返回null ，如果字符串str为""，返回空数组{}
     * 如果separatorChars为null，则默认为空白符 ，如果max小于等于0，则视为没有限制
     * 
     * @param str 目标字符串
     * @param separatorChars 用来分隔的字符
     * @param max 数组元素数最大值，0和负数视为无限制
     * @return String[]
     */
    public String[] split(String str, String separatorChars, int max) {
        return StringUtils.split(str, separatorChars, max);
    }

    /**
     * 把字符串拆分成一个字符串数组，用指定的字符串separator作为分隔符
     * 如果字符串str为null，返回null，如果字符串str为""，返回空数组{}
     * 如果separatorChars为null，则默认为空白符
     * 
     * @param str 目标字符串
     * @param separator 用来分隔的字符串
     * @return String[]
     */
    public String[] splitByWholeSeparator(String str, String separator) {
        return StringUtils.splitByWholeSeparator(str, separator);
    }

    /**
     * 把字符串拆分成一个字符串数组，用指定的字符串separator作为分隔符
     * 如果字符串str为null，返回null，如果字符串str为""，返回空数组{}
     * 如果separator为null，则默认为空白符，区别于上个函数，会返回""元素
     * 
     * @param str 目标字符串
     * @param separator 用来分隔的字符串
     * @return String[]
     */
    public String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator) {
        return StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
    }

    /**
     * 把字符串str拆分成一个数组，用空白符(whitespace)作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识
     * 它可作为StringTokenizer的一个替代
     * 
     * @param str 目标字符串
     * @return String[]
     */
    public String[] splitPreserveAllTokens(String str) {
        return StringUtils.splitPreserveAllTokens(str);
    }

    /**
     * 把字符串str拆分成一个数组，用字符separatorChar作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识
     * 
     * @param str 目标字符串
     * @param separatorChar 用来分隔的字符，如果为null则用空白符分隔
     * @return String[]
     */
    public String[] splitPreserveAllTokens(String str, char separatorChar) {
        return StringUtils.splitPreserveAllTokens(str, separatorChar);
    }

    /**
     * 把字符串str拆分成一个数组，用字符串separatorChars作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识
     * 
     * @param str 目标字符串
     * @param separatorChars 用来分隔的字符，如果为null则用空白符分隔
     * @return String[]
     */
    public String[] splitPreserveAllTokens(String str, String separatorChars) {
        return StringUtils.splitPreserveAllTokens(str, separatorChars);
    }

    /**
     * 把字符串str拆分成一个数组，用字符串separatorChars作为分隔符，保留所有的标识，包括相邻分隔符产生的空的标识
     * 数组的最大长度为max。如果max为0或负数，视为没有限制
     * 
     * @param str 目标字符串
     * @param separatorChars 用来分隔的字符，如果为null则用空白符分隔
     * @param max 返回数组元素最大数，0或负数视为无限制
     * @return String[]
     */
    public String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
        return StringUtils.splitPreserveAllTokens(str, separatorChars, max);
    }

    /**
     * 把字符串分解成字符组，按类型进行分
     * 
     * @param str 目标字符串
     * @return String[]
     */
    public String[] splitByCharacterType(String str) {
        return StringUtils.splitByCharacterType(str);
    }

    /**
     * 把集合中的元素连接成一个字符串返回
     * 
     * @param elements 将被连接的元素，
     * @return <T> 指定连接的数据类型
     */
    public <T> String join(T[] elements) {
        return StringUtils.join(elements);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return String
     */
    public String join(Object[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return String
     */
    public String join(long[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return String
     */
    public String join(int[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return String
     */
    public String join(short[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return String
     */
    public String join(byte[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return
     */
    public String join(char[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return
     */
    public String join(float[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return
     */
    public String join(double[] array, char separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(Object[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(long[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(int[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(byte[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(short[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(char[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(double[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔符separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @param startIndex 连接开始的位置。 start index超过数组范围将是个错误
     * @param endIndex 连接结束的位置。 end index超过数组范围将是个错误
     * @return String
     */
    public String join(float[] array, char separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把数组array中的元素通过分隔字符串separator连接成一个字符串返回
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符，null将以""对待
     * @return String
     */
    public String join(Object[] array, String separator) {
        return StringUtils.join(array, separator);
    }

    /**
     * 把数组array中的元素通过分隔字符串separator连接成一个字符串返回，连接的开始位置为startIndex，结束位置为endIndex
     * 
     * @param array 数组中的值将被连接在一起
     * @param separator 连接时使用的字符，null将以""对待
     * @param startIndex 连接开始的位置
     * @param endIndex 连接结束的位置
     * @return String
     */
    public String join(Object[] array, String separator, int startIndex, int endIndex) {
        return StringUtils.join(array, separator, startIndex, endIndex);
    }

    /**
     * 把iterator中的元素通过分隔字符separator连接成一个字符串返回
     * 
     * @param iterator iterator中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return String
     */
    public String join(Iterator<?> iterator, char separator) {
        return StringUtils.join(iterator, separator);
    }

    /**
     * 把iterator中的元素通过分隔字符串separator连接成一个字符串返回
     * 
     * @param iterator iterator中的值将被连接在一起
     * @param separator 连接时使用的字符，null将以""对待
     * @return String
     */
    public String join(Iterator<?> iterator, String separator) {
        return StringUtils.join(iterator, separator);
    }

    /**
     * 把Iterable中的元素通过分隔字符串separator连接成一个字符串返回
     * 
     * @param iterable iterable中的值将被连接在一起
     * @param separator 连接时使用的字符
     * @return String
     */
    public String join(Iterable<?> iterable, char separator) {
        return StringUtils.join(iterable, separator);
    }

    /**
     * 把Iterable中的元素通过分隔字符串separator连接成一个字符串返回
     * 
     * @param iterable iterable 中的值将被连接在一起
     * @param separator 连接时使用的字符，null将以""对待
     * @return String
     */
    public String join(Iterable<?> iterable, String separator) {
        return StringUtils.join(iterable, separator);
    }

    /**
     * 删除字符串中的所有空白符
     * 
     * @param str 被处理的字符串，
     * @return String
     */
    public String deleteWhitespace(String str) {
        return StringUtils.deleteWhitespace(str);
    }

    /**
     * 如果字符串str是以字符串remove开始，则去掉这个开始，然后返回，否则返回原来的串
     * 
     * @param str 从这个字符串中搜索
     * @param remove 需要去掉的字符串
     * @return String
     */
    public String removeStart(String str, String remove) {
        return StringUtils.removeStart(str, remove);
    }

    /**
     * 如果字符串str是以字符串remove开始，则去掉这个开始，然后返回， 否则返回原来的串,忽略大小写
     * 
     * @param str 从这个字符串中搜索
     * @param remove 需要去掉的字符串（忽略大小写）
     * @return String
     */
    public String removeStartIgnoreCase(String str, String remove) {
        return StringUtils.removeStartIgnoreCase(str, remove);
    }

    /**
     * 如果字符串str是以字符串remove结尾，则去掉这个结尾，然后返回，否则返回原来的串
     * 
     * @param str 从这个字符串中搜索
     * @param remove 需要去掉的字符串
     * @return String
     */
    public String removeEnd(String str, String remove) {
        return StringUtils.removeEnd(str, remove);
    }

    /**
     * 如果字符串str是以字符串remove结尾，则去掉这个结尾，然后返回，否则返回原来的串，忽略大小写
     * 
     * @param str 从这个字符串中搜索
     * @param remove 需要去掉的字符串（忽略大小写）
     * @return String
     */
    public String removeEndIgnoreCase(String str, String remove) {
        return StringUtils.removeEndIgnoreCase(str, remove);
    }

    /**
     * 去掉字符串str中所有包含字符串remove的部分，然后返回
     * 
     * @param str 从这个字符串中搜索
     * @param remove 需要去掉的字符串
     * @return String
     */
    public String remove(String str, String remove) {
        return StringUtils.remove(str, remove);
    }

    /**
     * 去掉字符串str中所有包含字符remove的部分，然后返回
     * 
     * @param str 从这个字符串中搜索
     * @param remove 需要去掉的字符串
     * @return String
     */
    public String remove(String str, char remove) {
        return StringUtils.remove(str, remove);
    }

    /**
     * 在字符串text中用字符串replacement 代替searchString ，仅一次
     * 
     * @param text 被处理的字符串
     * @param searchString 将被替换掉的字符串
     * @param replacement 将要替换成的字符串，可能为 null
     * @return String
     */
    public String replaceOnce(String text, String searchString, String replacement) {
        return StringUtils.replaceOnce(text, searchString, replacement);
    }

    /**
     * 用字符串replacement替换掉source中所有匹配上正则regex的字符串
     * 
     * @param source 被处理的字符串
     * @param regex 正则
     * @param replacement 被替换成的字符串
     * @return String
     */
    public String replacePattern(String source, String regex, String replacement) {
        return StringUtils.replacePattern(source, regex, replacement);
    }

    /**
     * 去掉source中所有匹配上正则regex的字符串
     * 
     * @param source 被处理的字符串
     * @param regex 正则
     * @return String
     */
    public String removePattern(String source, String regex) {
        return StringUtils.removePattern(source, regex);
    }

    /**
     * 用字符串replacement替换字符串text中所有的字符串searchString
     * 
     * @param text 被处理的字符串
     * @param searchString 将被替换的字符串
     * @param replacement 将被替换成的字符串
     * @return String
     */
    public String replace(String text, String searchString, String replacement) {
        return StringUtils.replace(text, searchString, replacement);
    }

    /**
     * 用字符串replacement替换字符串text中的字符串searchString，max为最大替换次数 。 如果max小于0，则替换所有
     * 
     * @param text 被处理的字符串
     * @param searchString 将被替换的字符串
     * @param replacement 将被替换成的字符串
     * @param max 替换的最大次数
     * @return String
     */
    public String replace(String text, String searchString, String replacement, int max) {
        return StringUtils.replace(text, searchString, replacement, max);
    }

    /**
     * 用 replacementList替换text字符串中的searchList，按数组下标对应替换
     * 
     * @param text 被处理的字符串，如果为null则不处理
     * @param searchList 将被替换掉的字符串列表，如果为null则不处理
     * @param replacementList 将被替换成的字符串列表，如果为null则不处理
     * @return String
     */
    public String replaceEach(String text, String[] searchList, String[] replacementList) {
        return StringUtils.replaceEach(text, searchList, replacementList);
    }

    /**
     * 用 replacementList替换text字符串中的searchList，按数组下标对应替换 。循环多次替换，上一次的结果将作为下一次的开始
     * 
     * @param text 被处理的字符串，如果为null则不处理
     * @param searchList 将被替换掉的字符串列表，如果为null则不处理
     * @param replacementList 将被替换成的字符串列表，如果为null则不处理
     * @return String
     */
    public String replaceEachRepeatedly(String text, String[] searchList, String[] replacementList) {
        return StringUtils.replaceEachRepeatedly(text, searchList, replacementList);
    }

    /**
     * 用字符replaceChar替换掉字符串str中所有字符searchChar，如果字符串为null或""，则返回它本身
     * 
     * @param str 被处理的字符串
     * @param searchChar 将被替换掉的字符
     * @param replaceChar 将被替换成的字符
     * @return String
     */
    public String replaceChars(String str, char searchChar, char replaceChar) {
        return StringUtils.replaceChars(str, searchChar, replaceChar);
    }

    /**
     * 用字符串replaceChars中的字符替换字符串str中字符串searchChars中的字符
     * replaceChars的长度应该和searchChars的长度相等，如果replaceChars的长度大于
     * searchChars的长度，超过长度的字符将被忽略，如果replaceChars的长度小于searchChars的长度，超过长度的字符将被删除
     * 
     * @param str 被处理的字符串
     * @param searchChars 将被替换掉的字符集
     * @param replaceChars 将被替换成的字符集
     * @return String
     */
    public String replaceChars(String str, String searchChars, String replaceChars) {
        return StringUtils.replaceChars(str, searchChars, replaceChars);
    }

    /**
     * 用字符串overlay覆盖字符串str从start到end之间的串。 如果str为null，则返回null
     * 如果start或end小于0，则设为0，如果start大于end， 则两者交换， 如果start
     * 或end大于str的长度，则认为等于str的长度
     * 
     * @param str 被处理的字符串
     * @param overlay 将要覆盖成的字符串
     * @param start 覆盖开始位置
     * @param end 覆盖结束位置
     * @return String
     */
    public String overlay(String str, String overlay, int start, int end) {
        return StringUtils.overlay(str, overlay, start, end);
    }

    /**
     * 去掉字符串中的一个以\r\n结尾的字符
     * 
     * @param str 被处理的字符串
     * @return String
     */
    public String chomp(String str) {
        return StringUtils.chomp(str);
    }

    /**
     * 去掉字符串str的最后一个字符。如果字符串以"/r/n"结尾，则去掉它们
     * 
     * @param str 被处理的字符串
     * @return String
     */
    public String chop(String str) {
        return StringUtils.chop(str);
    }

    /**
     * 重复字符串str repeat次，组合成一个新串返回 。如果字符串str为null或""，则返回它本身，如果repeat小于0，则返回""
     * 
     * @param str 被重复的字符串
     * @param repeat 被重复的次数，负数将被视为0
     * @return String
     */
    public String repeat(String str, int repeat) {
        return StringUtils.repeat(str, repeat);
    }

    /**
     * 重复字符串str repeat次，组合成一个新串返回。每次注入一个字符串分隔符separator
     * 
     * @param str 被重复的字符串
     * @param separator 被注入的分隔符
     * @param repeat 被重复的次数，负数将被视为0
     * @return String
     */
    public String repeat(String str, String separator, int repeat) {
        return StringUtils.repeat(str, separator, repeat);
    }

    /**
     * 重复字符ch repeat次
     * 
     * @param ch 要重复的字符串
     * @param repeat 被重复的次数，负数将被视为0
     * @return String
     */
    public String repeat(char ch, int repeat) {
        return StringUtils.repeat(ch, repeat);
    }

    /**
     * 在str右边补空格使其长度等于size 。如果str为null，则返回null，如果字符串长度小于size
     * 则在str右边补空格使其长度等于size，然后返回 如果字符串长度大于等于size，则返回它本身
     * 
     * @param str 被处理的字符串
     * @param size 被补充到的长度
     * @return String
     */
    public String rightPad(String str, int size) {
        return StringUtils.rightPad(str, size);
    }

    /**
     * 在字符串str右边补字符padChar使其长度等于size 。如果str为null，则返回null；如果字符串长度大于等于size，则返回它本身
     * 
     * @param str 被处理的字符串
     * @param size 将要达到的长度
     * @param padChar 补充长度时使用此字符
     * @return String
     */
    public String rightPad(String str, int size, char padChar) {
        return StringUtils.rightPad(str, size, padChar);
    }

    /**
     * 在字符串右边补字符串padStr使其长度等于size 。如果字符串长度大于等于size，则返回它本身
     * 
     * @param str 被处理的字符串
     * @param size 将要达到的长度
     * @param padStr 使用此字符串来补充长度，null 或 空 将视为单个空格
     * @return String
     */
    public String rightPad(String str, int size, String padStr) {
        return StringUtils.rightPad(str, size, padStr);
    }

    /**
     * 在字符串str左边补空格使其长度等于size 。如果字符串长度大于等于size，则返回它本身；如果str为null，则返回null
     * 
     * @param str 被处理的字符串
     * @param size 将要达到的长度
     * @return String
     */
    public String leftPad(String str, int size) {
        return StringUtils.leftPad(str, size);
    }

    /**
     * 在字符串str左边补字符padChar使其长度等于size 。如果字符串长度大于等于size，则返回它本身；如果str为null，则返回null
     * 
     * @param str 被处理的字符串
     * @param size 将要达到的长度
     * @param padChar 用这个字符补充不足位
     * @return String
     */
    public String leftPad(String str, int size, char padChar) {
        return StringUtils.leftPad(str, size, padChar);
    }

    /**
     * 在字符串str左边补padStr使其长度等于size 。如果字符串长度大于等于size，则返回它本身；如果str为null，则返回null
     * 
     * @param str 被处理的字符串
     * @param size 将要达到的长度
     * @param padStr 用这个字符串补充不足位
     * @return String
     */
    public String leftPad(String str, int size, String padStr) {
        return StringUtils.leftPad(str, size, padStr);
    }

    /**
     * 得到一个字符串的长度
     * 
     * @param cs 被处理的字符串
     * @return int
     */
    public int length(String cs) {
        return StringUtils.length(cs);
    }

    /**
     * 返回一个字符串，该字符串长度等于size，str位于新串的中心，其他位置补空格 。如果str为null，则返回null
     * 如果size小于str的长度，则返回str本身
     * 
     * @param str 放在新串中间的字符串
     * @param size 新串的长度，负数将被视为0
     * @return String
     */
    public String center(String str, int size) {
        return StringUtils.center(str, size);
    }

    /**
     * 返回一个字符串，该字符串长度等于size，str位于新串的中心，其他位置补字符padChar
     * 如果str为null，则返回null；如果size小于str的长度，则返回str本身
     * 
     * @param str 放在新串中间的字符串
     * @param size 新串的长度，负数将被视为0
     * @param padChar 用于补位的字符
     * @return String
     */
    public String center(String str, int size, char padChar) {
        return StringUtils.center(str, size, padChar);
    }

    /**
     * 返回一个字符串，该字符串长度等于size，str位于新串的中心，其他位置补字符串padStr
     * 如果str为null，则返回null；如果size小于str的长度，则返回str本身
     * 
     * @param str 放在新串中间的字符串
     * @param size 新串的长度，负数将被视为0
     * @param padStr 用于补位的字符串，必须不为null 和 空值
     * @return String
     */
    public String center(String str, int size, String padStr) {
        return StringUtils.center(str, size, padStr);
    }

    /**
     * 字符串变为大写
     * 
     * @param str 需要转换成大写的字符串，
     * @return String
     */
    public String upperCase(String str) {
        return StringUtils.upperCase(str);
    }

    /**
     * 字符串变为大写，String中的方法toUpperCase()的结果是受当前locale影响的
     * 跨平台的使用场景，需要使用方法upperCase(String, Locale)并制定一个 locale (如Locale.ENGLISH})
     * 
     * @param str 需要转换成大写的字符串
     * @param locale 当前位置
     * @return String
     */
    public String upperCase(String str, Locale locale) {
        return StringUtils.upperCase(str, locale);
    }

    /**
     * 字符串变为小写
     * 
     * @param str 需要转换成大写的字符串
     * @return String
     */
    public String lowerCase(String str) {
        return StringUtils.lowerCase(str);
    }

    /**
     * 字符串变为小写，String中的方法toLowerCase()的结果是受当前locale影响的
     * 跨平台的使用场景，需要使用方法lowerCase(String, Locale)并制定一个 locale (如Locale.ENGLISH})
     * 
     * @param str str 需要转换成大写的字符串
     * @param locale 当前位置
     * @return String
     */
    public String lowerCase(String str, Locale locale) {
        return StringUtils.lowerCase(str, locale);
    }

    /**
     * 将str首字母大写，用于名称、头衔等
     * 
     * @param str 被处理的字符串
     * @return String
     */
    public String capitalize(String str) {
        return StringUtils.capitalize(str);
    }

    /**
     * 将str第一个字母小写
     * 
     * @param str 被处理的字符串
     * @return String
     */
    public String uncapitalize(String str) {
        return StringUtils.uncapitalize(str);
    }

    /**
     * 把字符串中的字符大写转换为小写，小写转换为大写
     * 
     * @param str 被处理的字符串
     * @return String
     */
    public String swapCase(String str) {
        return StringUtils.swapCase(str);
    }

    /**
     * 计算字符串sub在字符串str中出现的次数 。如果str为null或""，则返回0
     * 
     * @param str 被检查的字符串
     * @param sub 将要计算数量的字符串
     * @return int
     */
    public int countMatches(String str, String sub) {
        return StringUtils.countMatches(str, sub);
    }

    /**
     * 计算字符ch在字符串str中出现的次数 。如果str为null或""，则返回0
     * 
     * @param str 被检查的字符串
     * @param ch 将要计算数量的字符串
     * @return int
     */
    public int countMatches(String str, char ch) {
        return StringUtils.countMatches(str, ch);
    }

    /**
     * 判断String是否由字母组成
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isAlpha(String cs) {
        return StringUtils.isAlpha(cs);
    }

    /**
     * 判断cs是否由字母和空格组成
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isAlphaSpace(String cs) {
        return StringUtils.isAlphaSpace(cs);
    }

    /**
     * 判断String是否由字母或数字组成
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isAlphanumeric(String cs) {
        return StringUtils.isAlphanumeric(cs);
    }

    /**
     * 判断String是否由字母、数字或空格组成
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isAlphanumericSpace(String cs) {
        return StringUtils.isAlphanumericSpace(cs);
    }

    /**
     * 判断String是否由ASCII字符组成
     * 
     * @param cs 被检查的字符串
     * @return boolean 如果每个字符都在32~126中间，则返回true
     */
    public boolean isAsciiPrintable(String cs) {
        return StringUtils.isAsciiPrintable(cs);
    }

    /**
     * 判断字符串String是否由数字组成，并且非null
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isNumeric(String cs) {
        return StringUtils.isNumeric(cs);
    }

    /**
     * 判断字符串cs是否由数字或空字符组成，并且非null
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isNumericSpace(String cs) {
        return StringUtils.isNumericSpace(cs);
    }

    /**
     * 判断字符串cs是否只含空格，并且非null
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isWhitespace(String cs) {
        return StringUtils.isWhitespace(cs);
    }

    /**
     * 检查字符串中是否只存在小写，并且非null
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isAllLowerCase(String cs) {
        return StringUtils.isAllLowerCase(cs);
    }

    /**
     * 检查字符串中是否都是大写
     * 
     * @param cs 被检查的字符串
     * @return boolean
     */
    public boolean isAllUpperCase(String cs) {
        return StringUtils.isAllUpperCase(cs);
    }

    /**
     * 如果str不是空返回str，否则返回""
     * 
     * @param str 被检查的字符串
     * @return String
     */
    public String defaultString(String str) {
        return StringUtils.defaultString(str);
    }

    /**
     * 如果str不为空，返回str，否则返回defaultStr
     * 
     * @param str 被检查的字符串
     * @param defaultStr 如果str为空，则此字符串作为默认值返回
     * @return String
     */
    public String defaultString(String str, String defaultStr) {
        return StringUtils.defaultString(str, defaultStr);
    }

    /**
     * 返回字符串str；如果为null、空白或""，就返回defaultStr中的值
     * 
     * @param str 被检查的字符串
     * @param defaultStr 如果str为null、空白或""，则此字符串作为默认值返回
     * @return T
     */
    public String defaultIfBlank(String str, String defaultStr) {
        return StringUtils.defaultIfBlank(str, defaultStr);
    }

    /**
     * 返回字符串str，如果为null或""，就返回defaultStr中的值
     * 
     * @param str 被检查的字符串
     * @param defaultStr 如果str为null或""，则此字符串作为默认值返回
     * @return T
     */
    public String defaultIfEmpty(String str, String defaultStr) {
        return StringUtils.defaultIfEmpty(str, defaultStr);
    }

    /**
     * 以字符（单个词）为单位的反转
     * 
     * @param str 被处理的字符串
     * @return String
     */
    public String reverse(String str) {
        return StringUtils.reverse(str);
    }

    /**
     * 字符串str单词反向排序，以separatorChar为分隔符，如果str中没有此分隔符则不处理
     * 
     * @param str 被处理的字符串
     * @param separatorChar 分隔符
     * @return String
     */
    public String reverseDelimited(String str, char separatorChar) {
        return StringUtils.reverseDelimited(str, separatorChar);
    }

    /**
     * 取得字符串的缩写，从第一个字符开始[1,maxWidth]
     * 
     * @param str 被处理的字符串
     * @param maxWidth 返回字符串的最大长度，必须至少为 4
     * @return String
     */
    public String abbreviate(String str, int maxWidth) {
        return StringUtils.abbreviate(str, maxWidth);
    }

    /**
     * 取得字符串的缩写，从第offset个字符开始[offset,maxWidth]
     * 
     * @param str 被处理的字符串
     * @param offset 从此位置开始获取
     * @param maxWidth 返回字符串的最大长度，必须至少为 4
     * @return String
     */
    public String abbreviate(String str, int offset, int maxWidth) {
        return StringUtils.abbreviate(str, offset, maxWidth);
    }

    /**
     * 省略字符串str中间一定长度的字符串，省略部分用middle代替，最终长度需要为length
     * 
     * @param str 被处理的字符串
     * @param middle 替换省略部分的字符串
     * @param length 最终缩短到的长度
     * @return String
     */
    public String abbreviateMiddle(String str, String middle, int length) {
        return StringUtils.abbreviateMiddle(str, middle, length);
    }

    /**
     * 比较两个字符串，返回str2中与str1不同的部分
     * 
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return String
     */
    public String difference(String str1, String str2) {
        return StringUtils.difference(str1, str2);
    }

    /**
     * 比较两个字符串，返回第一次不同的位置
     * 
     * @param cs1 第一个字符串
     * @param cs2 第二个字符串
     * @return int
     */
    public int indexOfDifference(String cs1, String cs2) {
        return StringUtils.indexOfDifference(cs1, cs2);
    }

    /**
     * 比较一组字符串，返回第一次不同的位置
     * 
     * @param css 字符串数组
     * @return int
     */
    public int indexOfDifference(String[] css) {
        return StringUtils.indexOfDifference(css);
    }

    /**
     * 比较一组字符串，返回公有前缀
     * 
     * @param strs 字符串数组
     * @return String
     */
    public String getCommonPrefix(String[] strs) {
        return StringUtils.getCommonPrefix(strs);
    }

    /**
     * 检查字符串str的前缀是否为prefix
     * 
     * @param str 被检查的字符串
     * @param prefix 被查找的前缀
     * @return boolean
     */
    public boolean startsWith(String str, String prefix) {
        return StringUtils.startsWith(str, prefix);
    }

    /**
     * 检查字符串str的前缀是否为prefix，不区分大小写
     * 
     * @param str 被检查的字符串
     * @param prefix 被查找的前缀
     * @return boolean
     */
    public boolean startsWithIgnoreCase(String str, String prefix) {
        return StringUtils.startsWithIgnoreCase(str, prefix);
    }

    /**
     * 检查字符串string的前缀是否为searchStrings中的任何一个，不区分大小写
     * 
     * @param string 被检查的字符串
     * @param searchStrings 查找的前缀
     * @return boolean
     */
    public boolean startsWithAny(String string, String[] searchStrings) {
        return StringUtils.startsWithAny(string, searchStrings);
    }

    /**
     * 检查字符串str的后缀是否为suffix
     * 
     * @param str 被检查的字符串
     * @param suffix 查找的后缀
     * @return boolean
     */
    public boolean endsWith(String str, String suffix) {
        return StringUtils.endsWith(str, suffix);
    }

    /**
     * 检查字符串str的后缀是否为suffix，不区分大小写
     * 
     * @param str 被检查的字符串
     * @param suffix 查找的后缀
     * @return boolean
     */
    public boolean endsWithIgnoreCase(String str, String suffix) {
        return StringUtils.endsWithIgnoreCase(str, suffix);
    }

    /**
     * 返回去掉了前导、尾随和重复的空白的参数字符串
     * 
     * @param str 被处理的字符串
     * @return String
     */
    public String normalizeSpace(String str) {
        return StringUtils.normalizeSpace(str);
    }

    /**
     * 检查字符串string的后缀是否为searchStrings中的任何一个，不区分大小写
     * 
     * @param string 被检查的字符串
     * @param searchStrings 查找的后缀
     * @return boolean
     */
    public boolean endsWithAny(String string, String[] searchStrings) {
        return StringUtils.endsWithAny(string, searchStrings);
    }

    /**
     * 如果字符串str不是以suffixes中任何一个结尾，那么在str后追加suffix
     * 当只有两个参数时（suffixes不存在），suffixes值即为suffix值
     * 
     * @param str 被处理的字符串
     * @param suffix 将要追加到str后的字符串
     * @param suffixes 用于判断的额外后缀
     * @return String
     */
    public String appendIfMissing(String str, String suffix, String[] suffixes) {
        return StringUtils.appendIfMissing(str, suffix, suffixes);
    }

    /**
     * 如果字符串str不是以suffixes中任何一个结尾，那么在str后追加suffix，不区分大小写
     * 当只有两个参数时（suffixes不存在），suffixes值即为suffix值
     * 
     * @param str 被处理的字符串
     * @param suffix 将要追加到str后的字符串
     * @param suffixes 用于判断的额外后缀（可选）
     * @return String
     */
    public String appendIfMissingIgnoreCase(String str, String suffix, String[] suffixes) {
        return StringUtils.appendIfMissingIgnoreCase(str, suffix, suffixes);
    }

    /**
     * 如果字符串str不是以prefixes中任何一个开始，那么在str前追加prefix，不区分大小写
     * 当只有两个参数时（prefixes不存在），prefixes值即为prefix值
     * 
     * @param str 被处理的字符串
     * @param prefix 将要追加到str前的字符串
     * @param prefixes 用于判断的额外后缀（可选）
     * @return String
     */
    public String prependIfMissing(String str, String prefix, String[] prefixes) {
        return StringUtils.prependIfMissing(str, prefix, prefixes);
    }

    /**
     * 如果字符串str不是以prefixes中任何一个开始，那么在str前追加prefix，不区分大小写
     * 当只有两个参数时（prefixes不存在），prefixes值即为prefix值 。忽略大小写
     * 
     * @param str 被处理的字符串
     * @param prefix 将要追加到str前的字符串
     * @param prefixes 用于判断的额外后缀（可选）
     * @return String
     */
    public String prependIfMissingIgnoreCase(String str, String prefix, String[] prefixes) {
        return StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
    }

    /**
     * 将字节数组按指定字符集生成字符串
     * 
     * @param bytes 用于生成字符串的字节数组
     * @param charset 用于编码的字符集，如果为null则使用平台默认编码
     * @return String
     */
    public String toEncodedString(byte[] bytes, Charset charset) {
        return StringUtils.toEncodedString(bytes, charset);
    }

    /**
     * 
     * @param str
     * @param wrapWith
     * @return
     */
    public String wrap(String str, char wrapWith) {
        return StringUtils.wrap(str, wrapWith);
    }

    /**
     * 
     * @param str
     * @param wrapWith
     * @return
     */
    public String wrap(String str, String wrapWith) {
        return StringUtils.wrap(str, wrapWith);
    }

    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

}
