package com.unihack.disastercontain.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unihack.disastercontain.server.Repository.VictimRepository;
import com.unihack.disastercontain.server.common.model.VictimResponseDTO;
import com.unihack.disastercontain.server.common.model.enums.ApiErrorEnums;
import com.unihack.disastercontain.server.model.VictimDAO;
import com.unihack.disastercontain.server.model.VictimInputDTO;

@Service
public class VictimService {
	
	@Autowired
	private VictimRepository victimRepository;
	
	@Autowired
	private ResponseService  responseService;
	
	@Autowired
	private ModelService modelService;
	
	/**
	 * Save the victim info to the DB victim table
	 * @param victim
	 */
	public ResponseEntity<VictimResponseDTO>  writeVictim2Table(VictimInputDTO victim) {
		try {
		victimRepository.save(modelService.victimInputDTO2VictimDAO(victim));
		return responseService.createVictimNotReadResponse();
		} catch (Exception e) {
			return createVictimNotFoundErrorResponse();
		}
	}
	
	/**
	 * Find and export single victim info based on given victim id
	 * @param victimId
	 * @return the victim
	 */
	public ResponseEntity<VictimResponseDTO> exportSingleFlood(Long victimId) {
		Optional<VictimDAO> victimDAO = victimRepository.findById(victimId);
		if(victimDAO.isEmpty()) return createVictimNotFoundErrorResponse();
		List<VictimDAO> victimDAOs = new ArrayList<>();
		victimDAOs.add(victimDAO.get());
		return responseService.createVictimReadResponse(modelService.victimDAOs2VictimOutputDTOs(victimDAOs));
	}
	
	/**
	 * Export all victims data inside the DB victim table
	 * @return a list of victim
	 */
	public ResponseEntity<VictimResponseDTO> exportAllVictims() {
		return responseService.createVictimReadResponse(modelService.victimDAOs2VictimOutputDTOs(victimRepository.findAll()));
	}
	
	/** 
	 * Delete victim data from DB victim table based on given victim id
	 * @param victimId
	 */
	public ResponseEntity<VictimResponseDTO>  deleteVictim(Long victimId) {
		try {
			victimRepository.deleteById(victimId);
			return responseService.createVictimNotReadResponse();
		} catch (Exception e) {
			return createVictimNotFoundErrorResponse();
		}
	}
	
	/**
	 * Update victim severity info
	 * @param victimId
	 * @param severity
	 */
	public ResponseEntity<VictimResponseDTO> updateVictimSeverity(Long victimId, int severity) {
		Optional<VictimDAO> victimDAO = victimRepository.findById(victimId);
		if(victimDAO.isEmpty()) return createVictimNotFoundErrorResponse();
		VictimDAO victim = victimDAO.get();
		victim.setSeverity(severity);
		victimRepository.save(victim);
		return responseService.createVictimNotReadResponse();
	}
	
	/**
	 * Update victim reporter phone number info
	 * @param victimId
	 * @param reporterPhoneNumber
	 */
	public ResponseEntity<VictimResponseDTO> updateVictimReporterPhoneNumber(Long victimId, String reporterPhoneNumber) {
		Optional<VictimDAO> victimDAO = victimRepository.findById(victimId);
		if(victimDAO.isEmpty()) return createVictimNotFoundErrorResponse();
		VictimDAO victim = victimDAO.get();
		victim.setReporterPhoneNumber(reporterPhoneNumber);
		victimRepository.save(victim);
		return responseService.createVictimNotReadResponse();
	}
	
	/** 
	 * Update victim number of people info
	 * @param victimId
	 * @param numberOfPeople
	 */
	public ResponseEntity<VictimResponseDTO> updateVictimNumber(Long victimId, int numberOfPeople) {
		Optional<VictimDAO> victimDAO = victimRepository.findById(victimId);
		if(victimDAO.isEmpty()) return createVictimNotFoundErrorResponse();
		VictimDAO victim = victimDAO.get();
		victim.setNumberOfPeople(numberOfPeople);
		victimRepository.save(victim);
		return responseService.createVictimNotReadResponse();
	}
	
	/**
	 * Update victim location info
	 * @param victimId
	 * @param locationLongitude
	 * @param locationLatitude
	 */
	public ResponseEntity<VictimResponseDTO> updateVictimLocation(Long victimId, float locationLongitude, float locationLatitude) {
		Optional<VictimDAO> victimDAO = victimRepository.findById(victimId);
		if(victimDAO.isEmpty()) return createVictimNotFoundErrorResponse();
		VictimDAO victim = victimDAO.get();
		victim.setLocationLongitude(locationLongitude);
		victim.setLocationLatitude(locationLatitude);
		victimRepository.save(victim);
		return responseService.createVictimNotReadResponse();
	}
	
	/**
	 * Update victim description info
	 * @param victimId
	 * @param description
	 */
	public ResponseEntity<VictimResponseDTO> updateVictimDescription(Long victimId, String description) {
		Optional<VictimDAO> victimDAO = victimRepository.findById(victimId);
		if(victimDAO.isEmpty()) return createVictimNotFoundErrorResponse();
		VictimDAO victim = victimDAO.get();
		victim.setDescription(description);
		victimRepository.save(victim);
		return responseService.createVictimNotReadResponse();
	}
	
	/**
	 * Create a not found error response for victim service
	 * @return the response
	 */
	private ResponseEntity<VictimResponseDTO> createVictimNotFoundErrorResponse() {
		return responseService.createVictimErrorResponse(ApiErrorEnums.WRONG_INPUT, new NullPointerException("Victim Info not found."), HttpStatus.NOT_FOUND);
	}
	
}
