package com.cool.application.servlet.webcommand.impl;

import com.cool.application.builder.userbuilder.AbstractUserBuilder;
import com.cool.application.builder.userbuilder.HttpUserBuilder;
import com.cool.application.entity.User;
import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Author Artem
 */

public class CreateUserCommand implements Command {

  private final UserService userService;

  public CreateUserCommand(UserService userService) {
    this.userService = userService;
  }

  @Override
  public String execute(HttpServletRequest req) {
    AbstractUserBuilder builder = new HttpUserBuilder(req);
    User user = builder.buildUserWithAllFields();
    System.out.println("Http user " + user);
    userService.createUser(user);
    System.out.println("CreateUserCommand -> "  + "user created");
    req.setAttribute(GlobalAttributes.USER, user);
    return String.format("user?command=%s", UserOperations.GET_ALL_USERS.getName());

  }

}
