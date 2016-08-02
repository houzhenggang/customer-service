package com.hshc.kfpub.comm;

/**
 * Excel文件处理工具类文件
 *
 * @title: ExcelUtil.java
 * @author 邢治理
 * @date 2016年2月24日 下午3:10:52
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Excel文件处理工具类，方法出现顺序规则：以方法名字母排序
 * 
 * @className ExcelUtil
 * @author 邢治理
 * @version V1.0 2016年2月24日 下午3:10:52
 * @since 2016年2月24日 下午3:10:52
 */
public final class ExcelUtil {

    // 在这里定义常量
    private final String ERR_EMPTY_STR = "参数异常，空字符串";
    private final String ERR_FILE_UNAVAILABLE = "参数异常，Excel文件不可用";
    private final String ERR_FILE_NO_EXCEL = "参数异常，不是Excel文件";
    private final String ERR_CLASS_NULL = "参数异常，Bean的Class对象为空";
    private final String ERR_RESOURCE_NULL = "参数异常，资源不存在";
    private final String ERR_COLUMN_NAME_NULL = "参数异常，每列命名与Bean属性名对应关系必须指定";
    private final String ERR_SHEET_NULL = "参数异常，sheet页为空";
    private final String ERR_PARAM_DIFF = "参数异常，指定的列数与列命名数不一致";
    private final String ERR_PARAM_NOT_MUST_COL = "参数异常，没有指定非空列序号";
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 解析Excel文件到集合，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 只解析sheet1
     * 
     * @param filePath 以.xls或.xlsx结尾文件的路径
     * @param startRowNo 解析开始行号
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<Map<String, String>>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，Map对应列数据库，key则为["column_1","column_2"...]
     * @author 邢治理
     * @since 2016年3月8日
     */
    public List<List<Map<String, String>>> parseFromFile(String filePath, int startRowNo, int[] notEmptyColumnNo) {

        if (StringUtils.isEmpty(filePath)) {
            throwException(ERR_EMPTY_STR);
        }
        return parseFromFile(new File(filePath), startRowNo, notEmptyColumnNo);
    }

    /**
     * 解析Excel文件到对象，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 只解析sheet1
     * 
     * @param filePath 以.xls或.xlsx结尾文件的路径
     * @param classz 承载每行数据的Bean的类对象
     * @param startRowNo 解析开始行号
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @param columnKeys 为解析的列命名，对应Bean中属性名，必须指定
     * @return List<List<T>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，其中T是参数classz类对象的实例
     * @author 邢治理
     * @since 2016年3月8日
     */
    public <T> List<List<T>> parseFromFile(String filePath, Class<T> classz, int startRowNo, int[] notEmptyColumnNo, String[] columnKeys) {

        if (StringUtils.isEmpty(filePath)) {
            throwException(ERR_EMPTY_STR);
        }
        return parseFromFile(new File(filePath), classz, startRowNo, notEmptyColumnNo, columnKeys);
    }

    /**
     * 解析Excel文件到集合，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 
     * @param filePath 以.xls或.xlsx结尾文件的路径
     * @param sheetNo 需要解析的sheet序号，比如：仅解析sheet1则为[1]或解析sheet1,sheet3则为[1,3]
     * @param startRowNo 解析开始行号
     * @param parseColumnNo 解析列的序号，如不指定，则从第1列开始解析所有可见列。若指定，则需从小到大顺序指定全部要解析的列号。如[1,3,4,5...]
     * @param columnKeys 为解析的列命名，对应返回值中Map的key，如果不指定，则key使用默认值["column_1","column_2"...]
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<Map<String, String>>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，Map对应列数据库
     * @author 邢治理
     * @since 2016年3月8日
     */
    public List<List<Map<String, String>>> parseFromFile(String filePath, int[] sheetNo, int startRowNo, int[] parseColumnNo, String[] columnKeys,
        int[] notEmptyColumnNo) {

        if (StringUtils.isEmpty(filePath)) {
            throwException(ERR_EMPTY_STR);
        }
        return parseFromFile(new File(filePath), sheetNo, startRowNo, parseColumnNo, columnKeys, notEmptyColumnNo);
    }

    /**
     * 解析Excel文件到对象，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 
     * @param filePath 以.xls或.xlsx结尾文件的路径
     * @param classz 承载每行数据的Bean的类对象
     * @param sheetNo 需要解析的sheet序号，比如：仅解析sheet1则为[1]或解析sheet1,sheet3则为[1,3]
     * @param startRowNo 解析开始行号
     * @param parseColumnNo 解析列的序号，如不指定，则从第1列开始解析所有可见列。若指定，则需从小到大顺序指定全部要解析的列号。如[1,3,4,5...]
     * @param columnKeys 为解析的列命名，对应Bean中属性名，必须指定
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<T>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，其中T是参数classz类对象的实例
     * @author 邢治理
     * @since 2016年3月8日
     */
    public <T> List<List<T>> parseFromFile(String filePath, Class<T> classz, int[] sheetNo, int startRowNo, int[] parseColumnNo, String[] columnKeys,
        int[] notEmptyColumnNo) {

        if (StringUtils.isEmpty(filePath)) {
            throwException(ERR_EMPTY_STR);
        }
        return parseFromFile(new File(filePath), classz, sheetNo, startRowNo, parseColumnNo, columnKeys, notEmptyColumnNo);
    }

    /**
     * 解析Excel文件到集合，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 只解析sheet1
     * 
     * @param excelFile 以.xls或.xlsx结尾文件对象
     * @param startRowNo 解析开始行号
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<Map<String, String>>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，Map对应列数据库
     * @author 邢治理
     * @since 2016年3月8日
     */
    public List<List<Map<String, String>>> parseFromFile(File excelFile, int startRowNo, int[] notEmptyColumnNo) {

        checkFile(excelFile);
        InputStream in = null;
        try {
            in = new FileInputStream(excelFile);
            return parseFromFile(in, startRowNo, notEmptyColumnNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            in = null;
        }
    }

    /**
     * 解析Excel文件到对象，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 只解析sheet1
     * 
     * @param excelFile 以.xls或.xlsx结尾文件对象
     * @param classz 承载每行数据的Bean的类对象
     * @param startRowNo 解析开始行号
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @param columnKeys 为解析的列命名，对应Bean中属性名，必须指定
     * @return List<List<T>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，其中T是参数classz类对象的实例
     * @author 邢治理
     * @since 2016年3月8日
     */
    public <T> List<List<T>> parseFromFile(File excelFile, Class<T> classz, int startRowNo, int[] notEmptyColumnNo, String[] columnKeys) {

        checkFile(excelFile);
        InputStream in = null;
        try {
            in = new FileInputStream(excelFile);
            return parseFromFile(in, classz, startRowNo, notEmptyColumnNo, columnKeys);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            in = null;
        }
    }

    /**
     * 解析Excel文件到集合，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 
     * @param excelFile 以.xls或.xlsx结尾文件对象
     * @param sheetNo 需要解析的sheet序号，比如：仅解析sheet1则为[1]或解析sheet1,sheet3则为[1,3]
     * @param startRowNo 解析开始行号
     * @param parseColumnNo 解析列的序号，如不指定，则从第1列开始解析所有可见列。若指定，则需从小到大顺序指定全部要解析的列号。如[1,3,4,5...]
     * @param columnKeys 为解析的列命名，对应返回值中Map的key，如果不指定，则key使用默认值["column_1","column_2"...]
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<Map<String, String>>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，Map对应列数据库
     * @author 邢治理
     * @since 2016年3月8日
     */
    public List<List<Map<String, String>>> parseFromFile(File excelFile, int[] sheetNo, int startRowNo, int[] parseColumnNo, String[] columnKeys,
        int[] notEmptyColumnNo) {

        checkFile(excelFile);
        InputStream in = null;
        try {
            in = new FileInputStream(excelFile);
            return this.parseFromFile(in, sheetNo, startRowNo, parseColumnNo, columnKeys, notEmptyColumnNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            in = null;
        }
    }

    /**
     * 解析Excel文件到对象，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 
     * @param excelFile 以.xls或.xlsx结尾文件对象
     * @param classz 承载每行数据的Bean的类对象
     * @param sheetNo 需要解析的sheet序号，比如：仅解析sheet1则为[1]或解析sheet1,sheet3则为[1,3]
     * @param startRowNo 解析开始行号
     * @param parseColumnNo 解析列的序号，如不指定，则从第1列开始解析所有可见列。若指定，则需从小到大顺序指定全部要解析的列号。如[1,3,4,5...]
     * @param columnKeys 为解析的列命名，对应Bean中属性名，必须指定
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<T>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，其中T是参数classz类对象的实例
     * @author 邢治理
     * @since 2016年3月8日
     */
    public <T> List<List<T>> parseFromFile(File excelFile, Class<T> classz, int[] sheetNo, int startRowNo, int[] parseColumnNo, String[] columnKeys,
        int[] notEmptyColumnNo) {

        checkFile(excelFile);
        InputStream in = null;
        try {
            in = new FileInputStream(excelFile);
            return parseFromFile(in, classz, sheetNo, startRowNo, parseColumnNo, columnKeys, notEmptyColumnNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            in = null;
        }
    }

    /**
     * 解析Excel文件到集合，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 只解析sheet1
     * 
     * @param in 以.xls或.xlsx结尾文件的读取字节流
     * @param startRowNo 解析开始行号
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<Map<String, String>>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，Map对应列数据库
     * @author 邢治理
     * @since 2016年3月7日
     */
    public List<List<Map<String, String>>> parseFromFile(InputStream in, int startRowNo, int[] notEmptyColumnNo) {
        return parseFromFile(in, new int[] {1}, startRowNo, new int[] {}, new String[] {}, notEmptyColumnNo);
    }

    /**
     * 解析Excel文件到对象，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 只解析sheet1
     * 
     * @param in 以.xls或.xlsx结尾文件的读取字节流
     * @param classz 承载每行数据的Bean的类对象
     * @param startRowNo 解析开始行号
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @param columnKeys 为解析的列命名，对应Bean中属性名，必须指定
     * @return List<List<T>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，其中T是参数classz类对象的实例
     * @author 邢治理
     * @since 2016年3月8日
     */
    public <T> List<List<T>> parseFromFile(InputStream in, Class<T> classz, int startRowNo, int[] notEmptyColumnNo, String[] columnKeys) {
        return parseFromFile(in, classz, new int[] {1}, startRowNo, new int[] {}, columnKeys, notEmptyColumnNo);
    }

    /**
     * 解析Excel文件到集合，支持.xls和.xlsx格式文件，支持部分列解析，如果其中一个解析出错，整个解析视为失败
     * 提示：如果解析不符合预期，请调整你的Excel模板，如单元格值格式为字符串类型等
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 
     * @param in 以.xls或.xlsx结尾文件的读取字节流
     * @param sheetNo 需要解析的sheet序号，比如：仅解析sheet1则为[1]或解析sheet1,sheet3则为[1,3]
     * @param startRowNo 解析开始行号
     * @param parseColumnNo 解析列的序号，如不指定，则从第1列开始解析所有可见列。若指定，则需从小到大顺序指定全部要解析的列号。如[1,3,4,5...]
     * @param columnKeys 为解析的列命名，对应返回值中Map的key，如果不指定，则key使用默认值["column_1","column_2"...]
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<Map<String, String>>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，Map对应列数据库
     * @author 邢治理
     * @since 2016年3月7日
     */
    public List<List<Map<String, String>>> parseFromFile(InputStream in, int[] sheetNo, int startRowNo, int[] parseColumnNo, String[] columnKeys,
        int[] notEmptyColumnNo) {

        // 检测读取流
        if (in == null) {
            throwException(ERR_RESOURCE_NULL);
        }
        // 检查待解析sheet序号
        if (sheetNo.length < 1) {
            throwException(ERR_SHEET_NULL);
        }
        // 检查指定列的数量与变量命名的数量是否一致，如果存在
        if (parseColumnNo.length > 0 && columnKeys.length > 0 && parseColumnNo.length != columnKeys.length) {
            throwException(ERR_PARAM_DIFF);
        }
        // 检查是否指定了非空列
        if (notEmptyColumnNo.length < 1) {
            throwException(ERR_PARAM_NOT_MUST_COL);
        }

        List<List<Map<String, String>>> retList = new ArrayList<List<Map<String, String>>>();
        Workbook wb = null;
        try {
            wb = createWorkbook(in);
            // 遍历sheet页数据
            for (int s = 0; s < wb.getNumberOfSheets(); s++) {
                if (!containsElement(sheetNo, s + 1)) {
                    continue;
                }
                // 抽取Sheet页数据
                List<Map<String, String>> tmp = getDataSheet(wb.getSheetAt(s), startRowNo, parseColumnNo, columnKeys, notEmptyColumnNo);
                if (tmp != null && tmp.size() > 0) {
                    retList.add(tmp);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (wb != null) try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retList;
    }

    /**
     * 解析Excel文件到对象，支持.xls和.xlsx格式文件
     * Sheet序号，Row序号，Column序号都从1开始，隐藏的行、列不会被解析
     * 只解析sheet1
     * 
     * @param in 以.xls或.xlsx结尾文件的读取字节流
     * @param classz 承载每行数据的Bean的类对象
     * @param sheetNo 需要解析的sheet序号，比如：仅解析sheet1则为[1]或解析sheet1,sheet3则为[1,3]
     * @param startRowNo 解析开始行号
     * @param parseColumnNo 解析列的序号，如不指定，则从第1列开始解析所有可见列。若指定，则需从小到大顺序指定全部要解析的列号。如[1,3,4,5...]
     * @param columnKeys 为解析的列命名，对应Bean中属性名，必须指定
     * @param notEmptyColumnNo 非空值列的序号，至少指定一个非空值列序号。在解析过程中，如果指定列的值为空，则视为空行跳过
     * @return List<List<T>> 最外层List一个元素对应一个sheet页数据，内层List一个元素对应一行数据，其中T是参数classz类对象的实例
     * @author 邢治理
     * @since 2016年3月8日
     */
    public <T> List<List<T>> parseFromFile(InputStream in, Class<T> classz, int[] sheetNo, int startRowNo, int[] parseColumnNo, String[] columnKeys,
        int[] notEmptyColumnNo) {

        // 参数check
        if (classz == null) {
            throwException(ERR_CLASS_NULL);
        }
        if (columnKeys.length < 1) {
            throwException(ERR_COLUMN_NAME_NULL);
        }

        List<T> rowData = null;
        T obj = null;
        List<Map<String, String>> row = null;
        List<List<T>> retList = new ArrayList<List<T>>();

        // 获取excel文件数据
        List<List<Map<String, String>>> data = parseFromFile(in, sheetNo, startRowNo, parseColumnNo, columnKeys, notEmptyColumnNo);
        if (data != null && !data.isEmpty()) {
            // 遍历sheet页
            for (int s = 0; s < data.size(); s++) {
                row = data.get(s);
                if (row != null && !row.isEmpty()) {
                    rowData = new ArrayList<T>();
                    // 遍历行
                    for (int r = 0; r < row.size(); r++) {
                        obj = U.BEAN.toBean(row.get(r), classz);
                        if (obj != null) {
                            rowData.add(obj);
                        }
                    }
                    if (rowData.size() > 0) {
                        retList.add(rowData);
                    }
                }
            }
        }
        return retList;
    }

    /**
     * 设置Excel中一行的值
     * 
     * @param row 行
     * @param rowData 行数据
     * @param order 指定列出现顺序,遍历order作为key从rowData中取值
     * @author 吴挡
     * @since 2016年3月9日
     */
    private void setRowValue(Row row, Map<String, Object> rowData, List<String> order) {
        List<Object> value = new ArrayList<Object>();
        // order为null或空时
        if (order == null || order.isEmpty()) {
            value.addAll(rowData.values());
        } else {
            // 按照order顺序
            for (int i = 0; i < order.size(); i++) {
                value.add(rowData.get(order.get(i)));
            }
        }
        this.setRowValue(row, value);
    }

    /**
     * 设置Excel中一行的值
     * 
     * @param row 行
     * @param value 行数据
     * @author 吴挡
     * @since 2016年3月9日
     */
    private void setRowValue(Row row, List<?> value) {
        if (row == null || value == null || value.isEmpty()) {
            return;
        }
        for (int i = 0; i < value.size(); i++) {
            Cell cell = row.createCell(i);
            this.setCellValue(cell, value.get(i));
        }

    }

    /**
     * 设置excel单元格的值
     * 
     * @param cell 单元格
     * @param value 值 仅支持基本数据类型及其包装类,或String,Date,Calendar
     * @author 吴挡
     * @since 2016年3月9日
     */
    private void setCellValue(Cell cell, Object value) {
        if (cell == null || value == null) {
            return;
        }
        if (String.class.isInstance(value)) {
            // 字符串
            cell.setCellValue(String.class.cast(value));

        } else if (Byte.class.isInstance(value)) {
            // byte
            cell.setCellValue(Byte.class.cast(value));

        } else if (Short.class.isInstance(value)) {
            // short
            cell.setCellValue(Short.class.cast(value));

        } else if (Integer.class.isInstance(value)) {
            // int
            cell.setCellValue(Integer.class.cast(value));

        } else if (Long.class.isInstance(value)) {
            // long
            cell.setCellValue(Long.class.cast(value));

        } else if (Float.class.isInstance(value)) {
            // float 因精度问题,需要对float转换为double再写入cell
            cell.setCellValue(Double.valueOf(value.toString()));

        } else if (Double.class.isInstance(value)) {
            // double
            cell.setCellValue(Double.class.cast(value));

        } else if (Boolean.class.isInstance(value)) {
            // boolean
            cell.setCellValue(Boolean.class.cast(value));

        } else if (Character.class.isInstance(value)) {
            // char
            cell.setCellValue(value.toString());

        } else if (Date.class.isInstance(value)) {
            // 日期型

            cell.setCellValue(sdf.format(Date.class.cast(value)));
        } else if (Calendar.class.isInstance(value)) {
            // 日期型
            cell.setCellValue(sdf.format(Calendar.class.cast(value).getTime()));
        } else {
            cell.setCellValue(value.toString());
        }
    }

    /**
     * 生成Excel格式数据
     * 
     * @param source 数据源
     * @param columnKeys 为解析的列命名，对象Bean的属性名
     * @param filePath 目标文件路径
     * @param header 指定列标题，传null或空集合时，不生成列标题
     * @param order 指定列出现顺序，值为classz的属性，仅支持java基本数据类型，传null或空集合时，视为不指定列顺序
     * @author 吴挡
     * @since 2016年3月9日
     */
    public <T> void toExcel(List<T> source, String filePath, List<String> header, List<String> order) {
        File file = new File(filePath);
        FileOutputStream fos = null;

        try {
            // 文件所在文件夹的不存在需要先生成文件夹
            U.FILE.forceMkdir(file.getParentFile());
            fos = new FileOutputStream(filePath);
            this.toExcel(source, fos, header, order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成Excel格式数据
     * 
     * @param source 数据源
     * @param columnKeys 为解析的列命名，对象Bean的属性名
     * @param file 目标文件对象
     * @param header 指定列标题，传null或空集合时，不生成列标题
     * @param order 指定列出现顺序，值为classz的属性，仅支持java基本数据类型，传null或空集合时，视为不指定列顺序
     * @author 吴挡
     * @since 2016年3月9日
     */
    public <T> void toExcel(List<T> source, File targetFile, List<String> header, List<String> order) {

        FileOutputStream fos = null;
        try {
            // 文件所在文件夹的不存在需要先生成文件夹
            U.FILE.forceMkdir(targetFile.getParentFile());
            fos = new FileOutputStream(targetFile);
            this.toExcel(source, fos, header, order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成Excel格式数据
     * 
     * @param source 数据源
     * @param columnKeys 为解析的列命名，对象Bean的属性名
     * @param output 目标文件写入字节流
     * @param header 指定列标题，传null或空集合时，不生成列标题
     * @param order 指定列出现顺序，值为classz的属性，仅支持java基本数据类型，传null或空集合时，视为不指定列顺序
     * @author 吴挡
     * @since 2016年3月9日
     */
    public <T> void toExcel(List<T> source, OutputStream output, List<String> header, List<String> order) {
        List<Map<String, Object>> objSource = new ArrayList<>(source.size());
        for (T s : source) {
            objSource.add(U.BEAN.toMap(s));
        }
        Workbook wb = null;
        try {
            wb = this.createWorkbook(null);
            // 数据都写在第一个sheet中,sheet名称用默认名称
            Sheet sheet = wb.createSheet();

            // 数据写入开始行
            int startRowIndex = 0;
            // 标题列
            if (header != null && !header.isEmpty()) {
                Row row = sheet.createRow(startRowIndex);
                this.setRowValue(row, header);
                startRowIndex++;
            }
            // 数据列
            for (Map<String, Object> rowData : objSource) {
                Row row = sheet.createRow(startRowIndex);
                this.setRowValue(row, rowData, order);
                startRowIndex++;
            }
            // excel工作簿写入输出流中
            wb.write(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (wb != null) try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 抛异常
    private void throwException(String errMsg) {
        throw new RuntimeException(errMsg);
    }

    // 检查Excel文件合法性
    private void checkFile(File file) {
        if (file == null || !file.exists() || file.isDirectory()) {
            throwException(ERR_FILE_UNAVAILABLE);
        }
        if (!file.getName().endsWith(".xls") && !file.getName().endsWith(".xlsx")) {
            throwException(ERR_FILE_NO_EXCEL);
        }
    }

    // 当数组arr中只要有一个元素与指定的target相等时，返回 true
    private boolean containsElement(int[] arr, int target) {
        if (arr.length < 1) {
            return false;
        }
        boolean isContain = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    // 创建Workbook对象
    private Workbook createWorkbook(InputStream in) throws Exception {
        if (in == null) {
            return new HSSFWorkbook();
        }
        return WorkbookFactory.create(in);
    }

    // 解析sheet页数据
    private List<Map<String, String>> getDataSheet(Sheet sheet, int startRowNo, int[] parseColumnNo, String[] columnKeys, int[] notEmptyColumnNo)
        throws Exception {

        List<Map<String, String>> retList = new ArrayList<Map<String, String>>();
        Row row = null;

        if (startRowNo < 1) {
            startRowNo = 1;
        }
        // 遍历row
        for (int r = (startRowNo - 1); r <= sheet.getLastRowNum(); r++) {
            row = sheet.getRow(r);

            // 空行跳过
            if (row == null) {
                continue;
            }

            // 如果是隐藏行，则跳过
            if (row.getZeroHeight()) {
                continue;
            }
            // 必填列数据为空，则跳过
            boolean iskip = false;
            for (int n = 0; n < notEmptyColumnNo.length; n++) {
                Cell cell = row.getCell(notEmptyColumnNo[n] - 1);
                if (StringUtils.isEmpty(getDataCell(cell))) {
                    iskip = true;
                    break;
                }
            }
            if (!iskip) {
                // 抽取行数据
                Map<String, String> tmp = getDataRow(row, parseColumnNo, columnKeys);
                if (tmp != null && tmp.size() > 0) {
                    retList.add(tmp);
                }
            }
        }
        return retList.size() > 0 ? retList : null;
    }

    // 解析行数据
    private Map<String, String> getDataRow(Row row, int[] parseColumnNo, String[] columnKeys) throws Exception {
        Cell cell = null;
        String key = null;
        int parsedIndex = 1;
        Map<String, String> retMap = new HashMap<String, String>();
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            cell = row.getCell(i);
            // 如果是隐藏列，就跳过
            if (cell.getCellStyle().getHidden()) {
                continue;
            }
            // 如果不是指定的解析列就跳过
            if (parseColumnNo.length > 0 && !containsElement(parseColumnNo, i + 1)) {
                continue;
            }

            key = "column_" + parsedIndex;
            // 如果指定了key，则使用指定值为key
            if (columnKeys.length > 0 && parsedIndex <= columnKeys.length) {
                key = columnKeys[parsedIndex - 1];
            }
            parsedIndex++;

            retMap.put(key, getDataCell(cell));
        }

        return retMap.size() > 0 ? retMap : null;
    }

    // 解析列数据
    private String getDataCell(Cell cell) {
        int cellType = cell.getCellType();
        String cellValue = null;
        switch (cellType) {
            case Cell.CELL_TYPE_STRING: // 文本
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC: // 数字、日期
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = sdf.format(cell.getDateCellValue()); // 日期型
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue()); // 数字
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN: // 布尔型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK: // 空白
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_ERROR: // 错误
                cellValue = "错误";
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = "错误";
                break;
            default:
                cellValue = "错误";
        }
        return cellValue;
    }
}
