package com.itmei.command;

/**
 * Created by qiaodan on 2017/9/11.
 */
public class StartApache extends ServerCommand {
    public StartApache(Server server) {

        super(server);

    }

    @Override

    public void execute() {

        server.launchCommand("sudo service apache2 start");

    }
}
