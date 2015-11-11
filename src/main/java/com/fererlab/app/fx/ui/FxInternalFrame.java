package com.fererlab.app.fx.ui;

import com.fererlab.core.common.ActionListener;
import com.fererlab.core.model.AlertMessage;
import com.fererlab.core.model.Model;
import com.fererlab.core.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class FxInternalFrame extends Pane implements View {

    private ActionListener actionListener;

    public ActionListener getActionListener() {
        return actionListener;
    }

    @Override
    public void notify(Model model) {
        if (model instanceof AlertMessage) {
            AlertMessage alertMessage = (AlertMessage) model;
            final Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UTILITY);
            Text alertText = new Text(alertMessage.getMessage());
            Button okButton = new Button();
            okButton.setText("OK");
            okButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                }
            });
            VBox group = new VBox();
            group.getChildren().addAll(alertText, okButton);
            Scene scene = new Scene(group);
            dialog.setScene(scene);
            dialog.show();
        }
    }

    @Override
    public void setId(Object id) {
        super.setId(String.valueOf(id));
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
