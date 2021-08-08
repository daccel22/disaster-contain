package com.unihack.disastercontain.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unihack.disastercontain.server.common.model.ApiError;
import com.unihack.disastercontain.server.common.model.FloodResponseDTO;
import com.unihack.disastercontain.server.common.model.VictimResponseDTO;
import com.unihack.disastercontain.server.common.model.enums.ApiErrorEnums;
import com.unihack.disastercontain.server.model.FloodOutputDTO;
import com.unihack.disastercontain.server.model.VictimOutputDTO;
import com.unihack.disastercontain.server.util.CommonUtil;

@Service
public class ResponseService {
	
	@Autowired
	private CommonUtil commonUtil;
	
	/**
	 * A response for a successful flood read operation
	 * @param floods
	 * @return the response
	 */
	public ResponseEntity<FloodResponseDTO> createFloodReadResponse(List<FloodOutputDTO> floods) {
		FloodResponseDTO response = new FloodResponseDTO(floods);
		response.setErrors(null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * A response for a successful victim read operation
	 * @param floods
	 * @return the response
	 */
	public ResponseEntity<VictimResponseDTO> createVictimReadResponse(List<VictimOutputDTO> victims) {
		VictimResponseDTO response = new VictimResponseDTO(victims);
		response.setErrors(null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * A response for a successful flood write/update/delete operation
	 * @param floods
	 * @return the response
	 */
	public ResponseEntity<FloodResponseDTO> createFloodNotReadResponse() {
		FloodResponseDTO response = new FloodResponseDTO(null);
		response.setErrors(null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * A response for a successful victim write/update/delete operation
	 * @param floods
	 * @return the response
	 */
	public ResponseEntity<VictimResponseDTO> createVictimNotReadResponse() {
		VictimResponseDTO response = new VictimResponseDTO(null);
		response.setErrors(null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * An error response for a failed flood operation
	 * @param error
	 * @param e
	 * @param status
	 * @return the response
	 */
	public ResponseEntity<FloodResponseDTO> createFloodErrorResponse(ApiErrorEnums error, Exception e, HttpStatus status) {
		FloodResponseDTO response = new FloodResponseDTO(null);
		ApiError errorObject =  commonUtil.createErrorObject(error.name(), error.getErrorMessage()+" "+e.getMessage());
		List<ApiError> errors = new ArrayList<>();
		errors.add(errorObject);
		response.setErrors(errors);
		return new ResponseEntity<>(response, status);
	}
	
	/**
	 * An error response for a failed victim operation
	 * @param error
	 * @param e
	 * @param status
	 * @return the response
	 */
	public ResponseEntity<VictimResponseDTO> createVictimErrorResponse(ApiErrorEnums error, Exception e, HttpStatus status) {
		VictimResponseDTO response = new VictimResponseDTO(null);
		ApiError errorObject =  commonUtil.createErrorObject(error.name(), error.getErrorMessage()+" "+e.getMessage());
		List<ApiError> errors = new ArrayList<>();
		errors.add(errorObject);
		response.setErrors(errors);
		return new ResponseEntity<>(response, status);
	}
}
