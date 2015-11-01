package com.fererlab.module.prototype.controller;

import com.fererlab.core.controller.BaseController;
import com.fererlab.core.model.AlertMessage;
import com.fererlab.core.model.Model;
import com.fererlab.core.common.CallBack;
import com.fererlab.module.prototype.model.AddressModel;
import com.fererlab.module.prototype.model.UserModel;

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
            getView().notify(new AddressModel(address));
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
