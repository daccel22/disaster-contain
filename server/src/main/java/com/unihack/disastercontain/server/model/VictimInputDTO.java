package com.unihack.disastercontain.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class VictimInputDTO extends InitialPojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter@Setter private String reporterName;
	@Getter @Setter private String reporterPhoneNumber;
	@Getter @Setter private float locationLongitude;
	@Getter @Setter private float locationLatitude;
	@Getter @Setter private int numberOfPeople;
	@Getter @Setter private int severity;
	@Getter @Setter private String description;
	
}
