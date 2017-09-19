package com.itmei.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaodan on 2017/9/14.
 */
public class Button {
    private boolean clicked;

    private List<Observer> listeners;

    public List<Observer> getListeners() {

        if (this.listeners == null) {

            this.listeners = new ArrayList<Observer>();
        }

        return this.listeners;
    }

    public void addListener(Observer observer) {

        getListeners().add(observer);

    }

    public boolean wasClicked() {

        return this.clicked;

    }

    public void clickOn() {

        this.clicked = true;

        informAll();

    }

    private void informAll() {

        for (Observer observer : getListeners()) {

            observer.informAboutEvent();

        }

    }
}
