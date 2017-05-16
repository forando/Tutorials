package com.tutorials.spring.quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyCreatedContextListener implements ApplicationListener<ContextRefreshedEvent> {

    /*
    Мы здесь делаем Coupling: то есть в Spring инжектим Spring. Это допускается
     */
    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    /**
     * контекст закончил своё построение
     */
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            /*
            Мы не можем сейчас сделать так: .getBean(name).getClass(), потому что на этом этапе там будет proxy
            Поетому нужна главная фабрика спринга ConfigurableListableBeanFactory
             */
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getMethods();
                for (Method methodOriginal : methods) {
                    if (methodOriginal.isAnnotationPresent(PostProxy.class)){
                        /*
                        Здесь мы не можем сделать methodOriginal.invoke(), так как это исходный класс,
                        а нам надо дергнуть такойже метод у proxy
                         */
                        Object beanProxy = context.getBean(name);
                        Method methodProxy = beanProxy.getClass().getMethod(methodOriginal.getName(),
                                methodOriginal.getParameterTypes());
                        methodProxy.invoke(beanProxy);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
