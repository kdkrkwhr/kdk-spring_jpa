package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

	String boardListQuery = "SELECT" + 
			"	 board_no," + 
			"	 subject," + 
			"    content," + 
			"    CASE" +
			"      WHEN board_cat='IT' THEN 'IT & SOFTWARE'" +
			"	   WHEN board_cat = 'art'  THEN 'ART & DESIGN' END AS board_cat," +
			"    member_no," + 
			"    total_person_cnt," + 
			"    date_format(reg_date, '%Y-%m-%d %T') AS reg_date" + 
			"    FROM board WHERE board_cat = :boardCat";

	String boardSearchListQuery = "";

	@Query(value = boardListQuery, nativeQuery = true)
	List<Board> boardList(@Param("boardCat") String boardCat);

	@Query(value = boardSearchListQuery, nativeQuery = true)
	List<Board> boardSearchList(@Param("searchVal") String searchVal);
}