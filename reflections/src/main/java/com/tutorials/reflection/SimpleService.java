package com.tutorials.reflection;

@Service(name ="Simple_Service")
public class SimpleService {
    @Init
    public void initService(){
        System.out.println("SimpleService has been initialized");
    }

    public void anotherMethod(){
        System.out.println("SimpleService another method");
    }
}
