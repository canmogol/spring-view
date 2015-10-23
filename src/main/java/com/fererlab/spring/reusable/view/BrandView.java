package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class BrandView extends InternalFrame {

    private static int count = 0;

    public BrandView() {
        super(250, 80, 1140, 10 + (count * 300));
        setTitle("Brand View #" + count);
        setLocation(1140 + (count * 10), 10 + (count * 10));
        count++;
    }

    @Override
    public void init() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField brandField = new JTextField();
        panel.add(brandField);

        JButton button = new JButton();
        button.setText("Create Brand");
        button.putClientProperty(JTextField.class, brandField);
        button.addActionListener(getListener());
        panel.add(button);

        add(panel);
    }

}
