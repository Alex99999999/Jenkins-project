package com.cool.application.exception.user;

public class UserCreateFailureException extends RuntimeException{

  public UserCreateFailureException(String message) {
    super(message);
  }
}
