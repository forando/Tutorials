package com.tutorials.reflection;

/**
 * Created by Andreylogoshko on 17.02.2017.
 */
public class AnnotationProcessor {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }

    static void inspectService(Class<?> service){
        if (service.isAnnotationPresent(Service.class)) {
            Service annotation = service.getAnnotation(Service.class);
            System.out.println("annotation name: " + annotation.name());
        }
    }
}
