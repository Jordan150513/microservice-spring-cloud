package com.itmei.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaodan on 2017/9/11.
 */
public class Server {
    // as in common terminals, we store executed commands in history

    private List<String> executedCommands = new ArrayList<String>();

    public void launchCommand(String command) {

        System.out.println("Executing: "+command+" on server");

        this.executedCommands.add(command);

    }

    public List<String> getExecutedCommands() {

        return this.executedCommands;

    }
}
