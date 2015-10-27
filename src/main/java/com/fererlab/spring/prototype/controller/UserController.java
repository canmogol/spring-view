package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.app.util.CallBack;
import com.fererlab.spring.prototype.view.UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserController extends BaseController implements CallBack {

    private List<AddressController> freeAddressControllers;
    private UserView view;

    @Override
    public void init() {
        super.init();
        view = (UserView) getView();
        view.getOpenAddressButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddressView();
            }
        });
    }

    private void openAddressView() {
        if (freeAddressControllers.size() > 0) {
            AddressController controller = freeAddressControllers.remove(0);
            controller.setCallBack(this);
            controller.init();
        }
    }

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
            view.addAddress(address);
        }
    }
}
