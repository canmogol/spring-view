package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.app.controller.BaseController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddressController extends BaseController  {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getClientProperty(JTextField.class) != null) {
                JTextField addressField = (JTextField) button.getClientProperty(JTextField.class);
                String address = addressField.getText();
                addressField.setText("");
                getCallBack().call(address);
            }
        }
    }

}
