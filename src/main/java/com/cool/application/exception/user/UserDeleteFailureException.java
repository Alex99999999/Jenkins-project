package com.cool.application.exception.user;

public class UserDeleteFailureException extends RuntimeException{

  public UserDeleteFailureException(String message) {
    super(message);
  }

}
