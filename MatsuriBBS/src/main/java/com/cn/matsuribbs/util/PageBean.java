package com.cn.matsuribbs.util;

public class PageBean {
    private Integer page;
    private Integer limit;
    private Integer offset;
    private Integer sid;

    public PageBean(Integer page, Integer limit, Integer sid) {
        if(page == null || page <1){
            page = 1;
        }
        this.page = page;
        if (limit == null || limit<1){
            limit = 10;
        }
        this.limit = limit;
        this.offset = (this.page-1) * this.limit;
        this.sid = sid;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
