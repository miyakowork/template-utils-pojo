package me.wuwenbin.pojo.page.boot;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuwenbin on 2017/6/7.
 */
public abstract class Pagination<T> implements Pageable<T>, Serializable {

    private final int pageNo;
    private final int pageSize;


    public Pagination(int pageNo, int pageSize) {
        if (pageNo < 0) {
            throw new IllegalArgumentException("页码不能小于0");
        }
        if (pageSize < 1) {
            throw new IllegalArgumentException("页面大小不能小于1");
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageStart() {
        return (pageNo - 1) * pageSize;
    }

    public int getPageOver() {
        return pageNo * pageSize;
    }

    public abstract int getTotalCount();

    public abstract int getTotalPages();

    public abstract List<T> getContent();

    public abstract boolean hasContent();

    public abstract Sort getSort();

    public abstract int nextOrLast();

    public abstract int previousOrFirst();

    public abstract int first();

    public abstract int last();


    public boolean hasPrevious() {
        return pageNo > 1;
    }

    public boolean hasNext() {
        return pageNo < getTotalPages();
    }

    public boolean isFirst() {
        return !hasPrevious();
    }

    public boolean isLast() {
        return !hasNext();
    }

}
