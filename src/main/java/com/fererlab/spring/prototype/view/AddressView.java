package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class AddressView extends InternalFrame {

    private static int count = 0;
    private JTextField addressTextField;
    private JButton createAddressButton;

    public AddressView() {
        // set position and dimension
        super(250, 100, 540 + (count * 300) , 10);
        setTitle("Address View #" + count);
        setLocation(430, 10 + (count * 100));
        setId(count);
        count++;

        // create UI elements
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        addressTextField = new JTextField();
        panel.add(addressTextField);
        createAddressButton = new JButton();
        createAddressButton.setText("Create Address");
        createAddressButton.putClientProperty(JTextField.class, addressTextField);
        panel.add(createAddressButton);
        add(panel);

        // wait for a second to simulate heavy UI creation
        try {
            System.out.println("AddressView creating super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        // do something time consuming, like WS request
        try {
            System.out.println("AddressView initializing super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public JButton getCreateAddressButton() {
        return createAddressButton;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }
}
