package com.unihack.disastercontain.server.common.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Original ResponseDTO which could be extended by all other responseDTO of ledger
 *
 * @author Yi Chen
 * Copyright © 2021 MyKaarma. All rights reserved.
 */
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private List<ApiError> errors;
	
	@Override
	public String toString() {
		 try {
			 return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
