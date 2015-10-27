package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class UserView extends InternalFrame {

    private JTextArea addressesTextArea;
    private JButton openAddressButton;

    public UserView() {
        super(200, 400, 220, 10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        addressesTextArea = new JTextArea();
        addressesTextArea.setColumns(40);
        addressesTextArea.setText("log:\n");
        panel.add(addressesTextArea);

        openAddressButton = new JButton();
        openAddressButton.setText("Open AddressView");
        panel.add(openAddressButton);

        add(panel);
    }

    @Override
    public void init() {
        // do something time consuming
    }

    public void addAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.addressesTextArea.append(address + "\n");
        }
    }

    public JButton getOpenAddressButton() {
        return openAddressButton;
    }
}
