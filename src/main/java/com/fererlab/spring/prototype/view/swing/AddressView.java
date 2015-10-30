package com.fererlab.spring.prototype.view.swing;

import com.fererlab.spring.core.model.Model;
import com.fererlab.spring.prototype.model.AddressModel;
import com.fererlab.spring.prototype.model.GenerateNewAddressModel;
import com.fererlab.spring.prototype.model.PredefinedAddress;
import com.fererlab.spring.swingapp.ui.SwingInternalFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressView extends SwingInternalFrame {

    private static int count = 0;

    private JTextField addressField = new JTextField();

    public AddressView() {
        // set dimensions and location
        super(250, 200, 540 + (count * 300), 10);
        setTitle("Address View #" + count);
        setLocation(430, 10 + (count * 200));
        setId(count);
        count++;

        // create UI
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(addressField);

        JButton createAddressButton = new JButton();
        createAddressButton.setText("Create Address");
        createAddressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddressModel addressModel = new AddressModel(addressField.getText());
                getListener().actionPerformed(addressModel);
                addressField.setText("");
            }
        });
        panel.add(createAddressButton);

        JButton generateNewAddressText = new JButton();
        generateNewAddressText.setText("Generate Address");
        generateNewAddressText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateNewAddressModel generateNewAddressModel = new GenerateNewAddressModel();
                getListener().actionPerformed(generateNewAddressModel);
            }
        });
        panel.add(generateNewAddressText);

        add(panel);
        try {
            System.out.println("AddressView creating super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void notify(Model model) {
        super.notify(model);
        if(model instanceof PredefinedAddress){
            PredefinedAddress predefinedAddress = (PredefinedAddress) model;
            addressField.setText(predefinedAddress.getAddress());
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

}
