package me.wuwenbin.pojo.page.boot.support;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created by wuwenbin on 2017/6/10.
 */
public class Order implements Serializable {

    private static final Direction DEFAULT_DIRECTION = Direction.ASC;

    private final Direction direction;
    private final String property;


    public Order(String property) {
        this(DEFAULT_DIRECTION, property);
    }


    public Order(Direction direction, String property) {

        if (!StringUtils.hasText(property)) {
            throw new IllegalArgumentException("Property must not null or empty!");
        }

        this.direction = direction == null ? DEFAULT_DIRECTION : direction;
        this.property = property;
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

}
