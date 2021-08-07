package com.unihack.disastercontain.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unihack.disastercontain.server.Repository.FloodRepository;
import com.unihack.disastercontain.server.common.model.FloodResponseDTO;
import com.unihack.disastercontain.server.common.model.enums.ApiErrorEnums;
import com.unihack.disastercontain.server.model.FloodDAO;
import com.unihack.disastercontain.server.model.FloodInputDTO;

@Service
public class FloodService {
	
	@Autowired
	private FloodRepository floodRepository;
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private ModelService modelService;
	
	/**
	 * Save the flood info to the DB flood table
	 * @param flood
	 */
	public ResponseEntity<FloodResponseDTO> writeFlood2Table(FloodInputDTO flood) {
		try {
			floodRepository.save(modelService.floodInputDTO2FloodDAO(flood));
			return responseService.createFloodNotReadResponse();
		} catch (Exception e) {
			return createFloodNotFoundErrorResponse();
		}
	}
	
	/**
	 * Find and export single flood info based on given flood id
	 * @param floodId
	 * @return the flood
	 */
	public ResponseEntity<FloodResponseDTO> exportSingleFlood(Long floodId) {
		Optional<FloodDAO> floodDAO = floodRepository.findById(floodId);
		if(floodDAO.isEmpty()) return createFloodNotFoundErrorResponse();
		List<FloodDAO> floodDAOs = new ArrayList<>();
		floodDAOs.add(floodDAO.get());
		return responseService.createFloodReadResponse(modelService.floodDAOs2FloodOutputDTOs(floodDAOs));
	}
	
	/**
	 * Export all floods data inside the DB flood table
	 * @return a list of flood
	 */
	public ResponseEntity<FloodResponseDTO> exportAllFloods() {
		return responseService.createFloodReadResponse(modelService.floodDAOs2FloodOutputDTOs(floodRepository.findAll()));
	}
	
	/**
	 * Delete flood data from DB flood table based on given flood id
	 * @param floodId
	 */
	public ResponseEntity<FloodResponseDTO> deleteFlood(Long floodId) {
		try {
			floodRepository.deleteById(floodId);
			return responseService.createFloodNotReadResponse();
		} catch (Exception e) {
			return createFloodNotFoundErrorResponse();
		}
	}
	
	/**
	 * Update flood quantity info
	 * @param floodId
	 * @param quantity
	 */
	public ResponseEntity<FloodResponseDTO> updateFloodQuantity(Long floodId, float quantity) {
		Optional<FloodDAO> floodDAO = floodRepository.findById(floodId);
		if(floodDAO.isEmpty()) return createFloodNotFoundErrorResponse();
		FloodDAO flood = floodDAO.get();
		flood.setQuantity(quantity);
		floodRepository.save(flood);
		return responseService.createFloodNotReadResponse();
	}
	
	/**
	 * Update flood position info
	 * @param floodId
	 * @param startLocationLongitude
	 * @param startLocationLatitude
	 * @param endLocationLongitude
	 * @param endLocationLatitude
	 */
	public ResponseEntity<FloodResponseDTO> updateFloodPosition(Long floodId, float startLocationLongitude, 
			float startLocationLatitude, float endLocationLongitude, float endLocationLatitude) {
		Optional<FloodDAO> floodDAO = floodRepository.findById(floodId);
		if(floodDAO.isEmpty()) return createFloodNotFoundErrorResponse();
		FloodDAO flood = floodDAO.get();
		flood.setStartLocationLongitude(startLocationLongitude);
		flood.setStartLocationLatitude(startLocationLatitude);
		flood.setEndLocationLongitude(endLocationLongitude);
		flood.setEndLocationLatitude(endLocationLatitude);
		floodRepository.save(flood);
		return responseService.createFloodNotReadResponse();
	}
	
	/**
	 * Create a not found error response for flood service
	 * @return
	 */
	private  ResponseEntity<FloodResponseDTO> createFloodNotFoundErrorResponse() {
		return responseService.createFloodErrorResponse(ApiErrorEnums.WRONG_INPUT, new NullPointerException("Flood Info not found."), HttpStatus.NOT_FOUND);
	}
	
}
