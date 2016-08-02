package com.hshc.kfpub.comm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON转换工具类，方法出现顺序规则：以方法名字母排序
 * 
 * @className ToJsonUtil
 * @author 邢治理
 * @version V1.0 2016年2月24日 下午3:07:19
 */
public final class JsonUtil {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将对象转换为json字符串，其中日期对象转换成yyyy-MM-dd HH:mm:ss
     * 
     * @param obj 需要转换的对象（可以为List|Map|Array|Bean）
     * @return string
     * @author 邢治理
     * @since 2016年3月4日
     */
    public String toJson(Object obj) {
        try {
            return new ObjectMapper().setDateFormat(sdf).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象转换为json字符串
     * 
     * @param obj 需要转换的对象（可以为List|Map|Array|Bean）
     * @param dateFormat 日期格式
     * @return string
     * @author 邢治理
     * @since 2016年3月4日
     */
    public String toJson(Object obj, String dateFormat) {
        try {
            return new ObjectMapper().setDateFormat(U.STR.isEmpty(dateFormat) ? sdf : new SimpleDateFormat(dateFormat)).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 单引号版JSON串
     * 
     * @param obj 需要转换的对象（可以为List|Map|Array|Bean）
     * @return string
     * @param dateFormat 日期格式
     * @author 邢治理
     * @since 2016年4月8日
     */
    public String toJsonForSingleQuote(Object obj, String dateFormat) {
        String str;
        try {
            str = new ObjectMapper().setDateFormat(U.STR.isEmpty(dateFormat) ? sdf : new SimpleDateFormat(dateFormat)).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        str = str.replace("\"", "\'");
        return str;
    }

    /**
     * 把json字符串转换为Bean对象
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @param classz Bean的类对象，不能为集合
     * @return T
     * @author 邢治理
     * @since 2016年3月11日
     */
    public <T> T toBean(String jsonStr, String dateFormat, Class<T> classz) {
        try {
            return new ObjectMapper().setDateFormat(U.STR.isEmpty(dateFormat) ? sdf : new SimpleDateFormat(dateFormat)).readValue(jsonStr, classz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把json字符串转换为Bean对象列表
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @param classz Bean的类对象，不能为集合
     * @return List<T>
     * @author 邢治理
     * @since 2016年3月11日
     */
    public <T> List<T> toBeanList(String jsonStr, String dateFormat, Class<T> classz) {
        try {
            return new ObjectMapper().setDateFormat(U.STR.isEmpty(dateFormat) ? sdf : new SimpleDateFormat(dateFormat)).readValue(jsonStr,
                new TypeReference<List<T>>() {
                });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把json字符串转换为纯Map<String, Object>对象
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @return Map<String, Object>
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Map<String, Object> toMap(String jsonStr, String dateFormat) {
        Map<?, ?> jsonMap = this.toBean(jsonStr, dateFormat, Map.class);
        Map<String, Object> map = new HashMap<String, Object>(jsonMap.size());

        for (Map.Entry<?, ?> entry : jsonMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            map.put(U.STR.toString(key), value);
        }

        return map;
    }

    /**
     * 把json字符串转换为纯Map对象
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @param map 如果为null，则创建
     * @return Map<String, String>
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Map<String, String> toMap(String jsonStr, String dateFormat, Map<String, String> map) {
        Map<?, ?> jsonMap = this.toBean(jsonStr, dateFormat, Map.class);
        if (map == null) {
            map = this.convertMap(jsonMap);
        } else {
            map.putAll(this.convertMap(jsonMap));
        }

        return map;

    }

    /**
     * 把key,value类型未指定的map转换为key,value类型为String的map
     * 
     * @param source 原map
     * @return Map<String, String>
     * @author 邢治理
     * @since 2016年3月11日
     */
    private Map<String, String> convertMap(Map<?, ?> source) {
        if (source == null || source.size() == 0) {
            return new HashMap<>();
        }
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<?, ?> entry : source.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            map.put(U.STR.toString(key), U.STR.toString(value));
        }
        return map;
    }

    /**
     * 把json字符串转换为MapMap对象<BR>
     * json中顶层基本属性将被舍弃<BR>
     * 如{a:M,b:{c:N,d:P}} 转为MapMap后 属性a被舍弃
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @param map 如果为null，则创建
     * @return Map<String,Map<String,String>>
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Map<String, Map<String, String>> toMapMap(String jsonStr, String dateFormat, Map<String, Map<String, String>> map) {
        Map<?, ?> jsonMap = this.toBean(jsonStr, dateFormat, Map.class);
        if (map == null) {
            map = new HashMap<>();
        }
        for (Map.Entry<?, ?> entry : jsonMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            // key value 均为null时
            if (key == null && value == null) {
                // map.put(null, null);
                continue;
            }
            // value为null 或value不为map类型
            if (value == null || !(value instanceof Map)) {
                // map.put(key.toString(), null);
                continue;
            }

            String keyStr = null;
            if (key != null) {
                keyStr = key.toString();
            }
            map.put(keyStr, this.convertMap((Map<?, ?>) value));

        }

        return map;

    }

    /**
     * 把json字符串转换为Map对象
     * 其中Map的value为[String|List<String>]之一
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @param map 如果为null，则创建
     * @return Map<String, Object>
     * @author 邢治理
     * @since 2016年3月11日
     */
    public Map<String, Object> toMapList(String jsonStr, String dateFormat, Map<String, Object> map) {
        Map<String, Object> jsonMap = this.toMap(jsonStr, dateFormat);
        if (map == null) {
            map = new HashMap<>();
        }
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            // 值为集合时转为List<String>
            if (value != null && value instanceof Collection) {
                Collection<?> coll = (Collection<?>) value;
                List<String> list = new ArrayList<>(coll.size());
                for (Object obj : coll) {
                    list.add(U.STR.toString(obj));
                }
                map.put(key, list);

            } else {
                // 值不为集合时组转为String
                map.put(key, U.STR.toString(value));
            }

        }

        return map;
    }

    /**
     * 把json字符串转换为纯List对象
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @param list 如果为null，则创建
     * @return List<String>
     * @author 邢治理
     * @since 2016年3月11日
     */
    public List<String> toList(String jsonStr, String dateFormat, List<String> list) {
        List<String> jsonList = this.toBeanList(jsonStr, dateFormat, String.class);
        if (list == null) {
            list = jsonList;
        } else {
            list.addAll(jsonList);
        }

        return list;
    }

    /**
     * 把json字符串转换为List对象
     * 
     * @param jsonStr
     * @param dateFormat 日期格式
     * @param list 如果为null，则创建
     * @return List<Map<String, String>>
     * @author 邢治理
     * @since 2016年3月11日
     */
    public List<Map<String, String>> toListMap(String jsonStr, String dateFormat, List<Map<String, String>> list) {
        List<?> jsonList = this.toBean(jsonStr, dateFormat, List.class);
        if (list == null) {
            list = new ArrayList<>(jsonList.size());
        }
        for (Object v : jsonList) {
            if (v != null && v instanceof Map) {
                list.add(this.convertMap((Map<?, ?>) v));
            }
        }

        return list;
    }

}
