package com.fererlab.spring.swingapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml", "SwingViews.xml"});
    }

}
