-- TEST BOARD --
CREATE TABLE `board` (
  `board_no` int(11) NOT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `member_no` int(11) DEFAULT NULL,
  `total_person_cnt` varchar(45) DEFAULT NULL,
  `communication` varchar(200) DEFAULT NULL,
  `reg_date` varchar(50) DEFAULT NULL,
  `member_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`board_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- TEST MEMBERS --
CREATE TABLE `members` (
  `no` int(11) NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pwd` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;