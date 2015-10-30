package com.fererlab.app.swing;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwingMain {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("ApplicationContext.xml", "Swing.xml");
    }

}
