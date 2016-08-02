/**
 * easyui框架datagrid列表的json格式对象
 * 
 * @title: DatagridObject.java
 * @author 邢治理
 * @date 2016年7月16日
 */
package com.hshc.kfpub.comm;

import java.util.ArrayList;
import java.util.List;

/**
 * easyui框架datagrid列表的json格式对象
 * 
 * @className DatagridObject
 * @author 邢治理
 * @version V1.0 2016年7月16日
 */
@SuppressWarnings("rawtypes")
public class DatagridObject<T> {

    private int total;
    private List<T> data = new ArrayList<T>();

    public DatagridObject(int totalRecodeAmt, List<T> dataList) {
        this.total = totalRecodeAmt;
        this.data = dataList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\"total\":" + total + ",\"rows\":" + U.JSON.toJson(data) + "}";
    }

}
