package com.fererlab.module.prototype.view.fx;

import com.fererlab.app.fx.ui.FxInternalFrame;
import com.fererlab.core.model.Model;
import com.fererlab.module.prototype.model.AddressModel;
import com.fererlab.module.prototype.model.UserModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class UserView extends FxInternalFrame {

    private VBox panel;
    private TextArea textArea;

    @Override
    public void init() {
        if (panel == null) {
            // create UI
            panel = new VBox();
            this.getChildren().add(panel);

            textArea = new TextArea();
            textArea.setText("log:\n");
            panel.getChildren().add(textArea);
            Button openAddressViewButton = new Button();
            openAddressViewButton.setText("Open AddressView");
            openAddressViewButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    getActionListener().actionPerformed(new UserModel());
                }
            });
            panel.getChildren().add(openAddressViewButton);
        }
    }

    @Override
    public void notify(Model model) {
        super.notify(model);
        if(model instanceof AddressModel){
            AddressModel addressModel = (AddressModel) model;
            this.textArea.setText(this.textArea.getText() + addressModel.getAddressText() + "\n");
        }
    }

}
