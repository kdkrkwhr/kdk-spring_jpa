package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
	@Query(value = "SELECT COUNT(no) FROM members", nativeQuery = true)
	int memberCount();
	
	@Query(value = "SELECT no, email, pwd, name, phone, address FROM members WHERE email=:email AND pwd=:pwd", nativeQuery = true)
	Members memberLogin(@Param("email") String email, @Param("pwd") String pwd);
}