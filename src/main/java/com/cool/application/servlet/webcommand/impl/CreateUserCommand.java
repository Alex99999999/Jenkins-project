package com.cool.application.servlet.webcommand.impl;

import com.cool.application.builder.userbuilder.AbstractUserBuilder;
import com.cool.application.builder.userbuilder.HttpUserBuilder;
import com.cool.application.entity.User;
import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    userService.createUser(user);
    req.setAttribute(GlobalAttributes.USER, user);
    return String.format("user?command=%s&id=%d", UserOperations.GET_USER_BY_ID, user.getId());
  }

}
