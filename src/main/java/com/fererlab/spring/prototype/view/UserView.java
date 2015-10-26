package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.prototype.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends SwingInternalFrame implements ActionListener {

    private JTextArea textArea;
    private JButton openAddressViewButton;

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

        openAddressViewButton = new JButton();
        openAddressViewButton.setText("Open AddressView");
        openAddressViewButton.addActionListener(this);
        panel.add(openAddressViewButton);

        add(panel);
    }

    public void addAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.textArea.append(address + "\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (openAddressViewButton.equals(e.getSource())) {
            getListener().actionPerformed(new UserModel());
        }
    }
}
