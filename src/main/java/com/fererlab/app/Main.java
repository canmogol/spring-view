package com.fererlab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("ApplicationContext.xml", "Swing.xml");
        new ClassPathXmlApplicationContext("ApplicationContext.xml", "JavaFX.xml");
    }

}
