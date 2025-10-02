-- MySQL dump 10.13  Distrib 8.0.42, for macos15 (arm64)
--
-- Host: localhost    Database: my_db
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `art_t`
--

DROP TABLE IF EXISTS `art_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `art_t` (
  `art_idx` bigint NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `type` varchar(30) DEFAULT NULL,
  `price` decimal(9,2) DEFAULT NULL,
  `make_year` varchar(20) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  PRIMARY KEY (`art_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `art_t`
--

LOCK TABLES `art_t` WRITE;
/*!40000 ALTER TABLE `art_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `art_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bbs`
--

DROP TABLE IF EXISTS `bbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bbs` (
  `b_idx` bigint NOT NULL AUTO_INCREMENT,
  `write_date` varchar(255) DEFAULT NULL,
  `hit` bigint DEFAULT '0',
  `state` bigint DEFAULT '0',
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `writer` varchar(255) NOT NULL,
  PRIMARY KEY (`b_idx`),
  KEY `idx_bbs_writer` (`writer`),
  KEY `idx_bbs_write_date` (`write_date`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bbs`
--

LOCK TABLES `bbs` WRITE;
/*!40000 ALTER TABLE `bbs` DISABLE KEYS */;
INSERT INTO `bbs` VALUES (1,'25. 9. 24. 오후 4:30',0,0,'title1','content1','writer1'),(2,'25. 9. 24. 오후 4:30',0,0,'title2','content2','writer2'),(3,'25. 9. 24. 오후 4:30',0,0,'title3','content3','writer3'),(4,'25. 9. 24. 오후 4:30',0,0,'title1','content1','writer1'),(5,'25. 9. 24. 오후 4:30',0,0,'title2','content2','writer2'),(6,'25. 9. 24. 오후 4:30',0,0,'title3','content3','writer3'),(7,'25. 9. 24. 오후 4:31',0,0,'title1','content1','writer1'),(8,'25. 9. 24. 오후 4:31',0,0,'title2','content2','writer2'),(9,'25. 9. 24. 오후 4:31',0,0,'title3','content3','writer3'),(10,'25. 9. 24. 오후 4:32',0,0,'title1','content1','writer1'),(11,'25. 9. 24. 오후 4:32',0,0,'title2','content2','writer2'),(12,'25. 9. 24. 오후 4:32',0,0,'title3','content3','writer3'),(13,'25. 9. 24. 오후 4:33',0,0,'title1','content1','writer1'),(14,'25. 9. 24. 오후 4:33',0,0,'title2','content2','writer2'),(15,'25. 9. 24. 오후 4:33',0,0,'title3','content3','writer3'),(16,'25. 9. 24. 오후 4:34',0,0,'title1','content1','writer1'),(17,'25. 9. 24. 오후 4:34',0,0,'title2','content2','writer2'),(18,'25. 9. 24. 오후 4:34',0,0,'title3','content3','writer3'),(19,'25. 9. 24. 오후 4:37',0,0,'title1','content1','writer1'),(20,'25. 9. 24. 오후 4:37',0,0,'title2','content2','writer2'),(21,'25. 9. 24. 오후 4:37',0,0,'title3','content3','writer3'),(22,'25. 9. 24. 오후 5:53',0,0,'title1','content1','writer1'),(23,'25. 9. 24. 오후 5:53',0,0,'title2','content2','writer2'),(24,'25. 9. 24. 오후 5:53',0,0,'title3','content3','writer3'),(25,'25. 9. 24. 오후 5:55',0,0,'title1','content1','writer1'),(26,'25. 9. 24. 오후 5:55',0,0,'title2','content2','writer2'),(27,'25. 9. 24. 오후 5:55',0,0,'title3','content3','writer3'),(28,'25. 9. 24. 오후 5:55',0,0,'title1','content1','writer1'),(29,'25. 9. 24. 오후 5:55',0,0,'title2','content2','writer2'),(30,'25. 9. 24. 오후 5:55',0,0,'title3','content3','writer3');
/*!40000 ALTER TABLE `bbs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bbs_t`
--

DROP TABLE IF EXISTS `bbs_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bbs_t` (
  `b_idx` bigint NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) DEFAULT NULL,
  `writer` varchar(20) DEFAULT NULL,
  `content` text,
  `file_name` varchar(50) DEFAULT NULL,
  `ori_name` varchar(50) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `write_date` date DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `hit` int DEFAULT NULL,
  `bname` varchar(20) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`b_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bbs_t`
--

LOCK TABLES `bbs_t` WRITE;
/*!40000 ALTER TABLE `bbs_t` DISABLE KEYS */;
INSERT INTO `bbs_t` VALUES (1,'테스트','마루치','<p>안녕</p>',NULL,NULL,'1111','2025-07-22','192.168.0.58',7,'BBS',0),(2,'test','세트','<p>ㅁㄴㅇㄹ1234</p>',NULL,NULL,NULL,'2025-07-23','0:0:0:0:0:0:0:1',5,'BBS',0),(3,'테스트23','세트라','<p>ㅁㄴㅇㄹㅁㄴㄹㅇ</p>',NULL,NULL,NULL,'2025-07-23','0:0:0:0:0:0:0:1',8,'BBS',0),(4,'테스트12345','화용','<p>ㅁㄴㅇㄹㄴㅁㅇㄹ</p>','Gwd94MSbEAQd02n1.jpeg','Gwd94MSbEAQd02n.jpeg',NULL,'2025-07-23','0:0:0:0:0:0:0:1',19,'BBS',0),(5,'테스트123','장박','<p>123124124123</p>',NULL,NULL,NULL,'2025-07-23','0:0:0:0:0:0:0:1',0,'BBS',1),(6,'졸려','장태','<p>1234</p>',NULL,NULL,NULL,'2025-07-23','0:0:0:0:0:0:0:1',0,'BBS',1),(7,'배고파요','조화','<p>1234567</p>',NULL,NULL,NULL,'2025-07-23','0:0:0:0:0:0:0:1',29,'BBS',0),(8,'asdf1234','1234','<p>asdfasdasd</p>','GvGEmB7XcAEeq4r.jpeg','GvGEmB7XcAEeq4r.jpeg',NULL,'2025-07-23','0:0:0:0:0:0:0:1',63,'BBS',0),(9,'qwerasdfa1234','ten','<p>12314asdfagera</p>',NULL,NULL,NULL,'2025-07-23','0:0:0:0:0:0:0:1',105,'BBS',0),(10,'asdfa','tein','<p>asdfafasdf</p>','GvGEmB7XcAEeq4r1.jpeg','GvGEmB7XcAEeq4r.jpeg',NULL,'2025-07-24','0:0:0:0:0:0:0:1',5,'BBS',0),(11,'asdfasd','zxcvzxv','asdfasf',NULL,NULL,NULL,'2025-08-29','0:0:0:0:0:0:0:1',0,'BBS',0),(12,'asdf','zxcv','12312321',NULL,NULL,NULL,'2025-08-29','0:0:0:0:0:0:0:1',2,'BBS',0),(13,'zxcv','asdf','asdf',NULL,NULL,NULL,'2025-08-29','0:0:0:0:0:0:0:1',2,'BBS',0),(14,'asdfad','zxcvz','zxcvzxc',NULL,NULL,NULL,'2025-08-29','0:0:0:0:0:0:0:1',2,'BBS',0),(15,'asfd','zxcvz','zxvcxz','f3f618117fcf4984b337b7c506f110f0.png',NULL,NULL,'2025-08-29','0:0:0:0:0:0:0:1',2,'BBS',0),(16,'asdf','asfd','<p>zxcvzxc</p>','f3f618117fcf4984b337b7c506f110f0.png',NULL,NULL,'2025-09-01','0:0:0:0:0:0:0:1',18,'BBS',0),(17,'asdf','zxcv','<p>asdfasdf</p>','5349630_17557575538797_big (1).jpg','5349630_17557575538797_big (1).jpg',NULL,'2025-09-08','0:0:0:0:0:0:0:1',3,'BBS',0),(18,'asdf','zxcv','<p>asdfasdf</p>','5349630_17557575538797_big (1).jpg','5349630_17557575538797_big (1).jpg',NULL,'2025-09-08','0:0:0:0:0:0:0:1',1,'BBS',0),(19,'asdf','zxcv','<p>asdfasdf</p>','5349630_17557575538797_big (1).jpg','5349630_17557575538797_big (1).jpg',NULL,'2025-09-08','0:0:0:0:0:0:0:1',3,'BBS',0),(20,'asdf','zxcv','<p>asdfasdf</p>','5349630_17557575538797_big (1).jpg','5349630_17557575538797_big (1).jpg',NULL,'2025-09-08','0:0:0:0:0:0:0:1',1,'BBS',0),(21,'zxcvqwer','zxcv','<p>vadnb<img style=\"width: 482.789px;\" src=\"/resources/editor_img/1210100_4_5001.jpg\"></p>','16cc90d5b46f4ea3b4576bdcc14efedd.jpg','16cc90d5b46f4ea3b4576bdcc14efedd.jpg',NULL,'2025-09-08','0:0:0:0:0:0:0:1',7,'BBS',0),(22,'로ㅓㅡ,,asdfasdf123','ㅎ,ㅗㅓ','<p><img style=\"width: 482.789px;\" src=\"/resources/editor_img/5349626_17557575290287_big (1).jpg\"></p><p>asfdasdfasdf</p>','1210100_4_500.jpg','1210100_4_500.jpg',NULL,'2025-09-08','0:0:0:0:0:0:0:1',26,'BBS',0),(23,NULL,NULL,NULL,NULL,NULL,NULL,'2025-09-17',NULL,0,NULL,0),(24,NULL,NULL,NULL,NULL,NULL,NULL,'2025-09-17',NULL,0,NULL,0),(25,NULL,NULL,NULL,NULL,NULL,NULL,'2025-09-17',NULL,0,NULL,0),(26,NULL,NULL,NULL,NULL,NULL,NULL,'2025-09-17',NULL,0,NULL,0),(27,NULL,NULL,NULL,NULL,NULL,NULL,'2025-09-17',NULL,0,NULL,0),(28,'테스트제목','테스트작성자','테스트내용',NULL,NULL,NULL,'2025-09-17','127.0.0.1',0,'BBS',0),(29,'JSON테스트제목','JSON테스트작성자','JSON테스트내용',NULL,NULL,NULL,'2025-09-17',NULL,0,'BBS',0),(30,'ㅁㄴㅇㄹ','ㅋㅌㅊㅍㅍㅋㅌㅊ','ㅁㄴㅇㄹㄹㅁ',NULL,NULL,NULL,'2025-09-17',NULL,0,'BBS',0),(31,'1234','asdf','zxcvv',NULL,NULL,NULL,'2025-09-17',NULL,0,'BBS',0);
/*!40000 ALTER TABLE `bbs_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_t`
--

DROP TABLE IF EXISTS `book_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_t` (
  `b_idx` bigint NOT NULL AUTO_INCREMENT,
  `subject` varchar(200) DEFAULT NULL,
  `author` varchar(60) DEFAULT NULL,
  `press` varchar(50) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `price` decimal(9,1) DEFAULT NULL,
  PRIMARY KEY (`b_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_t`
--

LOCK TABLES `book_t` WRITE;
/*!40000 ALTER TABLE `book_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category1_t`
--

DROP TABLE IF EXISTS `category1_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category1_t` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) DEFAULT NULL,
  `desc` varchar(45) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category1_t`
--

LOCK TABLES `category1_t` WRITE;
/*!40000 ALTER TABLE `category1_t` DISABLE KEYS */;
INSERT INTO `category1_t` VALUES (1,'그림','명화,드로우',0),(2,'사진','풍경사진',0),(3,'조각','석고',0);
/*!40000 ALTER TABLE `category1_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category1_t_seq`
--

DROP TABLE IF EXISTS `category1_t_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category1_t_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category1_t_seq`
--

LOCK TABLES `category1_t_seq` WRITE;
/*!40000 ALTER TABLE `category1_t_seq` DISABLE KEYS */;
INSERT INTO `category1_t_seq` VALUES (1);
/*!40000 ALTER TABLE `category1_t_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_t`
--

DROP TABLE IF EXISTS `comment_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_t` (
  `c_idx` bigint NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) DEFAULT NULL,
  `content` text,
  `pwd` varchar(20) DEFAULT NULL,
  `write_date` date DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `b_idx` bigint DEFAULT NULL,
  PRIMARY KEY (`c_idx`),
  KEY `comm_t_fk` (`b_idx`),
  CONSTRAINT `comm_t_fk` FOREIGN KEY (`b_idx`) REFERENCES `bbs_t` (`b_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_t`
--

LOCK TABLES `comment_t` WRITE;
/*!40000 ALTER TABLE `comment_t` DISABLE KEYS */;
INSERT INTO `comment_t` VALUES (1,'test','dkssud',NULL,'2025-07-23',NULL,7),(2,'test2','1234123',NULL,'2025-07-23',NULL,7),(3,'tein','1234','1234','2025-07-23','0:0:0:0:0:0:0:1',7),(4,'tein','1234','1234','2025-07-23','0:0:0:0:0:0:0:1',7),(5,'tein','1234123','1234','2025-07-23','0:0:0:0:0:0:0:1',4);
/*!40000 ALTER TABLE `comment_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `deptno` decimal(2,0) NOT NULL,
  `dname` varchar(14) DEFAULT NULL,
  `loc_code` int DEFAULT NULL,
  PRIMARY KEY (`deptno`),
  KEY `dept_fk_idx` (`loc_code`),
  CONSTRAINT `dept_fk` FOREIGN KEY (`loc_code`) REFERENCES `locations` (`loc_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (10,'ACCOUNTING',1),(20,'RESEARCH',2),(30,'SALES',3),(40,'OPERATIONS',1);
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `empno` decimal(4,0) NOT NULL,
  `ename` varchar(10) DEFAULT NULL,
  `job` varchar(9) DEFAULT NULL,
  `mgr` decimal(4,0) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1000,'이도','DEVELOP',NULL,'2024-04-16',810.00,NULL,20),(1200,'을불','DEVELOP',NULL,'2024-04-18',900.00,NULL,10),(1210,'이순신','DEVELOP',NULL,'2024-04-18',900.00,NULL,10),(1211,'김유신','DEVELOP',NULL,'2024-04-18',900.00,NULL,10),(1300,'마동탁','DEVELOP',NULL,'2024-04-18',900.00,NULL,10),(2000,'마루치','DEVELOP',1000,'2024-04-19',900.00,NULL,10),(2020,NULL,'dev',NULL,NULL,NULL,NULL,NULL),(2021,NULL,'dev',NULL,NULL,NULL,NULL,NULL),(2022,NULL,'dev',NULL,NULL,NULL,NULL,NULL),(2025,'qwer','develop',NULL,NULL,NULL,NULL,NULL),(2026,'qwert123','dev',NULL,'2025-01-01',NULL,NULL,NULL),(2157,'장박박','dev',NULL,'2025-07-18',NULL,NULL,NULL),(7369,'SMITH','CLERK',7902,'1980-12-17',800.00,NULL,20),(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600.00,300.00,30),(7521,'WARD','SALESMAN',7698,'1981-02-22',1250.00,500.00,30),(7566,'JONES','MANAGER',7839,'1981-04-02',2975.00,NULL,20),(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250.00,1400.00,30),(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850.00,NULL,30),(7782,'CLARK','MANAGER',7839,'1981-06-09',2450.00,NULL,10),(7788,'SCOTT','ANALYST',7566,'1982-12-09',3000.00,NULL,20),(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000.00,NULL,10),(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500.00,0.00,30),(7876,'ADAMS','CLERK',7788,'1983-01-12',1100.00,NULL,20),(7900,'JAMES','CLERK',7698,'1981-12-03',950.00,NULL,30),(7902,'FORD','ANALYST',7566,'1981-12-03',3000.00,NULL,20),(7934,'MILLER','CLERK',7782,'1982-01-23',1300.00,NULL,10);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'0','<< Flyway Baseline >>','BASELINE','<< Flyway Baseline >>',NULL,'root','2025-09-24 07:30:36',0,1),(2,'1','Create initial tables','SQL','V1__Create_initial_tables.sql',-2056428706,'root','2025-09-24 07:30:36',37,1),(3,'2','test','SQL','V2__test.sql',-341630801,'root','2025-09-24 07:32:47',37,1),(4,'3','test','SQL','V3__test.sql',815945643,'root','2025-09-24 07:34:37',50,1),(5,'4','Create test2 tables','SQL','V4__Create_test2_tables.sql',-1399003538,'root','2025-09-24 08:53:15',28,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `loc_code` int NOT NULL AUTO_INCREMENT,
  `city` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`loc_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'NEW YORK'),(2,'DALLAS'),(3,'CHICAGO'),(4,'BOSTON');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `b_idx` bigint NOT NULL AUTO_INCREMENT,
  `write_date` varchar(255) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `mpw` varchar(255) DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`b_idx`),
  KEY `idx_member_mid` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'25. 9. 24. 오후 4:30','user1','user1','$2a$10$yMmZi8VIYLVJPjKQAQtosepf53qL2ayXpaq0uQHZG0W4iGZ7H3g.m',NULL,NULL),(2,'25. 9. 24. 오후 4:30','user2','user2','$2a$10$6i.HOIhLDHvEIv9cFEtkOeUJ4ZIrvpChYfzF7mCHN/o.8ZJZphmKm',NULL,NULL),(3,'25. 9. 24. 오후 4:30','user3','user3','$2a$10$EXjJx.ggZR1RZ4w.Yx1NQeNHI23OYDYD/mQcAGNCCilITUeUHxkxi',NULL,NULL),(4,'25. 9. 24. 오후 4:30','user1','user1','$2a$10$ThTqMsYRUafDpNfXc7VMfeOWGuAMWSF4ORKrJaUpsdnjvDCl4fKwS',NULL,NULL),(5,'25. 9. 24. 오후 4:30','user2','user2','$2a$10$iOGyFbQ656PSlTMp7T4lnuFZGS6/O3jYhowMYrt..1bZ4SFBtXTcm',NULL,NULL),(6,'25. 9. 24. 오후 4:30','user3','user3','$2a$10$3HtgWfYnwvJ4LBGS9M0I2u803FeEM85kCoAs4ywPs9KqYzoTpXbYW',NULL,NULL),(7,'25. 9. 24. 오후 4:31','user1','user1','$2a$10$n1Id9sE7R3C91L.wOx1w.OnXMFq8n7m1eZyILpJMgP7oafSn7PjVW',NULL,NULL),(8,'25. 9. 24. 오후 4:31','user2','user2','$2a$10$/f..qpsH8/dPDdRjzkkc..sFWxcTdPR9UGJGuVMCPKgD6EliEpra.',NULL,NULL),(9,'25. 9. 24. 오후 4:31','user3','user3','$2a$10$UhlHSOR8jTsPO/OC8WCxe.ugKs9VNTWwGc4LLH2Nh45tzzXBnTeXm',NULL,NULL),(10,'25. 9. 24. 오후 4:32','user1','user1','$2a$10$6MbxsFaeoPCHRKuYY0JgLe4lDS5Il8rtL8ukrkMmz95JDOTcAsIXq',NULL,NULL),(11,'25. 9. 24. 오후 4:32','user2','user2','$2a$10$GrhqhstEwqS5QCrP/Q50P.qscxTHL3hAXOB8p1W6SvaM2uOMCWHom',NULL,NULL),(12,'25. 9. 24. 오후 4:32','user3','user3','$2a$10$2aGihBXfXjNFm4ZS62I08u.cOrtzUUk2ckNPRfdzCCAQTV.7gAcDy',NULL,NULL),(13,'25. 9. 24. 오후 4:33','user1','user1','$2a$10$znCpeKTgGcE6jWIkXMHEN.zt1OhTysgOZv.XYhkV/TI3.60Pi3ykC',NULL,NULL),(14,'25. 9. 24. 오후 4:33','user2','user2','$2a$10$gaMPi9yxJMgrSu43FjAWG.IqBM2g1.rx.Ea1LVt2OSFsc8ZgcWZXG',NULL,NULL),(15,'25. 9. 24. 오후 4:33','user3','user3','$2a$10$fhRPNMty7nTCjouAob50IeqBlemmYan0UEUVecFLL2E0wVqUeVf0C',NULL,NULL),(16,'25. 9. 24. 오후 4:34','user1','user1','$2a$10$npERsYfeV6GdDmgxCqDCSeuSChQhd2UuMLd.zShiK2UWDFzhUVoSa',NULL,NULL),(17,'25. 9. 24. 오후 4:34','user2','user2','$2a$10$sU5q0.AKX4fubc6uLGelle1ZMnmRIYdSttFFySluKyNF7u9db9jx2',NULL,NULL),(18,'25. 9. 24. 오후 4:34','user3','user3','$2a$10$ZqCkYRnxFAi5K6oTl.VzA.HEo3/ihCN0HxnXo.rNQ8H0u3.91IosG',NULL,NULL),(19,'25. 9. 24. 오후 4:37','user1','user1','$2a$10$YBwPzjA3epq/II6DiDCxxuptsTkCcHIcpRZrVhZaQ/LDUBgrNZSRK',NULL,NULL),(20,'25. 9. 24. 오후 4:37','user2','user2','$2a$10$v5wGwgMznBxtuPOY9zpUresOOm9L0RjExcqR2u7mqlo7TcUDvw1Ey',NULL,NULL),(21,'25. 9. 24. 오후 4:37','user3','user3','$2a$10$onrTZD/MfpmgA4.FfQrgten4xe6784IsXbuG8crBR.4M7MimXgC7O',NULL,NULL),(22,'25. 9. 24. 오후 5:53','user1','user1','$2a$10$FbIX.i6YD4xLkYM/Z82ACOoihuBGimYIfj0J57LnngLWbV1Yc7YK2',NULL,NULL),(23,'25. 9. 24. 오후 5:53','user2','user2','$2a$10$tMqnWCL3uW09ezZBcPEQiu9Nxu9traYJJJCsOaAwWduaZIK0WNbdC',NULL,NULL),(24,'25. 9. 24. 오후 5:53','user3','user3','$2a$10$kjQIeG0znUALxzvOoWywg.Cnwo.h4USEsYIiEuno5wsyVeauAttXy',NULL,NULL),(25,'25. 9. 24. 오후 5:55','user1','user1','$2a$10$CxpxnWfshLIyXX7cOB5TleDnYMInBGgiHaFOLFO/daRwhOjCBuQwy',NULL,NULL),(26,'25. 9. 24. 오후 5:55','user2','user2','$2a$10$f4ZioFgRRiwGsNQzFpYWkeAUkqbtTyDlp8UJDYRNv9jRjT7iNPLsG',NULL,NULL),(27,'25. 9. 24. 오후 5:55','user3','user3','$2a$10$uiLBi3kQsU.AlvPu6qVBKu/fVUkS3qyK5FfzL.nMWZUWR.LgLpoam',NULL,NULL),(28,'25. 9. 24. 오후 5:55','user1','user1','$2a$10$ziacPJ3.yZK.peT8uhUtYe7N5.gz9bfGyHaPGPf3qiEpVhZUY.0gi',NULL,NULL),(29,'25. 9. 24. 오후 5:55','user2','user2','$2a$10$RIwJMGaRHCcp8r7HchAt2u/pRRW9Oh/ksEoz.arWT1bLV/sdLKamu',NULL,NULL),(30,'25. 9. 24. 오후 5:55','user3','user3','$2a$10$Rke0iUSMFwzMgY8Ca.zfpOkyaDgpXeKutlQC7sU2hHCGlmqInU3wu',NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_t`
--

DROP TABLE IF EXISTS `member_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_t` (
  `m_idx` bigint NOT NULL AUTO_INCREMENT,
  `m_name` varchar(50) NOT NULL,
  `m_id` varchar(30) NOT NULL,
  `m_pw` varchar(5000) NOT NULL,
  `m_phone` varchar(20) DEFAULT NULL,
  `m_addr` varchar(50) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `status` int DEFAULT '0',
  `etc1` varchar(10) DEFAULT NULL,
  `etc2` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`m_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_t`
--

LOCK TABLES `member_t` WRITE;
/*!40000 ALTER TABLE `member_t` DISABLE KEYS */;
INSERT INTO `member_t` VALUES (1,'마동석','mads','1234','01012345678','서울','2025-01-01',0,NULL,NULL),(2,'장태인','taein','1234','010-2204-6029',NULL,NULL,0,NULL,NULL),(3,'홍길동','asdf','1111','02-123-456',NULL,'2025-07-14',0,NULL,NULL),(7,'김테스트','test','1234','02-1234-5678',NULL,'2025-07-14',0,NULL,NULL),(8,'장박박','asdfg','1234','02-123-4567',NULL,'2025-07-15',0,NULL,NULL),(10,'qwer','1q2w3e4r','$2a$10$8zw02jDGRH0AzO/xGHWvXets0UN/iXxGD8qqo6HH/h4iL/Q6O2HVK',NULL,NULL,NULL,0,NULL,NULL),(11,'asdf','asdfzxcv','$2a$10$a.iXb64J//Anaz3ljOZQBe/VYOUp4CaqSzWmSuuxea2kGlbd.OUkO',NULL,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `member_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memo_t`
--

DROP TABLE IF EXISTS `memo_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `memo_t` (
  `idx` bigint NOT NULL AUTO_INCREMENT,
  `writer` varchar(30) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=431 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memo_t`
--

LOCK TABLES `memo_t` WRITE;
/*!40000 ALTER TABLE `memo_t` DISABLE KEYS */;
INSERT INTO `memo_t` VALUES (1,'ten','test','2025-01-01',NULL),(2,'1234','tein','2025-07-11','0:0:0:0:0:0:0:1'),(3,'1234','tein','2025-07-11','0:0:0:0:0:0:0:1'),(4,'12345','tein','2025-07-11','0:0:0:0:0:0:0:1'),(5,'안녕하세요','test123','2025-07-11','0:0:0:0:0:0:0:1'),(6,'테스트12334','장태인','2025-07-11','0:0:0:0:0:0:0:1'),(7,'이 글은 테스트를 위한 글입니다.','tein','2025-07-11','0:0:0:0:0:0:0:1'),(383,'의분노','세트','2025-07-11','0:0:0:0:0:0:0:1'),(414,'webserver','apach','2025-07-11','0:0:0:0:0:0:0:1'),(415,'푸시','커밋','2025-07-11','0:0:0:0:0:0:0:1'),(416,'푸시2','커밋2','2025-07-11','0:0:0:0:0:0:0:1'),(417,'졸려졸려졸려졸려졸려졸려졸려졸려졸려졸려졸려졸려졸려졸려졸려','작성자','2025-07-14','0:0:0:0:0:0:0:1'),(418,'144','123','2025-07-14','0:0:0:0:0:0:0:1'),(419,'잠온다','졸린애','2025-07-14','0:0:0:0:0:0:0:1'),(420,'asdf','123','2025-07-14','0:0:0:0:0:0:0:1'),(421,'1234','ㅁㄴㅇ','2025-07-14','0:0:0:0:0:0:0:1'),(422,'5678','asd','2025-07-14','0:0:0:0:0:0:0:1'),(423,'1234','test','2025-07-14','0:0:0:0:0:0:0:1'),(424,'asdf','12345','2025-07-14','0:0:0:0:0:0:0:1'),(425,'마동석','asdfasfgg','2025-07-14','0:0:0:0:0:0:0:1'),(426,NULL,'1234','2025-07-14','0:0:0:0:0:0:0:1'),(427,'asdf','qwerasdf','2025-08-28','0:0:0:0:0:0:0:1'),(428,'123asdf','asdf1234','2025-08-28','0:0:0:0:0:0:0:1'),(429,'가나다','라마바사','2025-08-28','0:0:0:0:0:0:0:1'),(430,'ㅁㄴㅇㄹ','<p>ㄴㅁㅇㄹㄴ</p>','2025-08-29','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `memo_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_t`
--

DROP TABLE IF EXISTS `product_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_t` (
  `p_num` bigint NOT NULL,
  `category1` int NOT NULL,
  `category2` int NOT NULL,
  `category3` int NOT NULL,
  `p_company` varchar(255) DEFAULT NULL,
  `p_name` varchar(255) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  PRIMARY KEY (`p_num`),
  KEY `FK6qguu3nwa03a6h9enqyx90pjk` (`category1`),
  CONSTRAINT `FK6qguu3nwa03a6h9enqyx90pjk` FOREIGN KEY (`category1`) REFERENCES `category1_t` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_t`
--

LOCK TABLES `product_t` WRITE;
/*!40000 ALTER TABLE `product_t` DISABLE KEYS */;
INSERT INTO `product_t` VALUES (1,3,0,0,'Art Company','빈센트 아몬드나무',NULL),(2,1,0,0,'Art Company','빈센트 해바라기',NULL),(3,2,0,0,'Art Company','빈센트 무궁화',NULL),(102,1,2,3,'애플','아이폰 17','2025-09-10');
/*!40000 ALTER TABLE `product_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_t_seq`
--

DROP TABLE IF EXISTS `product_t_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_t_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_t_seq`
--

LOCK TABLES `product_t_seq` WRITE;
/*!40000 ALTER TABLE `product_t_seq` DISABLE KEYS */;
INSERT INTO `product_t_seq` VALUES (201);
/*!40000 ALTER TABLE `product_t_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_t`
--

DROP TABLE IF EXISTS `sales_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_t` (
  `s_idx` bigint NOT NULL AUTO_INCREMENT,
  `art_idx` bigint NOT NULL,
  `m_idx` bigint NOT NULL,
  `start_date` date DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`s_idx`),
  KEY `sales_t_fk1` (`art_idx`),
  KEY `sales_t_fk2` (`m_idx`),
  CONSTRAINT `sales_t_fk1` FOREIGN KEY (`art_idx`) REFERENCES `art_t` (`art_idx`),
  CONSTRAINT `sales_t_fk2` FOREIGN KEY (`m_idx`) REFERENCES `member_t` (`m_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_t`
--

LOCK TABLES `sales_t` WRITE;
/*!40000 ALTER TABLE `sales_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_T`
--

DROP TABLE IF EXISTS `shop_T`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_T` (
  `num` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(10) NOT NULL,
  `p_num` varchar(10) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `p_company` varchar(50) NOT NULL,
  `p_price` bigint NOT NULL,
  `p_saleprice` bigint NOT NULL,
  `p_image_s` varchar(50) DEFAULT NULL,
  `p_image_l` varchar(50) DEFAULT NULL,
  `p_content` varchar(4000) NOT NULL,
  `p_date` date NOT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_T`
--

LOCK TABLES `shop_T` WRITE;
/*!40000 ALTER TABLE `shop_T` DISABLE KEYS */;
INSERT INTO `shop_T` VALUES (1,'sp003','RC-113','로체스 인라인','로체스',3200,1150,'pds1.jpg','pds1_z.jpg','바이오맥스 통풍 나일론-HGPU SHELL * 특수 충격 흡수 밑창 * 신발끈 메모리 버클 * 힐 락에 의한 신속한 신발끈 시스템 * 느린 메모리 포말에 의한 편안한 통풍성의 숨쉬는 라이너 * 쿨 통풍 시스템 * 통풍성의 인체공학적 신발밑창 * 손쉬운 엔트리 시스템(신기 편한 입구) * 몰디드 알루미늄 프레임 * 80mm 82a hyper dubbs 휠 * 강철 스페이서 * ABEC-5 베어링','2025-07-16'),(2,'ele002','vC-13','사니PDP-TV','사니',9200,4750,'pds4.jpg','pds4_z.jpg','질러~ 질러! \n무조건 질러봐~ 후회 하지 않아~~','2025-07-16'),(3,'ele002','vC-111','LG 디오스 오브제컬렉션','LG전자',2000000,1820000,'dios_s.PNG','dios_l.PNG','자주 먹는 음료, 우리아이 간식, 엄마와 아빠의 건강주스와 맥주 등을 보관하여 냉장고를 편리하게 사용할 수 있는 마법의 공간입니다.','2025-07-16');
/*!40000 ALTER TABLE `shop_T` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_test_name` (`name`),
  KEY `idx_test_age` (`age`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test2`
--

DROP TABLE IF EXISTS `test2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test2` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_test_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test2`
--

LOCK TABLES `test2` WRITE;
/*!40000 ALTER TABLE `test2` DISABLE KEYS */;
/*!40000 ALTER TABLE `test2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-25 10:52:46
