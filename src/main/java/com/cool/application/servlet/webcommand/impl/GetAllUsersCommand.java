package com.cool.application.servlet.webcommand.impl;

import com.cool.application.service.UserService;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;

public class GetAllUsersCommand implements Command {

  private final UserService userService;

  public GetAllUsersCommand(UserService userService) {
    this.userService = userService;
  }

  @Override
  public String execute(HttpServletRequest req) {
    return null;
  }

}
