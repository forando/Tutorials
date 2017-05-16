package com.tutorials.reflection;

import java.lang.annotation.*;

/**
 * Created by Andreylogoshko on 16.02.2017.
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name();
    boolean lazyLoad() default false;
}
