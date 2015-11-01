package com.fererlab.module.prototype.view.fx;

import com.fererlab.app.fx.ui.FxInternalFrame;
import com.fererlab.module.prototype.model.PrototypeModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PrototypeView extends FxInternalFrame {

    private VBox panel;

    @Override
    public void init() {
        if (panel == null) {
            panel = new VBox();
            this.getChildren().add(panel);

            Button openUserView = new Button();
            openUserView.setText("Open User View");
            openUserView.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    getActionListener().actionPerformed(new PrototypeModel());
                }
            });
            panel.getChildren().add(openUserView);
        }
    }
}
