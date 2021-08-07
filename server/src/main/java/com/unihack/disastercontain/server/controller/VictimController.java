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

import com.unihack.disastercontain.server.common.model.VictimResponseDTO;
import com.unihack.disastercontain.server.model.VictimInputDTO;
import com.unihack.disastercontain.server.service.VictimService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Victim Control")
public class VictimController extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private VictimService victimService;
	
	@PostMapping(value = "/victims")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> writeSingleVictim(@RequestBody VictimInputDTO victimInputDTO) {
		return victimService.writeVictim2Table(victimInputDTO);
	}
	
	@DeleteMapping(value = "/victims/{victimId}")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> deleteSingleVictim(@PathVariable Long victimId) {
		return victimService.deleteVictim(victimId);
	}
	
	@GetMapping(value = "/victims/{victimId}")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> getSingleVictim(@PathVariable Long victimId) {
		return victimService.exportSingleFlood(victimId);
	}
	
	@GetMapping(value = "/victims")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> getAllVictims() {
		return victimService.exportAllVictims();
	}
	
	@PutMapping(value = "/victims/{victimId}/severity")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> updateVictimSeverity(@PathVariable Long victimId, @RequestParam int severity) {
		return victimService.updateVictimSeverity(victimId, severity);
	}
	
	@PutMapping(value = "/victims/{victimId}/reporterPhoneNumber")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> updateVictimReporterPhoneNumber(@PathVariable Long victimId, @RequestParam String reporterPhoneNumber) {
		return victimService.updateVictimReporterPhoneNumber(victimId, reporterPhoneNumber);
	}
	
	@PutMapping(value = "/victims/{victimId}/numberOfPeople")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> updateVictimNumber(@PathVariable Long victimId, @RequestParam int numberOfPeople) {
		return victimService.updateVictimNumber(victimId, numberOfPeople);
	}
	
	@PutMapping(value = "/victims/{victimId}/location")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> updateVictimLocation(@PathVariable Long victimId, @RequestParam float locationLongitude, @RequestParam float locationLatitude) {
		return victimService.updateVictimLocation(victimId, locationLongitude, locationLatitude);
	}
	
	@PutMapping(value = "/victims/{victimId}/description")
	@ResponseBody
	public ResponseEntity<VictimResponseDTO> updateVictimDescription(@PathVariable Long victimId, @RequestParam String description) {
		return victimService.updateVictimDescription(victimId, description);
	}
}
