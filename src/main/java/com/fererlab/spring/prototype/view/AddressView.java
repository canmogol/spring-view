package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressView extends InternalFrame {

    private static int count = 0;

    public AddressView() {
        super(250, 80, 540 + (count * 300) , 10);
    }

    @Override
    public void init() {
        setTitle("Address View #" + count);
        setLocation(430, 10 + (count * 100));
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
        count++;
    }
}
