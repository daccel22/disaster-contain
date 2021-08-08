package com.unihack.disastercontain.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class FloodInputDTO extends InitialPojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private float startLocationLongitude;
	@Getter @Setter private float startLocationLatitude;
	@Getter @Setter private float endLocationLongitude;
	@Getter @Setter private float endLocationLatitude;
	@Getter @Setter private float quantity;
}
