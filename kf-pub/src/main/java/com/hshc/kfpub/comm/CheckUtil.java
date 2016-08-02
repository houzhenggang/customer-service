/**
 * 验证相关工具类
 * 
 * @title: CheckUtil.java
 * @author 邢治理
 * @date 2016年3月7日 下午3:29:36
 */
package com.hshc.kfpub.comm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 验证相关工具类
 * 
 * @className CheckUtil
 * @author 邢治理
 * @version V1.0 2016年3月7日
 */
public final class CheckUtil {

    /**
     * 手机号码正则表达式
     * 匹配以13、15、18开头的号码
     * 如：13012345678、15929224344、18001234676
     */
    private final String regMobile = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    /**
     * Email地址的正则表达式
     */
    private final String regEmail = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
    /**
     * 国内固定电话号码的正则表达式
     * 匹配形式如 0511-4405222 或 021-87888822
     */
    private final String regPhone = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
    /**
     * 日期格式的正则表达式
     * 匹配形式如 2016-03-14
     */
    private final String regDate =
        "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
    /**
     * 日期格式的正则表达式
     * 匹配形式如 2016/03/14
     */
    private final String regDate2 =
        "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})/(((0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)/(0[1-9]|[12][0-9]|30))|(02/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))/02/29)";
    /**
     * 日期格式的正则表达式
     * 匹配形式如 20160314
     */
    private final String regDate3 =
        "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)";
    /**
     * 日期格式的正则表达式
     * 匹配形式如 2016/3/4
     */
    private final String regDate4 =
        "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})/((([13578]|1[02])/([1-9]|[12][0-9]|3[01]))|(([469]|11)/([1-9]|[12][0-9]|30))|(2/([1-9]|1[0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))/2/29)";
    /**
     * 日期格式的正则表达式
     * 匹配形式如 2016-3-4
     */
    private final String regDate5 =
        "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-((([13578]|1[02])-([1-9]|[12][0-9]|3[01]))|(([469]|11)-([1-9]|[12][0-9]|30))|(2-([1-9]|1[0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-2-29)";
    /**
     * 日期时间格式的正则表达式
     * 匹配形式如 2016-03-14 12:00:12
     */
    private final String regDateTime =
        "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)) (([01][0-9]|2[0-4]):[0-6][0-9]:[0-6][0-9])";
    /**
     * 日期时间格式的正则表达式
     * 匹配形式如 2016/03/14 12:00:12
     */
    private final String regDateTime2 =
        "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})/(((0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)/(0[1-9]|[12][0-9]|30))|(02/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))/02/29)) (([01][0-9]|2[0-4]):[0-6][0-9]:[0-6][0-9])";
    /**
     * 日期时间格式的正则表达式
     * 匹配形式如 20160314120012
     */
    private final String regDateTime3 =
        "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))(([01][0-9]|2[0-4])[0-6][0-9][0-6][0-9])";
    /**
     * 日期时间格式的正则表达式
     * 匹配形式如 2016-3-14 13:0:12
     */
    private final String regDateTime4 =
        "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})/((([13578]|1[02])/([1-9]|[12][0-9]|3[01]))|(([469]|11)/([1-9]|[12][0-9]|30))|(2/([1-9]|1[0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))/2/29)) ((1?[0-9]|2[0-4]):[1-6]?[0-9]:[1-6]?[0-9])";
    /**
     * 日期时间格式的正则表达式
     * 匹配形式如 2016/3/14 13:0:12
     */
    private final String regDateTime5 =
        "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-((([13578]|1[02])-([1-9]|[12][0-9]|3[01]))|(([469]|11)-([1-9]|[12][0-9]|30))|(2-([1-9]|1[0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-2-29)) ((1?[0-9]|2[0-4]):[1-6]?[0-9]:[1-6]?[0-9])";

    /**
     * 15位身份证号日期格式的正则表达式
     * 匹配形式如 860314
     */
    private final String regIdCar15Date =
        "([0-9]{2}(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((0[48]|[2468][048]|[13579][26])0229)";
    /**
     * 18位身份证号日期格式的正则表达式
     * 匹配形式如 20160314
     */
    private final String regIdCar18Date = regDate3;
    /**
     * 18位身份证号加权因子
     */
    private final int[] idCardPowers = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    /**
     * 18位身份证号校验码字符值
     */
    private final char[] idCardParityBit = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 判断是否为数值字符串<br>
     * 匹配合法的数值,如 1, -1, 0.1, .1(0.1), -.1(-0.1)
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月11日
     */
    public boolean isNum(String str) {

        return NumberUtils.isNumber(str);
    }

    /**
     * 判断是否为日期字符串
     * <li>yyyy-MM-dd
     * <li>yyyy/MM/dd
     * <li>yyyyMMdd
     * <li>yyyy-M-d
     * <li>yyyy/M/d
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    public boolean isDate(String str) {
        return this.regexCheck(str, regDate) || this.regexCheck(str, regDate2) || this.regexCheck(str, regDate3) || this.regexCheck(str, regDate4)
            || this.regexCheck(str, regDate5);
    }

    /**
     * 判断是否为日期时间字符串
     * <li>yyyy-MM-dd HH:mm:ss
     * <li>yyyy/MM/dd HH:mm:ss
     * <li>yyyyMMddHHmmss
     * <li>yyyy-M-d H:m:s
     * <li>yyyy/M/d H:m:s
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    public boolean isDateTime(String str) {
        return this.regexCheck(str, regDateTime) || this.regexCheck(str, regDateTime2) || this.regexCheck(str, regDateTime3)
            || this.regexCheck(str, regDateTime4) || this.regexCheck(str, regDateTime5);
    }

    /**
     * 判断是否为身份证，支持15位和18位格式<BR>
     * 18位身份证校验第18位特征码
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    public boolean isIdCard(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 15) {
            return this.isIdCard15(str);
        }
        if (str.length() == 18) {
            return this.isIdCard18(str);
        }
        return false;
    }

    /**
     * 判断是否为15位身份证
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    private boolean isIdCard15(String str) {
        // 15位身份证号为纯数字的
        if (!NumberUtils.isDigits(str)) {
            return false;
        }
        // 第7~13位为生日,做6位日期验证
        if (!this.regexCheck(str.substring(6, 12), regIdCar15Date)) {
            return false;
        }

        return true;
    }

    /**
     * 判断是否为18位身份证
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    private boolean isIdCard18(String str) {
        String idCard17 = str.substring(0, 17);
        char bit = Character.toUpperCase(str.charAt(17));
        // 18位身份证号的前17位为纯数字的
        if (!NumberUtils.isDigits(idCard17)) {
            return false;
        }
        // 第7~15位为生日,做8位日期验证
        if (!this.regexCheck(str.substring(6, 14), regIdCar18Date)) {
            return false;
        }
        // 18位身份证号的第17位为数字或'X'
        if (!((bit >= '0' && bit <= '9') || bit == 'X')) {
            return false;
        }
        // 算出身份证号的校验位
        char parityBit = this.getIdCardParityBit(str);
        // 校验位验证
        return parityBit == bit;
    }

    /**
     * 根据18位身份证号前17位计算出第18位的值
     * 
     * @param str 18位身份证号
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    private char getIdCardParityBit(String str) {
        char[] idChar17 = str.substring(0, 17).toCharArray();
        int power = 0;
        for (int i = 0; i < 17; i++) {
            power += this.idCardPowers[i] * (idChar17[i] - '0');
        }
        return this.idCardParityBit[power % 11];
    }

    /**
     * 判断是否为邮箱
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    public boolean isEmail(String str) {
        return this.regexCheck(str, regEmail);
    }

    /**
     * 判断是否为银行卡号<BR>
     * 支持16位、19位银行卡号的校验<BR>
     * 银行卡号最后一位为Luhm校验位
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    public boolean isBankNo(String str) {
        if (!NumberUtils.isDigits(str)) {
            return false;
        }
        if (str.length() != 16 && str.length() != 19) {
            return false;
        }
        char bit = getBankNoCheckCode(str.substring(0, str.length() - 1));
        return str.charAt(str.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位<BR>
     * <li>1，将未带校验位的 15 位卡号从右依次编号 1 到 15，位于奇数位号上的数字乘以 2
     * <li>2，将奇位乘积的个十位全部相加，再加上所有偶数位上的数字
     * <li>3，将加法和加上校验位能被 10 整除。
     * 
     * @param nonCheckCodeBankNo 不带校验位的银行卡号
     * @return 校验位
     */
    private char getBankNoCheckCode(String nonCheckCodeBankNo) {

        char[] chs = nonCheckCodeBankNo.trim().toCharArray();

        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * 判断是否为固话号<BR>
     * 匹配形式如 0511-4405222 或 021-87888822
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月14日
     */
    public boolean isPhoneNo(String str) {

        return this.regexCheck(str, regPhone);
    }

    /**
     * 判断是否为手机号码<BR>
     * 支持13,15,18开头的手机号码
     * 
     * @param str 待验证字符串
     * @return
     * @author 邢治理
     * @since 2016年3月11日
     */
    public boolean isMobileNo(String str) {

        return this.regexCheck(str, regMobile);
    }

    /**
     * 检验字符串<CODE>str</CODE>是否匹配正则表达式<CODE>regex</CODE>
     * 
     * @param regex 正则表达式字符串
     * @param str 待验证的字符串
     * @return
     * @author 邢治理
     * @since 2016年3月11日
     */
    public boolean regexCheck(String str, String regex) {
        if (regex == null || str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
