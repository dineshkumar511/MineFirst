package com.dk.first.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dk.first.model.employee;

public interface empRepo extends MongoRepository<employee, Integer> {

	@Query("{'name':?0}")
	List<employee> findbyname(String name);
	
	@Query(value="{'location':?0}",delete=true)
	void deletebylocation(String location);
	
	@Query(value="{'location:?0'}",delete=true)
	void deleteallbylocation(String location);
}
