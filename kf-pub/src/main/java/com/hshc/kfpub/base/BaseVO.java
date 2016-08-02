/**
 * 所有VO的公共父类
 * 
 * @title: BaseVO.java
 * @author 邢治理
 * @date 2016年8月1日
 */
package com.hshc.kfpub.base;

import java.util.Date;

/**
 * 所有VO的公共父类
 * 
 * @className BaseVO
 * @author 邢治理
 * @version V1.0 2016年8月1日
 */
public class BaseVO {

    Integer id;

    // 创建时间查询开始时间
    private Date createDateBegin;
    // 创建时间查询结束时间
    private Date createDateEnd;
    // 最后更新时间查询开始时间
    private Date lastUpdateDateBegin;
    // 最后更新时间查询结束时间
    private Date lastUpdateDateEnd;

    // 自定义时间1查询开始时间
    private Date customDate1Begin;
    // 自定义时间查1询结束时间
    private Date customDate1End;
    // 自定义时间2查询开始时间
    private Date customDate2Begin;
    // 自定义时间2查询结束时间
    private Date customDate2End;

    // 获取记录起始位置
    private Integer limitStart = 0;
    // 获取记录条数/次
    private Integer limitPageSize = 10;
    // 当前页号
    private Integer currentPageNo = 1;
    // 页大小
    private Integer pageSize = 10;
    // 总页数
    private Integer totalPage = 0;

    public Date getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(Date createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Date getLastUpdateDateBegin() {
        return lastUpdateDateBegin;
    }

    public void setLastUpdateDateBegin(Date lastUpdateDateBegin) {
        this.lastUpdateDateBegin = lastUpdateDateBegin;
    }

    public Date getLastUpdateDateEnd() {
        return lastUpdateDateEnd;
    }

    public void setLastUpdateDateEnd(Date lastUpdateDateEnd) {
        this.lastUpdateDateEnd = lastUpdateDateEnd;
    }

    public Date getCustomDate1Begin() {
        return customDate1Begin;
    }

    public void setCustomDate1Begin(Date customDate1Begin) {
        this.customDate1Begin = customDate1Begin;
    }

    public Date getCustomDate1End() {
        return customDate1End;
    }

    public void setCustomDate1End(Date customDate1End) {
        this.customDate1End = customDate1End;
    }

    public Date getCustomDate2Begin() {
        return customDate2Begin;
    }

    public void setCustomDate2Begin(Date customDate2Begin) {
        this.customDate2Begin = customDate2Begin;
    }

    public Date getCustomDate2End() {
        return customDate2End;
    }

    public void setCustomDate2End(Date customDate2End) {
        this.customDate2End = customDate2End;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart = limitStart;
    }

    public Integer getLimitPageSize() {
        return limitPageSize;
    }

    public void setLimitPageSize(Integer limitPageSize) {
        this.limitPageSize = limitPageSize;
    }

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
        calculateRecordStart();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.limitPageSize = pageSize;
        calculateRecordStart();
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    /*
     * 计算获取记录的开始位置
     */
    private void calculateRecordStart() {
        this.limitStart = (this.currentPageNo - 1) * this.pageSize;
    }

}
