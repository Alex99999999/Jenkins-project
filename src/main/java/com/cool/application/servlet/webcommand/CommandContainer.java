package com.cool.application.servlet.webcommand;

import com.cool.application.context.ApplicationContext;
import com.cool.application.operations.UserOperations;
import com.cool.application.servlet.webcommand.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private Map<String, Command> commands;
    ApplicationContext applicationContext;

    public CommandContainer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        populateCommands();
    }

    public Command getCommand(String command) {
        return commands.getOrDefault(command, new DefaultCommand());
    }

    private void populateCommands() {
        commands = new HashMap<>();
        commands.put(UserOperations.UPDATE_USER.getOperationName(), new UpdateUserCommand(applicationContext.getUserService()));
        commands.put(UserOperations.GET_USER_BY_ID.getOperationName(), new GetUserByIdCommand(applicationContext.getUserService()));
        commands.put(UserOperations.CREATE_USER.getOperationName(), new CreateUserCommand(applicationContext.getUserService()));
        commands.put(UserOperations.GET_ALL_USERS.getOperationName(), new GetAllUsersCommand((applicationContext.getUserService())));
        commands.put(UserOperations.GET_USER_BY_NAME.getOperationName(), new GetUserByFamilyNameCommand((applicationContext.getUserService())));
        commands.put(UserOperations.DELETE_USER.getOperationName(), new DeleteUserCommand(applicationContext.getUserService()));

    }

}
