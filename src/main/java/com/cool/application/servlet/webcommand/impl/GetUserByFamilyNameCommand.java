package com.cool.application.servlet.webcommand.impl;

import com.cool.application.service.UserService;
import com.cool.application.entity.User;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.parameters.UserParameters;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author Bogdan
 */

public class GetUserByFamilyNameCommand implements Command {

    private final UserService userService;

    public GetUserByFamilyNameCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String name = req.getParameter(UserParameters.FAMILY_NAME);
        List<User> users = userService.getUserByFamilyName(name);
        System.out.println("GetUserByFamilyNameCommand list size" + users.size());
        req.setAttribute(GlobalAttributes.USER_LIST, users);
        return Pages.SHOW_ALL_USERS;
    }

}