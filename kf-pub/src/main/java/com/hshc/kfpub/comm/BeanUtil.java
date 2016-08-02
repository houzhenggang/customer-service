package com.hshc.kfpub.comm;

import java.util.HashMap;
import java.util.Map;

/**
 * 对象处理工具类文件
 *
 * @className BeanUtil
 * @author 邢治理
 * @version V1.0 2016年3月9日 下午5:10:00
 */
public class BeanUtil {

    /**
     * 创建指定类型的对象,并把map中数据装载进去<br>
     * 限制:map中value的类型必须和Bean中对应的属性类型一致
     * 
     * @param map 含有数据的map
     * @param classz 新建对象类型
     * @return 对象
     * @author 邢治理
     * @since 2016年3月9日
     */
    public <T> T toBeanFast(Map<String, ?> map, Class<T> classz) {
        T target;
        try {
            target = classz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BeanMap beanMap = BeanMap.create(target);
        beanMap.putAll(map);
        return target;
    }

    /**
     * 创建指定类型的对象,并把map中数据装载进去<br>
     * unchecked:对象的属性为非基本类型且map中同名key对应的值的类型为map时,递归调用生成子对象<br>
     * 可把Map中String类型数据转换为bean需要的 基本数据类型及其包装类
     * 
     * @param map 含有数据的map
     * @param classz 新建对象类型
     * @return 对象
     * @author 邢治理
     * @since 2016年3月9日
     */
    @SuppressWarnings("unchecked")
    public <T> T toBean(Map<String, ?> map, Class<T> classz) {
        T target;
        try {
            target = classz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BeanMap beanMap = BeanMap.create(target);
        for (String key : beanMap.keySet()) {
            Object value = map.get(key);
            if (value == null) {
                beanMap.put(key, null);
                continue;
            }
            Class<?> paramType = beanMap.getParameterType(key);
            Class<?> valueType = value.getClass();
            if (null == paramType) {
                continue;
            }
            if (U.STR.equals(valueType.getName(), paramType.getName())
                || U.STR.equals(BeanMap.WARP_CLASS_MAP.get(valueType.getName()), paramType.getName())) {
                beanMap.put(key, value);
                continue;
            }
            if (Map.class.isInstance(value)) {
                beanMap.put(key, this.toBean(Map.class.cast(value), paramType));
            }
        }

        beanMap.putAll(map);
        return target;
    }

    /**
     * 用map包装source,操作map等同于操作source<br>
     * map的key为source的属性名称,value为属性值<br>
     * 向map中put非source的属性名称的key时,put动作不生效<br>
     * 向map中put source的属性名称的key时,value必须和source的属性类型相同
     * 
     * @param source 数据源
     * @return map
     * @author 邢治理
     * @since 2016年3月9日
     */
    public Map<String, Object> asMap(Object source) {
        return BeanMap.create(source);
    }

    /**
     * 把对象中的数据copy到map中<BR>
     * 如果source为Map类型则直接返回
     * 
     * @param source 数据源
     * @return map
     * @author 邢治理
     * @since 2016年3月9日
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> toMap(Object source) {

        if (Map.class.isInstance(source)) {
            return (Map<String, Object>) source;
        }

        return new HashMap<>(this.asMap(source));
    }

}
