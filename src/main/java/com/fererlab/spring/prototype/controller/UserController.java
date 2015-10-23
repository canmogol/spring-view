package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.app.util.CallBack;
import com.fererlab.spring.prototype.view.UserView;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UserController extends BaseController implements CallBack {

    private List<AddressController> freeAddressControllers;

    public List<AddressController> getAddressControllerList() {
        return new ArrayList<>(freeAddressControllers);
    }

    public void setAddressControllerList(List<AddressController> addressControllers) {
        this.freeAddressControllers = addressControllers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (freeAddressControllers.size() > 0) {
            AddressController controller = freeAddressControllers.remove(0);
            controller.setCallBack(this);
            controller.init();
        }
    }

    @Override
    public void call(Object o) {
        if (o instanceof String) {
            String address = (String) o;
            UserView userView = (UserView) getView();
            userView.addAddress(address);
        }
    }
}
