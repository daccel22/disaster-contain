package com.unihack.disastercontain.server.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unihack.disastercontain.server.model.VictimDAO;

@Repository
@Transactional
public interface VictimRepository extends CrudRepository<VictimDAO, Long>{

	List<VictimDAO> findAll();
}
