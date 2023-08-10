-- --------------------------------------------------------
-- 호스트:                          3.35.159.211
-- 서버 버전:                        10.3.38-MariaDB-0ubuntu0.20.04.1 - Ubuntu 20.04
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- travel 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `travel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `travel`;

-- 테이블 travel.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `brd_no` int(11) NOT NULL AUTO_INCREMENT,
  `cnt` int(11) NOT NULL,
  `content` longtext DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `cate_no` int(11) NOT NULL,
  `reg_date` datetime(6) DEFAULT current_timestamp(6),
  `title` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `vote_no` int(11) NOT NULL,
  PRIMARY KEY (`brd_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.board:~4 rows (대략적) 내보내기
DELETE FROM `board`;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` (`brd_no`, `cnt`, `content`, `file_name`, `cate_no`, `reg_date`, `title`, `user_id`, `vote_no`) VALUES
	(1, 0, '111', NULL, 1, NULL, '11', NULL, 0),
	(2, 0, '222', NULL, 1, NULL, '22', NULL, 0),
	(3, 0, '삼삼삼삼삼', NULL, 1, NULL, '삼삼', NULL, 0),
	(4, 0, '항공4444444', NULL, 2, NULL, '항공444', NULL, 0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;

-- 테이블 travel.categorie 구조 내보내기
CREATE TABLE IF NOT EXISTS `categorie` (
  `cate_no` int(11) NOT NULL AUTO_INCREMENT,
  `cate_detail` varchar(20) DEFAULT NULL,
  `cate_name` varchar(20) DEFAULT NULL,
  `user_type_cd` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`cate_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.categorie:~0 rows (대략적) 내보내기
DELETE FROM `categorie`;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;

-- 테이블 travel.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `pro_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '상품번호',
  `pro_continent` varchar(20) DEFAULT NULL COMMENT '대륙',
  `pro_country` varchar(20) DEFAULT NULL COMMENT '나라',
  `pro_city` varchar(20) DEFAULT NULL COMMENT '도시',
  `pro_name` varchar(50) DEFAULT NULL COMMENT '상품이름',
  `pro_airplane` varchar(10) DEFAULT NULL COMMENT '항공편',
  `pro_departure` datetime DEFAULT NULL COMMENT '출발일',
  `pro_arrive` datetime DEFAULT NULL COMMENT '도착일',
  `pro_plan` int(4) NOT NULL COMMENT '기간',
  `pro_adult` int(3) NOT NULL COMMENT '성인가격',
  `pro_minor` int(3) NOT NULL COMMENT '소인가격',
  `pro_seat` int(3) NOT NULL COMMENT '잔여상품수',
  PRIMARY KEY (`pro_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.product:~0 rows (대략적) 내보내기
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 테이블 travel.product_detail 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_detail` (
  `detail_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '게시글번호',
  `pro_no` int(11) NOT NULL COMMENT '상품번호',
  `detail_info` varchar(100) DEFAULT NULL COMMENT '상품정보',
  `detail_image` varchar(255) DEFAULT NULL COMMENT '상품대표이미지',
  `schedule` varchar(5) DEFAULT NULL COMMENT '일정',
  `detail_viewcnt` varchar(4) DEFAULT NULL COMMENT '조회수',
  PRIMARY KEY (`detail_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.product_detail:~0 rows (대략적) 내보내기
DELETE FROM `product_detail`;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;

-- 테이블 travel.qna 구조 내보내기
CREATE TABLE IF NOT EXISTS `qna` (
  `qna_no` int(11) NOT NULL AUTO_INCREMENT,
  `qna_content` text DEFAULT NULL,
  `qna_title` varchar(40) DEFAULT NULL,
  `reg_date` datetime DEFAULT current_timestamp(),
  `cnt` int(11) NOT NULL DEFAULT 0,
  `user_id` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`qna_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.qna:~0 rows (대략적) 내보내기
DELETE FROM `qna`;
/*!40000 ALTER TABLE `qna` DISABLE KEYS */;
/*!40000 ALTER TABLE `qna` ENABLE KEYS */;

-- 테이블 travel.reservation 구조 내보내기
CREATE TABLE IF NOT EXISTS `reservation` (
  `rev_num` int(11) NOT NULL AUTO_INCREMENT,
  `pro_num` int(11) NOT NULL,
  `rev_adult` int(11) NOT NULL,
  `rev_minor` int(11) NOT NULL,
  `rev_name` varchar(50) DEFAULT NULL,
  `rev_phone` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rev_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.reservation:~0 rows (대략적) 내보내기
DELETE FROM `reservation`;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;

-- 테이블 travel.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(11) NOT NULL,
  `auth_id` varchar(2) NOT NULL DEFAULT '02',
  `user_addr` varchar(50) DEFAULT NULL,
  `user_daddr` varchar(50) DEFAULT NULL,
  `user_cp` varchar(20) DEFAULT NULL,
  `user_email` varchar(20) DEFAULT NULL,
  `user_grade` varchar(2) DEFAULT NULL,
  `user_name` varchar(10) DEFAULT NULL,
  `user_pwd` varchar(100) DEFAULT NULL,
  `user_type_cd` varchar(2) DEFAULT NULL,
  `user_gender` varchar(5) DEFAULT NULL COMMENT '01:남자 02:여자',
  `user_birth` varchar(10) DEFAULT NULL,
  `reg_date` datetime DEFAULT current_timestamp(),
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_AUTH_ID` (`auth_id`),
  CONSTRAINT `FK_AUTH_ID` FOREIGN KEY (`auth_id`) REFERENCES `user_auth` (`auth_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.user:~5 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `auth_id`, `user_addr`, `user_daddr`, `user_cp`, `user_email`, `user_grade`, `user_name`, `user_pwd`, `user_type_cd`, `user_gender`, `user_birth`, `reg_date`, `update_date`) VALUES
	('admin', '01', NULL, NULL, NULL, NULL, 'A', NULL, '5994471ABB01112AFCC18159F6CC74B4F511B99806DA59B3CAF5A9C173CACFC5', '01', NULL, NULL, '2023-08-09 16:16:08', NULL),
	('rain', '02', '경기도안산', '이게될까', '01000000000', 'rain@tan.com', NULL, '이게될까', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', NULL, 'male', '', NULL, NULL),
	('rain12', '02', '경기도안산시단원구', '선부동', '010000000000', 'oopop@naver.com', NULL, '김재규', '123456', NULL, 'male', '', NULL, NULL),
	('test00', '02', '경기도', '시흥', '00000000000', 'test@test.com', NULL, '김재규', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', NULL, 'male', '', NULL, NULL),
	('testing', '02', NULL, NULL, NULL, NULL, NULL, NULL, '12345', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 travel.user_auth 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_auth` (
  `auth_id` varchar(2) NOT NULL,
  `auth_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 travel.user_auth:~2 rows (대략적) 내보내기
DELETE FROM `user_auth`;
/*!40000 ALTER TABLE `user_auth` DISABLE KEYS */;
INSERT INTO `user_auth` (`auth_id`, `auth_name`) VALUES
	('01', 'ROLE_ADMIN'),
	('02', 'ROLE_USER');
/*!40000 ALTER TABLE `user_auth` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
