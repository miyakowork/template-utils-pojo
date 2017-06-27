package org.templateproject.pojo.page.boot.support;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wuwenbin on 2017/6/10.
 */
public class PageSort implements Iterable<Order>, Serializable {

    private final List<Order> orders;


    /**
     * 通过所给的 Sort 参数来新建一个Sort实例
     *
     * @param orders 不能为空
     */
    public PageSort(Order... orders) {
        this(Arrays.asList(orders));
    }

    /**
     * 创建一个新的 Sort 实例，Order默认为AES
     *
     * @param properties 不能为空，不能包含null或空字符串
     */
    public PageSort(String... properties) {
        this(Direction.ASC, properties);
    }

    /**
     * 创建一个新的Sort实例
     *
     * @param orders
     */
    public PageSort(List<Order> orders) {

        if (null == orders || orders.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }

        this.orders = orders;
    }

    /**
     * 创建一个新的Sort实例
     *
     * @param direction  排序方向
     * @param properties 排序属性，不能为空，不能包含null或空字符串
     */
    public PageSort(Direction direction, String... properties) {
        this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
    }

    /**
     * 创建一个新的Sort实例
     *
     * @param direction
     * @param properties
     */
    public PageSort(Direction direction, List<String> properties) {

        if (properties == null || properties.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one property to sort by!");
        }

        this.orders = new ArrayList<>(properties.size());

        for (String property : properties) {
            this.orders.add(new Order(direction, property));
        }
    }


    public Order getOrderFor(String property) {

        for (Order order : this) {
            if (order.getProperty().equals(property)) {
                return order;
            }
        }

        return null;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public static PageSort create(String... properties) {
        return new PageSort(properties);
    }

    public static PageSort create(Order... orders) {
        return new PageSort(orders);
    }

    public static PageSort creaete(Direction direction, String... properties) {
        return new PageSort(direction, properties);
    }

    @Override
    public Iterator<Order> iterator() {
        return this.orders.iterator();
    }
}
