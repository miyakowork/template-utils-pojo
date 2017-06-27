package org.templateproject.pojo.page.boot.support;

import java.util.Locale;

/**
 * Created by wuwenbin on 2017/6/10.
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
