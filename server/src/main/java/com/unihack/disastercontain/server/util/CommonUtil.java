package com.unihack.disastercontain.server.util;

import org.springframework.stereotype.Service;

import com.unihack.disastercontain.server.common.model.ApiError;


@Service
public class CommonUtil {
	
	/**
	 * Create an error object with corresponding code and description
	 * @param code
	 * @param description
	 * @return an error object
	 */
	public ApiError createErrorObject(String code, String description) {
		ApiError error = new ApiError();
		error.setErrorCode(code);
		error.setErrorDescription(description);
		return error;
	}
}
