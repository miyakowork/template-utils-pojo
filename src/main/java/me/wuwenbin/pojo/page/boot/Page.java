package me.wuwenbin.pojo.page.boot;

import me.wuwenbin.pojo.page.boot.Sort.Direction;

import java.util.List;

/**
 * Created by wuwenbin on 2017/6/7.
 */
public class Page<T> extends Pagination<T> {

    private final Sort sort;

    private final int count;
    private final List<T> content;

    public Page(int pageNo, int pageSize, int totalCount, List<T> content, Sort sort) {
        super(pageNo, pageSize);
        this.sort = sort;
        if (totalCount < 0) {
            throw new IllegalArgumentException("数据总量大小不能小于0");
        }
        this.count = totalCount;
        this.content = content;
    }

    public Page(int pageNo, int pageSize, int totalCount, List<T> content) {
        this(pageNo, pageSize, totalCount, content, null);
    }

    public Page(int pageNo, int pageSize, int totalCount, List<T> content, Direction direction, String... properties) {
        this(pageNo, pageSize, totalCount, content, new Sort(direction, properties));
    }



    @Override
    public int getTotalCount() {
        return count;
    }

    @Override
    public int getTotalPages() {
        int count = getTotalCount() / getPageSize();
        if (getTotalCount() % getPageSize() > 0) {
            count++;
        }
        return count;
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public boolean hasContent() {
        return content != null && !content.isEmpty();
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public int nextOrLast() {
        return getPageNo() + 1 > last() ? last() : getPageNo() + 1;
    }

    @Override
    public int previousOrFirst() {
        return getPageNo() - 1 < first() ? first() : getPageNo() - 1;
    }

    @Override
    public int first() {
        return 1;
    }

    @Override
    public int last() {
        return getTotalPages();
    }

}
