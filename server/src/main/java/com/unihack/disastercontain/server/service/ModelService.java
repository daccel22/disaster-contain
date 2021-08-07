package com.unihack.disastercontain.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unihack.disastercontain.server.model.FloodDAO;
import com.unihack.disastercontain.server.model.FloodInputDTO;
import com.unihack.disastercontain.server.model.FloodOutputDTO;
import com.unihack.disastercontain.server.model.VictimDAO;
import com.unihack.disastercontain.server.model.VictimInputDTO;
import com.unihack.disastercontain.server.model.VictimOutputDTO;

@Service
public class ModelService {
	
	/**
	 * Convert from FloodInputDTO to FloodDAO
	 * @param floodInputDTO
	 * @return the corresponding FloodDAO
	 */
	public FloodDAO floodInputDTO2FloodDAO(FloodInputDTO floodInputDTO) {
		FloodDAO floodDAO =  new FloodDAO();
		floodDAO.setStartLocationLongitude(floodInputDTO.getStartLocationLongitude());
		floodDAO.setStartLocationLatitude(floodInputDTO.getStartLocationLatitude());
		floodDAO.setEndLocationLongitude(floodInputDTO.getEndLocationLongitude());
		floodDAO.setEndLocationLatitude(floodInputDTO.getEndLocationLatitude());
		floodDAO.setQuantity(floodInputDTO.getQuantity());
		return floodDAO;
	}
	
	/**
	 * Convert from VictimInputDTO to victimDAO
	 * @param victimInputDTO
	 * @return the corresponding VictimDAO
	 */
	public VictimDAO victimInputDTO2VictimDAO(VictimInputDTO victimInputDTO) {
		VictimDAO victimDAO = new VictimDAO();
		victimDAO.setReporterName(victimInputDTO.getReporterName());
		victimDAO.setReporterPhoneNumber(victimInputDTO.getReporterPhoneNumber());
		victimDAO.setNumberOfPeople(victimInputDTO.getNumberOfPeople());
		victimDAO.setLocationLongitude(victimInputDTO.getLocationLongitude());
		victimDAO.setLocationLatitude(victimInputDTO.getLocationLatitude());
		victimDAO.setSeverity(victimInputDTO.getSeverity());
		victimDAO.setDescription(victimInputDTO.getDescription());
		return victimDAO;
	}
	
	/**
	 * Convert from FloodDAO to FloodOutputDTO
	 * @param floodDAO
	 * @return the corresponding FloodOutputDTO
	 */
	public FloodOutputDTO floodDAO2FloodOutputDTO(FloodDAO floodDAO) {
		return new FloodOutputDTO(floodDAO.getId(), floodDAO.getStartLocationLongitude(), floodDAO.getStartLocationLatitude(), 
				floodDAO.getEndLocationLongitude(), floodDAO.getEndLocationLatitude(), floodDAO.getQuantity());
	}
	
	/**
	 * Convert from VictimDAO to VictimOutputDTO
	 * @param victimDAO
	 * @return the corresponding VictimOutputDTO
	 */
	public VictimOutputDTO victimDAO2VictimOutputDTO(VictimDAO victimDAO) {
		return new VictimOutputDTO(victimDAO.getId(), victimDAO.getReporterName(), victimDAO.getReporterPhoneNumber(), victimDAO.getLocationLongitude(), 
				victimDAO.getLocationLatitude(), victimDAO.getNumberOfPeople(), victimDAO.getSeverity(), victimDAO.getDescription());
	}
	
	/**
	 * Convert a list of FloadDAOs to a list of FloodOutputDTOs
	 * @param floodDAOs
	 * @return the list of FloodOutputDTOs
	 */
	public List<FloodOutputDTO> floodDAOs2FloodOutputDTOs(List<FloodDAO> floodDAOs) {
		List<FloodOutputDTO> floodOutputDTOs = new ArrayList<>();
		for(int i = 0; i < floodDAOs.size(); i++) {
			floodOutputDTOs.add(floodDAO2FloodOutputDTO(floodDAOs.get(i)));
		}
		return floodOutputDTOs;
	}
	
	/**
	 * Convert a list of VictimDAOs to a list of VictimOutputDTOs
	 * @param victimDAOs
	 * @return the list of VictimOutputDTOs
	 */
	public List<VictimOutputDTO> victimDAOs2VictimOutputDTOs(List<VictimDAO> victimDAOs) {
		List<VictimOutputDTO> victimOutputDTOs = new ArrayList<>();
		for(int i = 0; i < victimDAOs.size(); i++) {
			victimOutputDTOs.add(victimDAO2VictimOutputDTO(victimDAOs.get(i)));
		}
		return victimOutputDTOs;
	}
}
