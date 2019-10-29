package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {}