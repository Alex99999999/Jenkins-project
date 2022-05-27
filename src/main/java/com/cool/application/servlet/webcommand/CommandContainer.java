package com.cool.application.servlet.webcommand;

import com.cool.application.context.ApplicationContext;
import com.cool.application.servlet.webcommand.impl.DefaultCommand;
import com.cool.application.servlet.webcommand.impl.GetUserByIdCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private Map<String, Command> commands;
    ApplicationContext applicationContext;

    public CommandContainer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public CommandContainer() {
        populateCommands();
    }

    public Command getCommand(String command) {
        return commands.getOrDefault(command, new DefaultCommand());
    }

    private void populateCommands() {
        commands = new HashMap<>();
        commands.put("get_by_id", new GetUserByIdCommand(applicationContext.getUserService()));
    }


}
