package com.mmall.common.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @author: gg
 * @date: 2018/12/10 17:37
 */
public class Page implements Serializable {

    private static final long serialVersionUID = -2937537029915876600L;

    @JsonIgnore
    private Integer pageNo;

    @JsonIgnore
    private Integer pageSize;

    @JsonIgnore
    private Integer pageStart;

    @JsonIgnore
    private Integer pageEnd;

    public Page() {

    }

    public Page(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Page setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Page setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    /**
     * 初始化分页
     *
     * @param page 分页
     * @return Page
     */
    public static Page initPage(Page page) {
        if (page == null) {
            page = new Page();
        }
        if (page.getPageNo() == null) {
            page.setPageNo(1);
        }
        if (page.getPageSize() == null) {
            page.setPageSize(20);
        }
        page.setPageStart((page.getPageNo() - 1) * page.getPageSize());
        page.setPageEnd(page.getPageSize() * page.getPageNo());
        return page;
    }

    /**
     * poi表格分页初始化方法
     * 默认500页
     *
     * @param page 分页
     */
    public static void initPagePoi(Page page) {
        if (page == null) {
            page = new Page();
        }
        if (page.getPageNo() == null) {
            page.setPageNo(1);
        }
        if (page.getPageSize() == null) {
            page.setPageSize(500);
        }
        page.setPageStart((page.getPageNo() - 1) * page.getPageSize());
    }

    /**
     * 自定义分页
     *
     * @param page            分页
     * @param defaultPageSize 默认数量
     */
    public static void initPage(Page page, int defaultPageSize) {
        if (page == null) {
            page = new Page();
        }
        if (page.getPageNo() == null) {
            page.setPageNo(1);
        }
        if (page.getPageSize() == null) {
            page.setPageSize(defaultPageSize);
        }

    }
}

