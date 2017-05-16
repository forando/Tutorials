package com.tutorials.spring.screensaver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.tutorials.spring.screensaver")
public class Config {

    /**
     * periodical это кастомный скоуп, написаный нами.
     */
    @Bean
    @Scope("periodical")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                /*
                color() это не вызов метода, а обращение к бину color
                 */
                return color();
            }
        };
    }
}
