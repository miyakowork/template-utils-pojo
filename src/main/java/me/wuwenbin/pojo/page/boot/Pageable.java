package me.wuwenbin.pojo.page.boot;

import java.util.List;

/**
 * 分页对象信息的抽象接口
 * Created by wuwenbin on 2017/6/6.
 */
public interface Pageable<T> {

    /**
     * 返回当前页面的页码
     *
     * @return
     */
    int getPageNo();

    /**
     * 返回每页页面数据量的大小
     *
     * @return
     */
    int getPageSize();

    /**
     * 获取当前页的第一条数据的起始序号（从0开始计数）
     *
     * @return
     */
    int getPageStart();

    /**
     * 返回当前页面最后一条数据的序号（从1开始计数）
     *
     * @return
     */
    int getPageOver();

    /**
     * 获取数据量的总数
     *
     * @return
     */
    int getTotalCount();


    /**
     * 获取总页数
     *
     * @return
     */
    int getTotalPages();

    /**
     * 当前分页对象中所包含的数据集合对象
     *
     * @return
     */
    List<T> getContent();

    /**
     * 当前分页对象是否包含数据内容
     *
     * @return
     */
    boolean hasContent();

    /**
     * 返回排序参数对象
     *
     * @return
     */
    Sort getSort();

    /**
     * 返回下一页分页信息对象，如果已经是最后一页，则还是返回最后一页
     *
     * @return
     */
    int nextOrLast();

    /**
     * 返回上一页对象，如果当前页已经是第一页，则还是返回第一页
     *
     * @return
     */
    int previousOrFirst();

    /**
     * 返回第一页的分页对象信息
     *
     * @return
     */
    int first();

    /**
     * 返回最后一页的分页对象信息
     *
     * @return
     */
    int last();

    /**
     * 当前页是否还有上一页
     *
     * @return
     */
    boolean hasPrevious();

    /**
     * 当前页是否还有下一页
     *
     * @return
     */
    boolean hasNext();

    /**
     * 是否为第一页
     *
     * @return
     */
    boolean isFirst();

    /**
     * 是否为最后一页
     *
     * @return
     */
    boolean isLast();
}
