package ua.dev.shopservice.exception;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException() {
  }

  public UserNotFoundException(String errorMessage) {
    super(errorMessage);
  }

  public UserNotFoundException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
