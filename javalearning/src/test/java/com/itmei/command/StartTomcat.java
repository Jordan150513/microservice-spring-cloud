package com.itmei.command;

/**
 * Created by qiaodan on 2017/9/11.
 */
public class StartTomcat extends ServerCommand {
    public StartTomcat(Server server) {

        super(server);

    }

    @Override

    public void execute() {

        server.launchCommand("sudo service tomcat7 start");

    }
}
