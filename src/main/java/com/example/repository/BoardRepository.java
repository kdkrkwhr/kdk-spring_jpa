package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

	String boardListQuery = 
			"    SELECT" +
			"    board_no," + 
			"    subject," + 
			"    content," + 
			"    CASE" +
			"      WHEN board_cat='IT' THEN 'IT & SOFTWARE'" +
			"      WHEN board_cat = 'art' THEN 'ART & DESIGN' END AS board_cat," +
			"    member_no," + 
			"    (SELECT name FROM members WHERE no = member_no) AS member_name," + 
			"    total_person_cnt," + 
			"    communication," + 
			"    date_format(reg_date, '%Y-%m-%d %T') AS reg_date" + 
			"    FROM board WHERE board_cat = :boardCat ORDER BY board_no DESC";

	String boardSearchListQuery = 
			"    SELECT" + 
			"    board_no," + 
			"    subject," + 
			"    content," + 
			"    CASE" + 
			"      WHEN board_cat='IT' THEN 'IT & SOFTWARE'" + 
			"      WHEN board_cat = 'art' THEN 'ART & DESIGN' END AS board_cat," + 
			"    member_no," + 
			"    (SELECT name FROM members WHERE no = member_no) AS member_name," + 
			"    total_person_cnt," + 
			"    communication," + 
			"    date_format(reg_date, '%Y-%m-%d %T') AS reg_date" + 
			"    FROM board " + 
			"    WHERE subject like '%:searchVal%' " +
			"    OR content like '%:searchVal%' ORDER BY board_no DESC";

	String mainBoardListQuery = 
			"    SELECT" + 
			"    board_no," + 
			"    subject," + 
			"    content," + 
			"    CASE" + 
			"      WHEN board_cat = 'IT' THEN 'IT & SOFTWARE'" + 
			"      WHEN board_cat = 'ART' THEN 'ART & DESIGN' END AS board_cat," + 
			"    member_no," +
			"    (SELECT name FROM members WHERE no = member_no) AS member_name," + 
			"    total_person_cnt," + 
			"    communication," + 
			"    date_format(reg_date, '%Y-%m-%d %T') AS reg_date" + 
			"    FROM board ORDER BY board_no DESC LIMIT 3";

	String mainBoardCntQuery = 
			"    SELECT COUNT(board_no) FROM board WHERE reg_date > CONCAT(CURDATE(), ' ', CURTIME())" + 
			"    UNION ALL" + 
			"    SELECT COUNT(board_no) FROM board WHERE reg_date > DATE_ADD(NOW(), INTERVAL -7 DAY)" + 
			"    UNION ALL" + 
			"    SELECT COUNT(board_no) FROM board";

	String detailBoardQuery = 
			"    SELECT" + 
			"    board_no," + 
			"    subject," + 
			"    content," + 
			"    CASE" + 
			"      WHEN board_cat='IT' THEN 'IT & SOFTWARE'" + 
			"      WHEN board_cat = 'ART' THEN 'ART & DESIGN' END AS board_cat," + 
			"    member_no," +
			"    (SELECT name FROM members WHERE no = member_no) AS member_name," + 
			"    total_person_cnt," + 
			"    communication," + 
			"    date_format(reg_date, '%Y-%m-%d %T') AS reg_date" + 
			"    FROM board " + 
			"    WHERE board_no = :boardNo";

	@Query(value = boardListQuery, nativeQuery = true)
	List<Board> boardList(@Param("boardCat") String boardCat);

	@Query(value = boardSearchListQuery, nativeQuery = true)
	List<Board> boardSearchList(@Param("searchVal") String searchVal);

	@Query(value = mainBoardListQuery, nativeQuery = true)
	List<Board> mainBoardList();

	@Query(value = mainBoardCntQuery, nativeQuery = true)
	List<Integer> mainBoardCnt();

	@Query(value = detailBoardQuery, nativeQuery = true)
	Board boardDetail(@Param("boardNo") int boardNo);
}