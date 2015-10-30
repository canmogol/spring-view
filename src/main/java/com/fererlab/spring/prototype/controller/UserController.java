package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.core.controller.BaseController;
import com.fererlab.spring.core.model.AlertMessage;
import com.fererlab.spring.core.model.Model;
import com.fererlab.spring.core.common.CallBack;
import com.fererlab.spring.prototype.model.UserModel;
import com.fererlab.spring.prototype.view.swing.UserView;

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
    public void call(Object o) {
        if (o instanceof String) {
            String address = (String) o;
            UserView userView = (UserView) getView();
            userView.addAddress(address);
        }
    }

    @Override
    public void actionPerformed(Model model) {
        if (model instanceof UserModel) {
            if (freeAddressControllers.size() > 0) {
                AddressController controller = freeAddressControllers.remove(0);
                controller.setCallBack(this);
                controller.init();
            } else {
                getView().notify(new AlertMessage("No free address available"));
            }
        }
    }
}
