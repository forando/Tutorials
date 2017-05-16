package com.tutorials.spring.quoters;

/**
 * Здесь прописываем те методы, которые должны быть доступны через JMX Console
 */
public interface ProfilingControllerMBean {
    void setEnabled(boolean enabled);
}
