package com.tutorials.spring.quoters;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuoterTest {


    public void seyHelloWithMBean(){
        /**
         * Анализируется и сканируется с помощью XmlBeanDefinitionReaders
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            context.getBean(Quoter.class).sayQuote();
        }
    }

    @Test
    public void ThreePhaseConstructor(){
        new ClassPathXmlApplicationContext("context.xml");
    }
}
