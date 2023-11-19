package com.teste.api.exception;

public class RepositoryNotInjectedException extends Exception {

	  public RepositoryNotInjectedException(String message) {
	      super(message);
	  }

	  public RepositoryNotInjectedException(String message, Throwable cause) {
	      super(message, cause);
	  }

	  public RepositoryNotInjectedException(Throwable cause) {
	      super(cause);
	  }
	}

