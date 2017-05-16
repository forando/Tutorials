package com.tutorials.reflection;

@Service(name ="Lazy_Service")
public class LazyService {
    @Init
    public void lazyInit()throws Exception {
        System.out.println("LazyService has been initialized");
    }
}
