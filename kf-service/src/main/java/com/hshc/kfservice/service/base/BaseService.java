/**
 * 所有Service的公共父接口
 * 
 * @title: BaseService.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfservice.service.base;

import java.util.List;

import com.hshc.kfpub.base.BaseModel;
import com.hshc.kfpub.base.BaseVO;

/**
 * 所有Service的公共父接口
 * 
 * @className BaseService
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface BaseService<V extends BaseVO, M extends BaseModel> {

    /**
     * 根据ID查询记录
     * 
     * @param id
     * @return
     */
    M queryById(Integer id);

    /**
     * 根据查询条件，分页查询记录
     * 
     * @param param
     * @return
     */
    List<M> queryByParams(V param);

    /**
     * 新增记录
     * 
     * @param m 待保存的实体
     * @return 返回成功条数
     */
    int add(M m);

    /**
     * 批量添加记录
     * 
     * @param list 待添加的记录集合
     * @return 返回成功条数
     */
    int addBatch(List<M> list);

    /**
     * 更新记录
     * 
     * @param m 待更新实体
     * @return 返回成功条数
     */
    int modify(M m);

    /**
     * 根据ID删除记录
     * 
     * @param id 记录ID
     * @return 返回成功条数
     */
    int remove(Integer id);

    /**
     * 根据ID批量删除，多个ID用英文逗号分隔
     * 
     * @param ids 按
     * @return 返回成功条数
     */
    int removeBatch(String ids);
}
