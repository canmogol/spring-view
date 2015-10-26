package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.app.util.Reusable;
import com.fererlab.spring.reusable.model.BrandModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends SwingInternalFrame implements Reusable, ActionListener {

    private static int count = 0;
    private boolean reusable = false;
    private JButton createBrandButton = new JButton();
    private JTextField brandField = new JTextField();

    public BrandView() {
        super(250, 100, 1140, 10 + (count * 300));
        setTitle("Brand View #" + count);
        setLocation(1140 + (count * 10), 10 + (count * 10));
        setId(count);
        count++;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(brandField);
        createBrandButton.setText("Create Brand");
        createBrandButton.addActionListener(this);
        panel.add(createBrandButton);
        add(panel);

        try {
            System.out.println("BrandView creating super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        try {
            System.out.println("BrandView initializing super heavy UI " + getId());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        brandField.setText("");
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        setReusable(!visible);
    }

    @Override
    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    @Override
    public boolean isReusable() {
        return this.reusable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (createBrandButton.equals(e.getSource())) {
            getListener().actionPerformed(new BrandModel(brandField.getText()));
        }
    }
}
