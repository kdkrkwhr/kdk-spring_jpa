package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
	@Query(value = "SELECT COUNT(no) FROM dk.members", nativeQuery = true)
	int memberCount();
	
	@Query(value = "SELECT COUNT(no) FROM dk.members WHERE email=:email AND pwd=:pwd", nativeQuery = true)
	int memberLogin(@Param("email") String email, @Param("pwd") String pwd);
}