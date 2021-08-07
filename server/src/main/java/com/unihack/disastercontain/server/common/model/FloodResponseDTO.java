package com.unihack.disastercontain.server.common.model;

import java.util.List;

import com.unihack.disastercontain.server.model.FloodOutputDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FloodResponseDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private List<FloodOutputDTO> floods;
}
