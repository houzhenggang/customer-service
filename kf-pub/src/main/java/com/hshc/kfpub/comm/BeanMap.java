package com.hshc.kfpub.comm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Bean的Map类型封装类,把Bean用Map封装,操作Map等同于操作Bean
 * 
 * @className BeanMap
 * @author 邢治理
 * @version V1.0 2016年3月10日
 * @since 2016年3月10日
 */

class BeanMap implements Map<String, Object> {
    /** 包装类Map 在Map中保存的key:value都是包装类型名称:原始类型名称 */
    public static final Map<String, String> WARP_CLASS_MAP = new HashMap<>(8);

    static {
        WARP_CLASS_MAP.put(Byte.class.getName(), byte.class.getName());
        WARP_CLASS_MAP.put(Short.class.getName(), short.class.getName());
        WARP_CLASS_MAP.put(Integer.class.getName(), int.class.getName());
        WARP_CLASS_MAP.put(Long.class.getName(), long.class.getName());
        WARP_CLASS_MAP.put(Float.class.getName(), float.class.getName());
        WARP_CLASS_MAP.put(Double.class.getName(), double.class.getName());
        WARP_CLASS_MAP.put(Character.class.getName(), char.class.getName());
        WARP_CLASS_MAP.put(Boolean.class.getName(), boolean.class.getName());
    }

    /**
     * 被包装的对象
     */
    private Object source;
    /**
     * Map key:value == source对象的属性名称:setter方法
     */
    private Map<String, Method> setter = null;
    /**
     * Map key:value == source对象的属性名称:getter方法
     */
    private Map<String, Method> getter = null;
    /**
     * 如果属性是日期类型的,用put操作设置属性值时的日期解析格式
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private BeanMap(Object source) {
        this.source = source;
        Method[] methods = source.getClass().getMethods();
        this.initGetter(methods);
        this.initSetter(methods);
    }

    /**
     * 创建source对象的map模式,操作map等同于操作source对象<BR>
     * <CODE>source.setMMM(a) == beanMap.put("MMM", a) <CODE><BR>
     * <CODE>source.getMMM() == beanMap.gett("MMM") <CODE>
     * 
     * @param source 对象
     * @return beanMap
     * @author 邢治理
     * @since 2016年3月10日
     */
    public static BeanMap create(Object source) {
        if (source == null) {
            throw new NullPointerException("com.jy.common.util.BeanMap.create 参数不能为 null");
        }
        return new BeanMap(source);
    }

    /**
     * 初始化getter方法map
     * 
     * @param methods source所有public方法数组
     * @author 邢治理
     * @since 2016年3月10日
     */
    private void initGetter(Method[] methods) {
        this.getter = new HashMap<>();

        for (Method method : methods) {
            String methodName = method.getName();
            String paramName = null;
            if (method.getParameterTypes().length != 0) {
                continue;
            }
            if (U.STR.equals(methodName, "getClass")) {
                continue;
            }
            if (methodName.startsWith("get")) {
                paramName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
            } else if (methodName.startsWith("is") && U.STR.equals(method.getReturnType().getName(), "boolean")) {
                paramName = methodName.substring(2, 3).toLowerCase() + methodName.substring(3);
            } else {
                continue;
            }
            this.getter.put(paramName, method);

        }
    }

    /**
     * 初始化setter方法map
     * 
     * @param methods source所有public方法数组
     * @author 邢治理
     * @since 2016年3月10日
     */
    private void initSetter(Method[] methods) {
        this.setter = new HashMap<>();
        for (Method method : methods) {
            String methodName = method.getName();
            String paramName = null;
            if (method.getParameterTypes().length != 1 || !methodName.startsWith("set")) {
                continue;
            }
            // 属性名称首字母小写
            paramName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
            this.setter.put(paramName, method);

        }
    }

    private <T> T case2Number(String value, Class<T> classz) {

        BigDecimal decimalValue = U.NUM.createBigDecimal(value);
        String classzName = classz.getName();
        T result = null;
        if (U.STR.equals(classzName, Byte.class.getName())) {
            // byte
            result = classz.cast(Byte.valueOf(decimalValue.byteValue()));

        } else if (U.STR.equals(classzName, Short.class.getName())) {
            // short
            result = classz.cast(Short.valueOf(decimalValue.shortValue()));

        } else if (U.STR.equals(classzName, Integer.class.getName())) {
            // int
            result = classz.cast(Integer.valueOf(decimalValue.intValue()));

        } else if (U.STR.equals(classzName, Long.class.getName())) {
            // long
            result = classz.cast(Long.valueOf(decimalValue.longValue()));

        } else if (U.STR.equals(classzName, Float.class.getName())) {
            // float
            result = classz.cast(Float.valueOf(decimalValue.floatValue()));

        } else if (U.STR.equals(classzName, Double.class.getName())) {
            // double
            result = classz.cast(Double.valueOf(decimalValue.doubleValue()));

        } else if (U.STR.equals(classzName, BigDecimal.class.getName())) {
            // BigDecimal
            result = classz.cast(decimalValue);

        }

        return result;

    }

    /**
     * 把value转换为指定类型的对象
     * 
     * @param value 对象
     * @param classz 类型
     * @return
     * @author 邢治理
     * @since 2016年3月10日
     */

    @SuppressWarnings("unchecked")
    private <T> T cast(Object value, Class<T> classz) {
        String valueTypeName = value.getClass().getName();
        String classzName = classz.getName();
        if (classz.isInstance(value)) {
            return classz.cast(value);
        }
        if (U.STR.equals(BeanMap.WARP_CLASS_MAP.get(valueTypeName), classzName)) {
            // 基本数据类型的包装类强制转换为基本数据类型
            return (T) value;
        }

        if (!U.STR.equals(String.class.getName(), valueTypeName)) {
            return null;
        }
        if (U.STR.isEmpty(value.toString())) {
            return null;
        }

        T result = null;

        if (U.STR.equals(classz.getSuperclass().getName(), Number.class.getName())) {
            result = this.case2Number(value.toString(), classz);

        } else if (U.STR.equals(classzName, Boolean.class.getName())) {
            // boolean
            result = classz.cast(Boolean.valueOf(value.toString()));

        } else if (U.STR.equals(classzName, Character.class.getName())) {
            // char
            result = classz.cast(Character.valueOf(value.toString().charAt(0)));

        } else if (U.STR.equals(classzName, Date.class.getName())) {
            try {
                Date date = this.sdf.parse(value.toString());
                result = classz.cast(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return result;

    }

    /**
     * 根据参数名称获取参数的类型
     * 
     * @param parameterName 参数名称
     * @return 参数类型
     * @author 邢治理
     * @since 2016年3月10日
     */
    public Class<?> getParameterType(String parameterName) {
        Method m = this.getter.get(parameterName);
        if (m == null) {
            return null;
        }
        return m.getReturnType();
    }

    /**
     * 源对象可访问的属性的个数
     * 
     * @return 源对象可访问的属性的个数
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    public int size() {

        return this.getter.size();
    }

    /**
     * 源对象是否不包含可访问的属性
     * 
     * @return 源对象是否不包含可访问的属性
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    public boolean isEmpty() {

        return this.size() == 0;
    }

    /**
     * 源对象中是否存在名称为key的属性
     * 
     * @return 源对象中是否存在名称为key的属性
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    public boolean containsKey(Object key) {
        return this.getter.containsKey(key);
    }

    /**
     * 源对象中是否存在值为value的属性
     * 
     * @return 源对象中是否存在值为value的属性
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    public boolean containsValue(Object value) {
        return this.values().contains(value);
    }

    /**
     * 封装了get方法
     * 
     * @param key 属性名称
     * @return 属性值
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    public Object get(Object key) {
        Method method = this.getter.get(key);
        if (method == null) {
            return null;
        }
        Object value = null;
        try {
            value = method.invoke(this.source);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException("com.jy.common.util.BeanMap.get 出现异常!", e);
        }
        return value;
    }

    /**
     * 封装了set方法,如果source对象中没有对象的set方法,则此动作无效
     * 
     * @param key 属性名称
     * @param value 属性值
     * @return null
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    public Object put(String key, Object value) {

        if ("strValue".equals(key)) {
        }

        Method method = this.setter.get(key);
        if (method == null) {
            return null;
        }
        try {
            if (value == null) {
                // method.invoke(this.source, new Object[] {null});
            } else {
                Class<?> paramType = this.getParameterType(key);

                if (paramType.isPrimitive() && String.class.isInstance(value)) {
                    this.invokeWithPrimitive(method, value.toString(), paramType);
                } else {
                    method.invoke(this.source, this.cast(value, paramType));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("com.jy.common.util.BeanMap.put 出现异常!", e);
        }
        return null;
    }

    /**
     * 设置基本数据类型属性的值
     * 
     * @param method set方法
     * @param value 属性值
     * @param paramType 属性类型
     * @author 邢治理
     * @since 2016年3月10日
     */
    private void invokeWithPrimitive(Method method, String value, Class<?> paramType) {

        if (U.STR.isEmpty(value)) {
            value = null;
        }
        try {
            if (value == null) {
                this.invokeDefaultPrimitive(method, paramType);
                return;
            }

            if (byte.class == paramType) {
                method.invoke(this.source, Double.valueOf(value.toString()).byteValue());
            } else if (short.class == paramType) {
                method.invoke(this.source, Double.valueOf(value.toString()).shortValue());
            } else if (int.class == paramType) {
                method.invoke(this.source, Double.valueOf(value.toString()).intValue());
            } else if (long.class == paramType) {
                method.invoke(this.source, Double.valueOf(value.toString()).longValue());
            } else if (float.class == paramType) {
                method.invoke(this.source, Double.valueOf(value.toString()).floatValue());
            } else if (double.class == paramType) {
                method.invoke(this.source, Double.valueOf(value.toString()).doubleValue());
            } else if (boolean.class == paramType) {
                method.invoke(this.source, Boolean.valueOf(value.toString()).booleanValue());
            } else if (char.class == paramType) {
                if (!U.STR.equals("", value.toString())) {
                    method.invoke(this.source, Character.valueOf(value.toString().charAt(0)).charValue());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置基本数据类型属性的默认值值
     * 
     * @param method set方法
     * @param paramType 属性类型
     * @author 邢治理
     * @since 2016年3月11日
     */
    private void invokeDefaultPrimitive(Method method, Class<?> paramType) {

        try {
            if (byte.class == paramType) {
                method.invoke(this.source, (byte) 0);
            } else if (short.class == paramType) {
                method.invoke(this.source, (short) 0);
            } else if (int.class == paramType) {
                method.invoke(this.source, 0);
            } else if (long.class == paramType) {
                method.invoke(this.source, 0L);
            } else if (float.class == paramType) {
                method.invoke(this.source, 0F);
            } else if (double.class == paramType) {
                method.invoke(this.source, 0D);
            } else if (boolean.class == paramType) {
                method.invoke(this.source, false);
            } else if (char.class == paramType) {
                method.invoke(this.source, ' ');
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 调此方法会抛异常,不能使用
     * 
     * @param key
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    @Deprecated
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    /**
     * 把map对象中的key:value复制到source中
     * 
     * @param m map对象
     * @author 邢治理
     * @since 2016年3月10日
     */
    @Override
    public void putAll(Map<? extends String, ? extends Object> m) {
        for (Map.Entry<? extends String, ? extends Object> e : m.entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }

    @Override
    @Deprecated
    public void clear() {

    }

    @Override
    public Set<String> keySet() {

        return this.getter.keySet();
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("{");
        for (String key : this.keySet()) {
            strBuilder.append(key).append(":");
            strBuilder.append(this.get(key)).append(", ");
        }
        int length = strBuilder.length();
        if (length > 2) {
            strBuilder.replace(length - 2, length, "}");
        } else {
            strBuilder.append("}");
        }
        return strBuilder.toString();
    }

    @Override
    public Collection<Object> values() {
        List<Object> values = new ArrayList<>(this.size());
        for (String param : this.getter.keySet()) {
            values.add(this.get(param));
        }
        return values;
    }

    @Override
    public Set<java.util.Map.Entry<String, Object>> entrySet() {

        return new EntrySet();
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    private final class EntrySet extends AbstractSet<Map.Entry<String, Object>> {
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new EntryIterator();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }

            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            Object key = e.getKey();

            return BeanMap.this.containsKey(key);
        }

        public boolean remove(Object o) {
            return false;
        }

        public int size() {
            return BeanMap.this.size();
        }

        public void clear() {
            BeanMap.this.clear();
        }
    }

    private final class EntryIterator implements Iterator<Map.Entry<String, Object>> {
        private Iterator<String> keyIterator = BeanMap.this.getter.keySet().iterator();

        @Override
        public boolean hasNext() {

            return keyIterator.hasNext();
        }

        @Override
        public java.util.Map.Entry<String, Object> next() {

            return new BeanEntry(keyIterator.next());
        }

        @Override
        public void remove() {

        }

    }

    private final class BeanEntry implements java.util.Map.Entry<String, Object> {
        BeanEntry(String paramName) {
            this.paramName = paramName;
        }

        private String paramName;

        @Override
        public String getKey() {

            return paramName;
        }

        @Override
        public Object getValue() {

            return BeanMap.this.get(paramName);
        }

        @Override
        public Object setValue(Object value) {
            BeanMap.this.put(paramName, value);
            return null;
        }

    }

}
