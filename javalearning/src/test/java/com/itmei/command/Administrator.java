package com.itmei.command;

/**
 * Created by qiaodan on 2017/9/11.
 */
public class Administrator {
    private ServerCommand command;

    public void setCommand(ServerCommand command) {

        this.command = command;

    }

    public void typeEnter() {

        this.command.execute();

    }
}
