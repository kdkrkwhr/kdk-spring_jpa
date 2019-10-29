package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

	@Query(value = "SELECT COUNT(*) FROM sample.test", nativeQuery = true)
	int dataCnt();

}