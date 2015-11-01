package com.fererlab.module.prototype.view.fx;

import com.fererlab.app.fx.ui.FxInternalFrame;
import com.fererlab.core.model.Model;
import com.fererlab.module.prototype.model.AddressModel;
import com.fererlab.module.prototype.model.GenerateNewAddressModel;
import com.fererlab.module.prototype.model.PredefinedAddress;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddressView extends FxInternalFrame {

    private VBox panel;
    private TextField addressField;

    @Override
    public void init() {
        if (panel == null) {
            // create UI
            panel = new VBox();
            this.getChildren().add(panel);

            addressField = new TextField();
            panel.getChildren().add(addressField);

            Button createAddressButton = new Button();
            createAddressButton.setText("Create Address");
            createAddressButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    AddressModel addressModel = new AddressModel(addressField.getText());
                    getActionListener().actionPerformed(addressModel);
                    addressField.setText("");
                }
            });

            panel.getChildren().add(createAddressButton);

            Button generateNewAddressText = new Button();
            generateNewAddressText.setText("Generate Address");
            generateNewAddressText.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    GenerateNewAddressModel generateNewAddressModel = new GenerateNewAddressModel();
                    getActionListener().actionPerformed(generateNewAddressModel);
                }
            });
            panel.getChildren().add(generateNewAddressText);

            try {
                System.out.println("AddressView creating super heavy UI " + getId());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

}
