package com.fererlab.spring.core.controller;

import com.fererlab.spring.core.view.View;
import com.fererlab.spring.core.common.CallBack;

public interface Controller {

    View getView();

    void init();

    void setCallBack(CallBack callBack);

}
