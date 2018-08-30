package com.zgh.springboot.common;


import com.github.pagehelper.Page;
import lombok.Data;


import java.io.Serializable;

@Data
public class PageResult<T> implements Serializable {
    //当前页
    private int pageNum = 1;
    //每页的数量
    private int pageSize = 15;
    //总量
    private long total = 0;

    private Boolean hasMore;

    public static <T> PageResult<T> build(T list) {
        PageResult<T> tNashPaging = new PageResult<T>();
        Page page = (Page) list;
        tNashPaging.setPageNum(page.getPageNum());
        tNashPaging.setPageSize(page.getPageSize());
        tNashPaging.setTotal(page.getTotal());
        tNashPaging.setHasMore(page.getPageNum() * page.getPageSize() < page.getTotal());
        return tNashPaging;
    }
}