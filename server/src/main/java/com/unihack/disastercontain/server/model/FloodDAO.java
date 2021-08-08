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
@Table(name="floods")
public class FloodDAO extends InitialPojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Getter @Setter private Long id;
	@Getter @Setter private float startLocationLongitude;
	@Getter @Setter private float startLocationLatitude;
	@Getter @Setter private float endLocationLongitude;
	@Getter @Setter private float endLocationLatitude;
	@Getter @Setter private float quantity;

}
