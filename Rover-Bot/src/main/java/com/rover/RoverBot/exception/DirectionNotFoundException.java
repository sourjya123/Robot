package com.rover.RoverBot.exception;

public class DirectionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorCode;
	String errorMessage;

	public DirectionNotFoundException(String message, String code) {
		super(message);
		errorMessage = message;
		errorCode = code;
	}

	public DirectionNotFoundException(BotErrorCode errorCode, String... param) {
		this(String.format(errorCode.getErrorDesc(), param), errorCode.getErrorCode());
	}

}
