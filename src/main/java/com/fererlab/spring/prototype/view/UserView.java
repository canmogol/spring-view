package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.prototype.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends SwingInternalFrame {

    private JTextArea textArea;

    public UserView() {
        // set dimensions and location
        super(200, 400, 220, 10);

        // create UI
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        textArea = new JTextArea();
        textArea.setColumns(40);
        textArea.setText("log:\n");
        panel.add(textArea);
        JButton openAddressViewButton = new JButton();
        openAddressViewButton.setText("Open AddressView");
        openAddressViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getListener().actionPerformed(new UserModel());
            }
        });
        panel.add(openAddressViewButton);
        add(panel);
    }

    @Override
    public void init() {
        // do something time consuming
    }

    public void addAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.textArea.append(address + "\n");
        }
    }
}
