package com.tutorials.spring.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Все классы с этой аннотацией должны профилироваться.
 * То есть, чтобы логировалось время работы методов класса.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
