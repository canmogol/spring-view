package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class UserView extends InternalFrame {

    private JTextArea textArea;

    public UserView() {
        super(200, 400, 220, 10);
    }

    @Override
    public void init() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        textArea.setColumns(40);
        textArea.setText("log:\n");
        panel.add(textArea);

        JButton button = new JButton();
        button.setText("Open AddressView");
        button.addActionListener(getListener());
        panel.add(button);

        add(panel);
    }

    public void addAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.textArea.append(address + "\n");
        }
    }

}
