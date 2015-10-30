package com.fererlab.module.reusable.view.swing;

import com.fererlab.core.model.Model;
import com.fererlab.core.common.Reusable;
import com.fererlab.module.reusable.model.BrandModel;
import com.fererlab.module.reusable.model.PredefinedBrand;
import com.fererlab.app.swing.ui.SwingInternalFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends SwingInternalFrame implements Reusable {

    private static int count = 0;
    private boolean reusable = false;
    private JTextField brandField = new JTextField();

    public BrandView() {
        // set dimensions and location
        super(250, 100, 1140, 10 + (count * 300));
        setTitle("Brand View #" + count);
        setLocation(1140 + (count * 10), 10 + (count * 10));
        setId(count);
        count++;

        // create UI
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(brandField);
        JButton createBrandButton = new JButton();
        createBrandButton.setText("Create Brand");
        createBrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrandModel brandModel = new BrandModel(brandField.getText());
                getActionListener().actionPerformed(brandModel);
                brandField.setText("");
            }
        });
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
    public void notify(Model model) {
        super.notify(model);
        if(model instanceof PredefinedBrand){
            PredefinedBrand predefinedBrand = (PredefinedBrand) model;
            brandField.setText(predefinedBrand.getBrand());
        }
    }

    @Override
    public void init() {
        // do something time consuming
        try {
            System.out.println("BrandView initializing super heavy UI " + getId());
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

}
