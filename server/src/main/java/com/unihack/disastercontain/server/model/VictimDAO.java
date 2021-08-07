package com.unihack.disastercontain.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name="victims")
public class VictimDAO extends InitialPojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter private Long id;
	@Getter @Setter private String reporterName;
	@Getter @Setter private String reporterPhoneNumber;
	@Getter @Setter private float locationLongitude;
	@Getter @Setter private float locationLatitude;
	@Getter @Setter private int numberOfPeople;
	@Getter @Setter private int severity;
	@Getter @Setter private String description;

}
