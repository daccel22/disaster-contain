package com.unihack.disastercontain.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unihack.disastercontain.server.common.model.FloodResponseDTO;
import com.unihack.disastercontain.server.model.FloodInputDTO;
import com.unihack.disastercontain.server.service.FloodService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Flood Control")
public class FloodController extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FloodService floodService;
	
	@PostMapping(value = "/floods")
	@ResponseBody
	public ResponseEntity<FloodResponseDTO> writeSingleFlood(@RequestBody FloodInputDTO floodInputDTO) {
		return floodService.writeFlood2Table(floodInputDTO);
	}
	
	@DeleteMapping(value = "/floods/{floodId}")
	@ResponseBody
	public ResponseEntity<FloodResponseDTO> deleteSingleFlood(@PathVariable Long floodId) {
		return floodService.deleteFlood(floodId);
	}
	
	@GetMapping(value = "/floods/{floodId}")
	@ResponseBody
	public ResponseEntity<FloodResponseDTO> getSingleFlood(@PathVariable Long floodId) {
		return floodService.exportSingleFlood(floodId);
	}
	
	@GetMapping(value = "/floods")
	@ResponseBody
	public ResponseEntity<FloodResponseDTO> getAllFloods() {
		return floodService.exportAllFloods();
	}
	
	@PutMapping(value = "/floods/{floodId}/quantity")
	@ResponseBody
	public ResponseEntity<FloodResponseDTO> updateFloodQuantity(@PathVariable Long floodId, @RequestParam float quantity) {
		return floodService.updateFloodQuantity(floodId, quantity);
	}
	
	@PutMapping(value = "/floods/{floodId}/position")
	@ResponseBody
	public ResponseEntity<FloodResponseDTO> updateFloodPosition(@PathVariable Long floodId, @RequestParam float startLocationLongitude, @RequestParam float startLocationLatitude, 
			@RequestParam float endLocationLongitude, @RequestParam float endLocationLatitude) {
		return floodService.updateFloodPosition(floodId, startLocationLongitude, startLocationLatitude, endLocationLongitude, endLocationLatitude);
	}
	
}
