package com.fererlab.spring.swtapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwtMain {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("ApplicationContext.xml", "Swt.xml");
    }

}
