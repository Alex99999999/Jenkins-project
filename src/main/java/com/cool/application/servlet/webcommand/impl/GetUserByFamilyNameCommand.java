package com.cool.application.servlet.webcommand.impl;

import com.cool.application.builder.userbuilder.AbstractUserBuilder;
import com.cool.application.builder.userbuilder.HttpUserBuilder;
import com.cool.application.service.UserService;
import com.cool.application.entity.User;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Author Bogdan
 */

public class GetUserByFamilyNameCommand implements Command {

    private UserService userService;

    public GetUserByFamilyNameCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        AbstractUserBuilder builder = new HttpUserBuilder(req);
        String name = req.getParameter("family_name");
        User user = userService.getUserByName(name);
        req.setAttribute(GlobalAttributes.USER,user);
        return Pages.USER_DETAILS_PAGE;
    }

}
