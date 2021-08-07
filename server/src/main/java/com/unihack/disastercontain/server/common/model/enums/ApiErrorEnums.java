package com.unihack.disastercontain.server.common.model.enums;

public enum ApiErrorEnums {
	
	WRONG_INPUT("Please check your input."),
	INTERNAL_ERROR("Congratulation! You encountered somthing we have never met.");
	
	
	private String value;
	private ApiErrorEnums(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public String getErrorMessage() {
		return this.value;
	}
}
