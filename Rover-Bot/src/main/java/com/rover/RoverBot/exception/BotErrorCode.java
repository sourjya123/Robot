package com.rover.RoverBot.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum BotErrorCode {

	DIRECTION_NOT_FOUND("5000", "Direction Not Found", "[%s] Direction not found"),
	ROTATION_NOT_FOUND("5001", "Rotation Not Found", "[%s] Rotation not found");

	private static final Map<String, BotErrorCode> resourceErrorCodeMap = new HashMap<String, BotErrorCode>();

	static {
		for (BotErrorCode resourceErrorCode : EnumSet.allOf(BotErrorCode.class))
			resourceErrorCodeMap.put(resourceErrorCode.getErrorCode(), resourceErrorCode);
	}

	private String errorCode;
	private String errorName;
	private String errorDesc;

	private BotErrorCode(String errorCode, String errorName, String errorDesc) {
		this.errorCode = errorCode;
		this.errorName = errorName;
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorName() {
		return errorName;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public static BotErrorCode get(String errorCode) {
		return resourceErrorCodeMap.get(errorCode);
	}

}
