package com.unihack.disastercontain.server.common.model;

import java.io.Serializable;

import com.unihack.disastercontain.server.common.model.enums.ApiErrorEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ApiError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String errorCode;
	@Getter @Setter private String errorDescription;
	
	public ApiError(ApiErrorEnums errorEnum) {
		this.errorCode = errorEnum.name();
		this.errorDescription = errorEnum.getValue();
	}
	
}

