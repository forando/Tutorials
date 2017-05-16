package com.tutorials.spring.quoters;

/**
 * Когда поднимается Java process вместе с ним поднимается MBean Server и все объекты,
 * которые в нем зарегистрированы, можно  через JMX Console менять, запускать их методы и т. Д.
 * По конвенции этот класс должен имплементировать интерфейс с точно таким же именем как и сам
 * класс, только + MBean в конце.
 */
public class ProfilingController implements ProfilingControllerMBean{
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
