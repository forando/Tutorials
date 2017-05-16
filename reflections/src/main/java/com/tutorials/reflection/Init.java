package com.tutorials.reflection;

import java.lang.annotation.*;

/**
 * Created by Andreylogoshko on 17.02.2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Init {
    boolean suppressException() default false;
}
