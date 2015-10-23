package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class AddressView extends InternalFrame {

    private static int count = 0;

    public AddressView() {
        super(250, 100, 540 + (count * 300) , 10);
        setTitle("Address View #" + count);
        setLocation(430, 10 + (count * 100));
        setId(count);
        count++;
        try {
            System.out.println("AddressView creating super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        try {
            System.out.println("AddressView initializing super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField addressField = new JTextField();
        panel.add(addressField);

        JButton button = new JButton();
        button.setText("Create Address");
        button.putClientProperty(JTextField.class, addressField);
        button.putClientProperty(JTextField.class, addressField);
        button.addActionListener(getListener());
        panel.add(button);

        add(panel);
    }
}
