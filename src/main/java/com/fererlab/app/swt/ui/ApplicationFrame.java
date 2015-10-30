package com.fererlab.app.swt.ui;

import com.fererlab.core.common.UIListener;
import com.fererlab.core.view.View;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationFrame implements ApplicationListener, UIListener {

    @Override
    public void showView(View view) {

    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
        }
    }
}
