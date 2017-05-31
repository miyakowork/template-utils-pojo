package me.wuwenbin.pojo.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Service层之上的组件，即Service层之间的复杂调用在使用XXXXFacade来完成
 * 不要在Service层调用Service，这样代码可维护性强，入侵性低。
 * Created by wuwenbin on 2017/5/31.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Facade {

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     *
     * @return the suggested component name, if any
     */
    String value() default "";

}
