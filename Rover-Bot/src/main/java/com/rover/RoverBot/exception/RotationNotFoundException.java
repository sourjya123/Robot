package com.rover.RoverBot.exception;

public class RotationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String errorCode;
	String errorMessage;

	public RotationNotFoundException(String message, String code) {
		super(message);
		errorMessage = message;
		errorCode = code;
	}

	public RotationNotFoundException(BotErrorCode errorCode, String... param) {
		this(String.format(errorCode.getErrorDesc(), param), errorCode.getErrorCode());
	}
}
