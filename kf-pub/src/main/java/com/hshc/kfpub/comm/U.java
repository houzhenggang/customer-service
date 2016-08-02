package com.hshc.kfpub.comm;

/**
 * 此类为工具类，为编程人员提供快速开发支持，使用方法：
 * if(Utils.STR.isNotEmpty(string)){
 * ...
 * }
 * 依赖第三方Jar包如下：
 * common-lang3-3.4.jar
 * common-math3-3.6.jar
 * commons-io-2.4.jar
 * commons-codec-1.10.jar
 * commons-email-1.4.jar
 * poi-3.13.jar
 * poi-ooxml-3.13.jar
 * poi-ooxml-schemas-3.13.jar
 * jackson-core-2.1.0.jar
 * jackson-databind-2.1.0.jar
 * 
 * @className Utils
 * @author 邢治理
 * @version V1.0 2016年2月24日 下午1:57:29
 */
public final class U {

    private U() {
        // 禁止构造
    }

    // Bean工具类
    public static BeanUtil BEAN = new BeanUtil();
    // 字符工具类
    public static StringUtil STR = new StringUtil();

    // 数值工具类
    public static NumberUtil NUM = new NumberUtil();

    // 日期工具类
    public static DateUtil DATE = new DateUtil();

    // 文件工具类
    public static FileUtil FILE = new FileUtil();

    // XML文件工具类
    // public static XmlUtil XML = new XmlUtil();

    // Excel文件工具类
    public static ExcelUtil EXL = new ExcelUtil();

    // Json工具
    public static JsonUtil JSON = new JsonUtil();

    // Check工具

    public static CheckUtil CHK = new CheckUtil();

    // 加解密工具
    public static CodecUtil CC = new CodecUtil();

}
