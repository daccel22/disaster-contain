package com.unihack.disastercontain.server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unihack.disastercontain.server.model.FloodDAO;

@Repository
@Transactional
public interface FloodRepository extends CrudRepository<FloodDAO, Long> {
	
	public List<FloodDAO> findAll();

	public Optional<FloodDAO> findById(Long floodId);
	
}
