package com.tutorials.spring.quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostprocessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<String, Class>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostprocessor() throws Exception {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class))
            map.put(beanName, beanClass);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null)
            /*
            newProxyInstance() создаёт объект из нового класса, который сгенерит сам же на лету.
            Params:
            ClassLoader - с помощью которого наш сгенерированый на лету класс (proxy) будет
            загружен либо в Permanent Generation (если это Java7) либо в Heap (если это Java 8).
            Список интерфейсов - который должен будет имплементировать наш proxy.
            InvocationHandler - некий объект который инкапсулирует ту логику, которую нужно
            инжектить во все методы нашего proxy.
             */
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (controller.isEnabled()) {
                        System.out.println("Профилирую...");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        System.out.println("ИТОГО времени: " + (after - before));
                        System.out.println("Всё!");
                        return retVal;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
        return bean;
    }
}
