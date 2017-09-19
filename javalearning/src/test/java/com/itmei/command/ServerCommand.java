package com.itmei.command;

/**
 * Created by qiaodan on 2017/9/11.
 */
public abstract class ServerCommand {
    protected Server server;

    public ServerCommand(Server server) {

        this.server = server;

    }

    public abstract void execute();
}
