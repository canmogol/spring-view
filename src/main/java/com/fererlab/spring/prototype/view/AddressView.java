package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.prototype.model.AddressModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressView extends SwingInternalFrame implements ActionListener {

    private static int count = 0;

    private JButton createAddressButton = new JButton();
    private JTextField addressField = new JTextField();

    public AddressView() {
        // set dimensions and location
        super(250, 100, 540 + (count * 300), 10);
        setTitle("Address View #" + count);
        setLocation(430, 10 + (count * 100));
        setId(count);
        count++;

        // create UI
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(addressField);
        createAddressButton.setText("Create Address");
        createAddressButton.addActionListener(this);
        panel.add(createAddressButton);
        add(panel);
        try {
            System.out.println("AddressView creating super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        // do something time consuming
        try {
            System.out.println("AddressView initializing super heavy UI " + getId());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (createAddressButton.equals(e.getSource())) {
            AddressModel addressModel = new AddressModel(addressField.getText());
            getListener().actionPerformed(addressModel);
            addressField.setText("");
        }
    }
}
