package me.wuwenbin.pojo.page.boot;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * Created by wuwenbin on 2017/6/6.
 */
public class Sort implements Iterable<Sort.Order>, Serializable {

    public static final Direction DEFAULT_DIRECTION = Direction.ASC;

    private final List<Order> orders;

    /**
     * 通过所给的 Sort 参数来新建一个Sort实例
     *
     * @param orders 不能为空
     */
    public Sort(Order... orders) {
        this(Arrays.asList(orders));
    }

    /**
     * 创建一个新的Sort实例
     *
     * @param orders
     */
    public Sort(List<Order> orders) {

        if (null == orders || orders.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }

        this.orders = orders;
    }

    /**
     * 创建一个新的 Sort 实例，Order默认为AES
     *
     * @param properties 不能为空，不能包含null或空字符串
     */
    public Sort(String... properties) {
        this(DEFAULT_DIRECTION, properties);
    }

    /**
     * 创建一个新的Sort实例
     *
     * @param direction  排序方向
     * @param properties 排序属性，不能为空，不能包含null或空字符串
     */
    public Sort(Direction direction, String... properties) {
        this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
    }

    /**
     * 创建一个新的Sort实例
     *
     * @param direction
     * @param properties
     */
    public Sort(Direction direction, List<String> properties) {

        if (properties == null || properties.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one property to sort by!");
        }

        this.orders = new ArrayList<Order>(properties.size());

        for (String property : properties) {
            this.orders.add(new Order(direction, property));
        }
    }

    /**
     * 返回一个新的Sort对象，与当前的sort组合在一起
     *
     * @param sort 可以为空
     * @return
     */
    public Sort and(Sort sort) {

        if (sort == null) {
            return this;
        }

        ArrayList<Order> these = new ArrayList<Order>(this.orders);

        for (Order order : sort) {
            these.add(order);
        }

        return new Sort(these);
    }

    /**
     * Returns the order registered for the given property.
     *
     * @param property
     * @return
     */
    public Order getOrderFor(String property) {

        for (Order order : this) {
            if (order.getProperty().equals(property)) {
                return order;
            }
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Order> iterator() {
        return this.orders.iterator();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Sort)) {
            return false;
        }

        Sort that = (Sort) obj;

        return this.orders.equals(that.orders);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;
        result = 31 * result + orders.hashCode();
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return StringUtils.collectionToCommaDelimitedString(orders);
    }

    /**
     * 排序方向
     */
    public enum Direction {

        ASC, DESC;

        /**
         * 是否为正序排序
         *
         * @return
         */
        public boolean isAscending() {
            return this.equals(ASC);
        }

        /**
         * 是否为倒序排序
         *
         * @return
         */
        public boolean isDescending() {
            return this.equals(DESC);
        }

        /**
         * 把String类型的排序方法转化为Enum
         *
         * @param value
         * @return
         */
        public static Direction fromString(String value) {

            try {
                return Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format(
                        "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
            }
        }

        /**
         * 同上，但是如果能成功转化，则返回null
         *
         * @param value
         * @return
         */
        public static Direction fromStringOrNull(String value) {

            try {
                return fromString(value);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    /**
     * PropertyPath实现了{@link Direction}和属性的配对。 它用于为{@link Sort}提供输入
     */
    public static class Order implements Serializable {

        private static final boolean DEFAULT_IGNORE_CASE = false;

        private final Direction direction;
        private final String property;
        private final boolean ignoreCase;


        public Order(Direction direction, String property) {
            this(direction, property, DEFAULT_IGNORE_CASE);
        }


        public Order(String property) {
            this(DEFAULT_DIRECTION, property);
        }


        private Order(Direction direction, String property, boolean ignoreCase) {

            if (!StringUtils.hasText(property)) {
                throw new IllegalArgumentException("Property must not null or empty!");
            }

            this.direction = direction == null ? DEFAULT_DIRECTION : direction;
            this.property = property;
            this.ignoreCase = ignoreCase;
        }


        public Direction getDirection() {
            return direction;
        }


        public String getProperty() {
            return property;
        }


        public boolean isAscending() {
            return this.direction.isAscending();
        }


        public boolean isDescending() {
            return this.direction.isDescending();
        }

        public boolean isIgnoreCase() {
            return ignoreCase;
        }


        public Order with(Direction direction) {
            return new Order(direction, this.property, this.ignoreCase);
        }


        public Order withProperty(String property) {
            return new Order(this.direction, property, this.ignoreCase);
        }


        public Sort withProperties(String... properties) {
            return new Sort(this.direction, properties);
        }


        public Order ignoreCase() {
            return new Order(direction, property, true);
        }


        /*
         * (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {

            int result = 17;

            result = 31 * result + direction.hashCode();
            result = 31 * result + property.hashCode();
            result = 31 * result + (ignoreCase ? 1 : 0);

            return result;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Order)) {
                return false;
            }

            Order that = (Order) obj;

            return this.direction.equals(that.direction) && this.property.equals(that.property)
                    && this.ignoreCase == that.ignoreCase;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {

            String result = String.format("%s: %s", property, direction);

            if (ignoreCase) {
                result += ", ignoring case";
            }

            return result;
        }
    }
}
