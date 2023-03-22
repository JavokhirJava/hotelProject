package org.example.container;

import org.example.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentContainer {
    public static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
}
