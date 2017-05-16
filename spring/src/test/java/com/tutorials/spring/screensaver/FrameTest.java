package com.tutorials.spring.screensaver;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FrameTest {
    @Test
    public void testFrame(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            context.getBean(ColorFrame.class).showOnRandomPlace();
        }
    }
}
