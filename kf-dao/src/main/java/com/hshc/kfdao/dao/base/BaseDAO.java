/**
 * 所有DAO的公共父接口
 * 
 * @title: BaseDAO.java
 * @author 邢治理
 * @date 2016年7月29日
 */
package com.hshc.kfdao.dao.base;

import java.util.List;

import com.hshc.kfpub.base.BaseModel;
import com.hshc.kfpub.base.BaseVO;

/**
 * 所有DAO的公共父接口
 * 
 * @className BaseDAO
 * @author 邢治理
 * @version V1.0 2016年7月29日
 */
public interface BaseDAO<V extends BaseVO, M extends BaseModel> {

    /**
     * 根据ID查询记录
     * 
     * @param id 主键
     * @return 返回记录
     */
    M selectById(Integer id);

    /**
     * 根据条件分页查询
     * 
     * @param param
     * @return
     */
    List<M> selectByParams(V param);

    /**
     * 根据条件查询记录条数
     * 
     * @param param
     * @return
     */
    int selectCountByParams(V param);

    /**
     * 新增记录
     * 
     * @param m 待新增记录
     * @return 返回成功条数
     */
    int insert(M m);

    /**
     * 更新记录
     * 
     * @param m 待更新记录
     * @return 返回成功条数
     */
    int update(M m);

    /**
     * 根据记录ID删除记录
     * 
     * @param id 主键
     * @return 返回成功条数
     */
    int deleteById(Integer id);

    /**
     * 批量新增记录
     *
     * @param modelList
     * @return
     */
    int insertBatch(List<M> modelList);

}
