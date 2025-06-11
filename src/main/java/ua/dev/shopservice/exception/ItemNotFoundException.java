package ua.dev.shopservice.exception;

public class ItemNotFoundException extends RuntimeException {

  public ItemNotFoundException() {
  }

  public ItemNotFoundException(String errorMessage) {
    super(errorMessage);
  }

  public ItemNotFoundException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }
}
