package org.templateproject.pojo.page.boot;

import org.templateproject.pojo.page.boot.support.PageSort;

import java.util.List;

/**
 * 分页对象信息接口的一个基本实现
 * 可自定义实现，继承Pagination抽象类或者实现Pageable接口即可
 * Created by wuwenbin on 2017/6/7.
 */
public class PageSection<T> extends Pagination<T> {

    private static final int FIRST_PAGE = 1;

    private final int totalCount;
    private final List<T> content;

    private final PageSort pageSort;

    public PageSection(int pageNo, int pageSize, int totalCount, List<T> content, PageSort pageSort) {
        super(pageNo, pageSize);
        if (totalCount < 0) {
            throw new IllegalArgumentException("数据总量大小不能小于0");
        }
        this.totalCount = totalCount;
        this.content = content;
        this.pageSort = pageSort;
    }

    @Override
    public PageSort getPageSort() {
        return pageSort;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
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
    public int nextOrLast() {
        return getPageNo() + 1 > last() ? last() : getPageNo() + 1;
    }

    @Override
    public int previousOrFirst() {
        return getPageNo() - 1 < first() ? first() : getPageNo() - 1;
    }

    @Override
    public int first() {
        return FIRST_PAGE;
    }

    @Override
    public int last() {
        return getTotalPages();
    }

}
