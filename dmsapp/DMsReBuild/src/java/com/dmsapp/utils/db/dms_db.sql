# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             dms_db
# Server version:       5.0.45-community-nt
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.1 RC1 Revision: 1064
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'dms_db'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "dms_db" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "dms_db";


#
# Table structure for table 'attendance_master'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "attendance_master" (
  "id" int(11) NOT NULL auto_increment,
  "year" varchar(2) default NULL,
  "branch" varchar(20) default NULL,
  "semister" varchar(50) default NULL,
  "paper" varchar(90) default NULL,
  "paperCode" varchar(45) default NULL,
  "numberOfWorkingDays" varchar(45) default NULL,
  "active" int(11) default NULL,
  PRIMARY KEY  ("id")
) AUTO_INCREMENT=148 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'attendance_master'
#

/*!40000 ALTER TABLE "attendance_master" DISABLE KEYS;*/
LOCK TABLES "attendance_master" WRITE;
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(1,'1','BA','1','INDIAN HISTORY AND CULTURE 700AD','HIS 011','5',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(2,'1','BA','1','MICRO ECONOMICS-1','ECO 011A','5',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(3,'1','BA','1','CONCEPTS AND THEORIES','POL 011A','5',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(4,'1','BA','1','ENGLISH-1','ENG 051','5',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(5,'1','BA','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(6,'1','BA','1','SCIENCE,TECHNOLOGY&DEVELOPMENT','FOC 020','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(7,'1','BA','2','INDIAN HISTORY AND CULTURE(800-1526)AD','HIS 012','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(8,'1','BA','2','MICRO ECONOMICS-2','ECO 012A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(9,'1','BA','2','INDIAN CONSTITUTION ','POL 012A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(10,'1','BA','2','ENGLISH-2','ENG 052','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(11,'1','BA','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(12,'1','BA','2','CONTEMPORARY INDIA-ECONOMY ,POLITY&SOCIETY','FOC 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(13,'2','BA','3','INDIAN HISTORY & CULTURE(1526AD-1800AD)','HIS 013','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(14,'2','BA','3','MACRO ECONOMICS-1','ECO 013A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(15,'2','BA','3','PARTY SYSTEM & ELECTORAL POLITICS IN INDIA','POL 013A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(16,'2','BA','3','ENGLISH-3','ENG 033','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(17,'2','BA','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(18,'2','BA','3','ENVIRONMENTAL STUDIES','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(19,'2','BA','4','INDIAN HISTORY & CULTURE(1801AD-1964AD)','HIS 014','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(20,'2','BA','4','MACRO ECONOMICS-2','ECO 014A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(24,'2','BA','4','STUDY OF MAJOR CONSTITUTIONS UK,USA, SWITZERLAND,SOUTH AFRICA & FRANCE','POL 014A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(25,'2','BA','4','ENGLISH-4','ENG 034','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(26,'2','BA','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(27,'2','BA','4','ENVIRONMENTAL STUDIES ','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(28,'3','BA','5','HISTORY OF MODERN EUROPE 1789 TO 1871 AD','HIS 015','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(29,'3','BA','5','INDIAN ECONOMY-1','ECO 015A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(30,'3','BA','5','WESTERN POLITICAL THOUGHT','POL 015','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(31,'3','BA','5','HISTORY OF MODERN ANDHRA(1600-1857 AD)','HIS 025','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(32,'3','BA','5','QUANTITATIVE TECHNIQUES-1','ECO 045','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(33,'3','BA','5','CONCEPTS & THEORIES OF INTERNATIONAL RELATIONS','POL 025','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(34,'3','BA','6','HISTORY OF MODERN EUROPE(1871-1960AD)','HIS 016','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(35,'3','BA','6','INDIAN ECONOMY-2','ECO 066','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(36,'3','BA','6','ANCIENT INDIAN POLITICAL THOUGHT','POL 016','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(37,'3','BA','6','HISTORY OF MODERN ANDHRA(1858-1956AD)','HIS 026','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(38,'3','BA','6','QUANTITATIVE TECHNIQUES-2','ECO 056','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(39,'3','BA','6','PUBLIC ADMINISTRATION','POL 026','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(40,'1','BCOM(GEN)','1','BUSINESS ECONOMICS-1','ECO 021A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(41,'1','BCOM(GEN)','1','FINANCIAL ACCOUNTING-1','COM 011A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(42,'1','BCOM(GEN)','1','BUSINESS MATHEMATICS ','MAT 031','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(43,'1','BCOM(GEN)','1','ENGLISH-1','ENG 051','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(44,'1','BCOM(GEN)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(45,'1','BCOM(GEN)','1','SCIENCE,TECHNOLOGY&DEVELOPMENT','FOC 020','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(46,'1','BCOM(GEN)','2','BUSINESS ECONOMICS-2','ECO 22A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(47,'1','BCOM(GEN)','2','FINANCIAL ACCOUNTING-2','COM 012','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(48,'1','BCOM(GEN)','2','BANKING AND FINANCIAL SERVICES ','COM 022A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(49,'1','BCOM(GEN)','2','ENGLISH-2','ENG 052','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(50,'1','BCOM(GEN)','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(51,'1','BCOM(GEN)','2','CONTEMPORARY INDIA-ECONOMY ,POLITY&SOCIETY','FOC 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(52,'2','BCOM(GEN)','3','FINANCIAL ACCOUNTING-3','COM 073','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(53,'2','BCOM(GEN)','3','BUSINESS STATASTICS-1','COM 023','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(54,'2','BCOM(GEN)','3','BUSINESS LAW-1','COM 083','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(55,'2','BCOM(GEN)','3','ENGLISH-3','ENG 033','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(56,'2','BCOM(GEN)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(57,'2','BCOM(GEN)','3','ENVIRONMENTAL STUDIES','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(58,'2','BCOM(GEN)','4','FINANCIAL ACCOUNTING-4','COM 014A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(59,'2','BCOM(GEN)','4','BUSINESS LAW-2','COM 034','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(60,'2','BCOM(GEN)','4','BUSINESS STATASTICS-2','COM 024','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(61,'2','BCOM(GEN)','4','ENGLISH-4','ENG 034','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(62,'2','BCOM(GEN)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(63,'2','BCOM(GEN)','4','ENVIRONMENTAL STUDIES ','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(64,'3','BCOM(GEN)','5','CORPORATE ACCOUNTING','COM 025A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(65,'3','BCOM(GEN)','5','PRINCIPLES OF COSTING','COM 095','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(66,'3','BCOM(GEN)','5','CENTRAL EXCISE TAX/SERVICES MARKETING','COM 065/085','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(67,'3','BCOM(GEN)','5','COMPANY LAW','COM 035A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(68,'3','BCOM(GEN)','5','WEALTH TAX & SERVICE TAX/SELESMANSHIP E-COMMERCE','COM 055/075','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(69,'3','BCOM(GEN)','6','MANAGEMENT ACCOUNTANCY','COM 096','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(70,'3','BCOM(GEN)','6','CORPORATE ACCOUNTING-2','COM 026','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(71,'3','BCOM(GEN)','6','FINANCIAL MANAGEMENT/ENTERPRENEURSHIP','COM 066/086','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(72,'3','BCOM(GEN)','6','AUDITING','COM 036A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(73,'3','BCOM(GEN)','6','CUSTOMS/ADVERTISING','COM 056/076','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(74,'3','BCOM(GEN)','6','COMMERCE LAB','COM 106','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(75,'1','BCOM(CS)','1','BUSINESS ECONOMICS-1','ECO 021A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(76,'1','BCOM(CS)','1','FINANCIAL ACCOUNTING-1','COM 011A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(77,'1','BCOM(CS)','1','BUSINESS ORGANISATION AND MANAGEMENT','COM 051','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(78,'1','BCOM(CS)','1','ENGLISH-1','ENG 051','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(79,'1','BCOM(CS)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(80,'1','BCOM(CS)','1','SCIENCE,TECHNOLOGY&DEVELOPMENT','FOC 020','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(81,'1','BCOM(CS)','2','BUSINESS ECONOMICS-2','ECO 22A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(82,'1','BCOM(CS)','2','FINANCIAL ACCOUNTING-2','COM 012','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(83,'1','BCOM(CS)','2','BANKING AND FINANCIAL SERVICES ','COM 022A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(84,'1','BCOM(CS)','2','ENGLISH-2','ENG 052','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(85,'1','BCOM(CS)','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(86,'1','BCOM(CS)','2','CONTEMPORARY INDIA-ECONOMY ,POLITY&SOCIETY','FOC 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(87,'2','BCOM(CS)','3','FINANCIAL ACCOUNTING-3','COM 073','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(88,'2','BCOM(CS)','3','BUSINESS STATASTICS-1','COM 023','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(89,'2','BCOM(CS)','3','BUSINESS LAW-1','COM 083','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(90,'2','BCOM(CS)','3','ENGLISH-3','ENG 033','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(91,'2','BCOM(CS)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(92,'2','BCOM(CS)','3','ENVIRONMENTAL STUDIES','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(93,'2','BCOM(CS)','4','FINANCIAL ACCOUNTING-4','COM 014A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(94,'2','BCOM(CS)','4','BUSINESS LAW-2','COM 034','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(95,'2','BCOM(CS)','4','BUSINESS STATASTICS-2','COM 024','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(96,'2','BCOM(CS)','4','ENGLISH-4','ENG 034','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(97,'2','BCOM(CS)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(98,'2','BCOM(CS)','4','ENVIRONMENTAL STUDIES ','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(99,'3','BCOM(CS)','5','CORPORATE ACCOUNTING','COM 025A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(100,'3','BCOM(CS)','5','PRINCIPLES OF COSTING','COM 095','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(101,'3','BCOM(CS)','5','MANAGEMENT INFORMATION SYSTEMS','CAP 075','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(102,'3','BCOM(CS)','5','COMPANY LAW','COM 035A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(103,'3','BCOM(CS)','5','E-COMMERCE','CAP 065','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(104,'3','BCOM(CS)','6','MANAGEMENT ACCOUNTANCY','COM 096','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(105,'3','BCOM(CS)','6','CORPORATE ACCOUNTING-2','COM 026','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(106,'3','BCOM(CS)','6','AUDITING','COM 036A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(107,'3','BCOM(CS)','6','WEB DESIGNING','CAP 096A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(108,'3','BCOM(CS)','6','COMMERCE LAB','COM 106','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(109,'1','BSC(MPC)','1','3D & VECTOR CALCULUS ','MAT 011','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(110,'1','BSC(MPC)','1','MECHANICS, RELATIVITY AND ULTRASONIC','PHY 011','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(111,'1','BSC(MPC)','1','PHYSICAL AND GENERAL CHEMISTRY','CHE 011B','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(112,'1','BSC(MPC)','1','ENGLISH-1','ENG 051','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(113,'1','BSC(MPC)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(114,'1','BSC(MPC)','1','CONTEMPORARY INDIA-ECONOMY, POLITY&SOCIETY','FOC 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(115,'1','BSC(MPC)','2','DIFFERENTIAL EQUATIONS, NUMBTER THEORY & 3D','MAT 012','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(116,'1','BSC(MPC)','2','WAVES AND OSCILLATIONS','PHY 012','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(117,'1','BSC(MPC)','2','ORGANIC & INORGANIC CHEMISTRY -1','CHE 012B','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(118,'1','BSC(MPC)','2','ENGLISH-2','ENG 052','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(119,'1','BSC(MPC)','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(120,'1','BSC(MPC)','2','SCIENCE , TECHNOLOGYA & DEVELOPMENT','FOC 020','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(121,'2','BSC(MPC)','3','REAL ANALYSIS & GROUP THEORY-1','MAT 013','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(122,'2','BSC(MPC)','3','OPTICS','PHY 013','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(123,'2','BSC(MPC)','3','ORGANIC & INORGANIC CHEMISTRY-2','CHE 013A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(124,'2','BSC(MPC)','3','ENGLISH-3','ENG 033','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(125,'2','BSC(MPC)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(126,'2','BSC(MPC)','3','ENVIRONMENTAL STUDIES','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(127,'2','BSC(MPC)','4','REAL ANALYSIS & GROUP THEORY-2','MAT 014','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(128,'2','BSC(MPC)','4','ELCTRICITY & MAGNETISM','PHY 014','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(129,'2','BSC(MPC)','4','PHYSICAL AND GENERAL CHEMISTRY-2','CHE 014A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(130,'2','BSC(MPC)','4','ENGLISH-4','ENG 034','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(131,'2','BSC(MPC)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(132,'2','BSC(MPC)','4','ENVIRONMENTAL STUDIES ','ENS 010','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(133,'3','BSC(MPC)','5','RING THEORY&VECTOR SPACES','MAT 015','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(134,'3','BSC(MPC)','5','THERMODYNAMICS','PHY 015A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(135,'3','BSC(MPC)','5','ORGANIC & INORGANIC CHEMISTRY-3','CHE 015A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(136,'3','BSC(MPC)','5','NUMERICAL ANALYSIS& SPECIAL FUNCTIONS-1','MAT 025','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(137,'3','BSC(MPC)','5','A.C FUNDAMENTALS & ELECTRONICS','PHY 045','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(138,'3','BSC(MPC)','5','PHYSICAL & ORGANIC CHEMISTRY','CHE 025A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(139,'3','BSC(MPC)','6','LINEAR TRANSFORMATION & MATRICES','MAT 016','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(140,'3','BSC(MPC)','6','NUCLEAR PHYSICS& SOLID STATE PHYSICS','PHY 016A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(141,'3','BSC(MPC)','6','CHEMISTRY & INDUSTRY-1','CHE 016A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(142,'3','BSC(MPC)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS-2','MAT 026','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(143,'3','BSC(MPC)','6','SPECTROSCOPY & QUANTUM MECHANICS','PHY 026','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(144,'3','BSC(MPC)','6','CHEMISTRY & INDUSTRY-2','CHE 026A','0',1);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(145,'1','BSC(MPCS)','1','3D & VECTOR CALCULUS',NULL,'10',NULL);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(146,'3','BSC(FMB)','5','NORMAL NUTRITION & FOOD ADULTERATION',NULL,'10',NULL);
REPLACE INTO "attendance_master" ("id", "year", "branch", "semister", "paper", "paperCode", "numberOfWorkingDays", "active") VALUES
	(147,'1','BSC(FMB)','2','MICROBIOLOGICAL TECHNIQUES',NULL,'12',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE "attendance_master" ENABLE KEYS;*/


#
# Table structure for table 'branch'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "branch" (
  "id" int(11) NOT NULL auto_increment,
  "branch" varchar(45) default NULL,
  "active" int(11) default NULL,
  PRIMARY KEY  ("id")
) AUTO_INCREMENT=12 /*!40100 DEFAULT CHARSET=latin1 COMMENT='Branch Table to Strore Branches.'*/;



#
# Dumping data for table 'branch'
#

/*!40000 ALTER TABLE "branch" DISABLE KEYS;*/
LOCK TABLES "branch" WRITE;
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(1,'BA',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(2,'BCOM(GEN)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(3,'BCOM(CS)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(4,'BSC(MPC)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(5,'BSC(MSCS)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(6,'BSC(MPCS)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(7,'BSC(MECS)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(8,'BSC(MSCA)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(9,'BSC(FMC)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(10,'BSC(FMB)',1);
REPLACE INTO "branch" ("id", "branch", "active") VALUES
	(11,'BSC(BZC)',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE "branch" ENABLE KEYS;*/


#
# Table structure for table 'marksmaster'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "marksmaster" (
  "id" int(11) NOT NULL auto_increment,
  "studentId" varchar(45) default NULL,
  "branch" varchar(45) default NULL,
  "year" varchar(45) default NULL,
  "semister" varchar(50) default NULL,
  "paper" varchar(90) default NULL,
  "inter1" varchar(45) default NULL,
  "inter2" varchar(45) default NULL,
  "assignment" varchar(45) default NULL,
  "attendance" varchar(45) default NULL,
  "guid" varchar(45) default NULL,
  "active" int(11) default NULL,
  PRIMARY KEY  ("id")
) AUTO_INCREMENT=9 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'marksmaster'
#

/*!40000 ALTER TABLE "marksmaster" DISABLE KEYS;*/
LOCK TABLES "marksmaster" WRITE;
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(1,'111','BA','1','1','INDIAN HISTORY AND CULTURE 700AD','15','16',NULL,'4','7bb4db84-266c-49ef-9ccc-26ea3cf8fd52',1);
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(2,'222','BA','1','1','INDIAN HISTORY AND CULTURE 700AD','A','16',NULL,'4','aeef3a34-60f1-41e7-b8e7-d8564190de6d',1);
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(3,'333','BA','1','1','INDIAN HISTORY AND CULTURE 700AD','15','A',NULL,'4','77ae07f6-a4c9-4920-972d-b08605c6559a',1);
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(4,'444','BA','1','1','INDIAN HISTORY AND CULTURE 700AD','A','A',NULL,'4','e9e176a9-1e5e-4dd2-8eb9-b45857d0efa3',1);
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(5,'111','BA','1','1','MICRO ECONOMICS-1','14','12','4','4','1e7fcc7f-ac23-4fac-819b-1b49c31fd0b3',1);
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(6,'222','BA','1','1','MICRO ECONOMICS-1','A','12','4','4','56731568-7738-4457-9c19-0ec8525ce976',1);
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(7,'333','BA','1','1','MICRO ECONOMICS-1','13','A','4','4','dbb51bf9-d766-43e7-8ba2-36fe937a06a7',1);
REPLACE INTO "marksmaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "inter2", "assignment", "attendance", "guid", "active") VALUES
	(8,'444','BA','1','1','MICRO ECONOMICS-1','A','A','4','4','2918aef1-9661-4b5a-82f6-5a3d11f6afaa',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE "marksmaster" ENABLE KEYS;*/


#
# Table structure for table 'master'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "master" (
  "id" int(11) NOT NULL auto_increment,
  "year" varchar(2) default NULL,
  "branch" varchar(20) default NULL,
  "semister" varchar(50) default NULL,
  "paper" varchar(90) default NULL,
  "paperCode" varchar(45) default NULL,
  "active" int(11) default NULL,
  PRIMARY KEY  ("id")
) AUTO_INCREMENT=549 /*!40100 DEFAULT CHARSET=latin1 COMMENT='Master Table to Store the all the details of Branches.'*/;



#
# Dumping data for table 'master'
#

/*!40000 ALTER TABLE "master" DISABLE KEYS;*/
LOCK TABLES "master" WRITE;
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(1,'1','BA','1','INDIAN HISTORY AND CULTURE 700AD','HIS 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(2,'1','BA','1','MICRO ECONOMICS-1','ECO 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(3,'1','BA','1','CONCEPTS AND THEORIES','POL 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(4,'1','BA','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(5,'1','BA','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(6,'1','BA','1','SCIENCE,TECHNOLOGY&DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(7,'1','BA','2','INDIAN HISTORY AND CULTURE(800-1526)AD','HIS 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(8,'1','BA','2','MICRO ECONOMICS-2','ECO 012A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(9,'1','BA','2','INDIAN CONSTITUTION ','POL 012A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(10,'1','BA','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(11,'1','BA','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(12,'1','BA','2','CONTEMPORARY INDIA-ECONOMY ,POLITY&SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(13,'2','BA','3','INDIAN HISTORY & CULTURE(1526AD-1800AD)','HIS 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(14,'2','BA','3','MACRO ECONOMICS-1','ECO 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(15,'2','BA','3','PARTY SYSTEM & ELECTORAL POLITICS IN INDIA','POL 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(16,'2','BA','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(17,'2','BA','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(18,'2','BA','3','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(19,'2','BA','4','INDIAN HISTORY & CULTURE(1801AD-1964AD)','HIS 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(20,'2','BA','4','MACRO ECONOMICS-2','ECO 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(24,'2','BA','4','STUDY OF MAJOR CONSTITUTIONS UK,USA, SWITZERLAND,SOUTH AFRICA & FRANCE','POL 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(25,'2','BA','4','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(26,'2','BA','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(27,'2','BA','4','ENVIRONMENTAL STUDIES ','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(28,'3','BA','5','HISTORY OF MODERN EUROPE 1789 TO 1871 AD','HIS 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(29,'3','BA','5','INDIAN ECONOMY-1','ECO 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(30,'3','BA','5','WESTERN POLITICAL THOUGHT','POL 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(31,'3','BA','5','HISTORY OF MODERN ANDHRA(1600-1857 AD)','HIS 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(32,'3','BA','5','QUANTITATIVE TECHNIQUES-1','ECO 045',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(33,'3','BA','5','CONCEPTS & THEORIES OF INTERNATIONAL RELATIONS','POL 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(34,'3','BA','6','HISTORY OF MODERN EUROPE(1871-1960AD)','HIS 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(35,'3','BA','6','INDIAN ECONOMY-2','ECO 066',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(36,'3','BA','6','ANCIENT INDIAN POLITICAL THOUGHT','POL 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(37,'3','BA','6','HISTORY OF MODERN ANDHRA(1858-1956AD)','HIS 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(38,'3','BA','6','QUANTITATIVE TECHNIQUES-2','ECO 056',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(39,'3','BA','6','PUBLIC ADMINISTRATION','POL 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(40,'1','BCOM(GEN)','1','BUSINESS ECONOMICS-1','ECO 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(41,'1','BCOM(GEN)','1','FINANCIAL ACCOUNTING-1','COM 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(42,'1','BCOM(GEN)','1','BUSINESS MATHEMATICS ','MAT 031',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(43,'1','BCOM(GEN)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(44,'1','BCOM(GEN)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(45,'1','BCOM(GEN)','1','SCIENCE,TECHNOLOGY&DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(46,'1','BCOM(GEN)','2','BUSINESS ECONOMICS-2','ECO 22A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(47,'1','BCOM(GEN)','2','FINANCIAL ACCOUNTING-2','COM 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(48,'1','BCOM(GEN)','2','BANKING AND FINANCIAL SERVICES ','COM 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(49,'1','BCOM(GEN)','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(50,'1','BCOM(GEN)','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(51,'1','BCOM(GEN)','2','CONTEMPORARY INDIA-ECONOMY ,POLITY&SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(52,'2','BCOM(GEN)','3','FINANCIAL ACCOUNTING-3','COM 073',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(53,'2','BCOM(GEN)','3','BUSINESS STATASTICS-1','COM 023',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(54,'2','BCOM(GEN)','3','BUSINESS LAW-1','COM 083',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(55,'2','BCOM(GEN)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(56,'2','BCOM(GEN)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(57,'2','BCOM(GEN)','3','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(58,'2','BCOM(GEN)','4','FINANCIAL ACCOUNTING-4','COM 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(59,'2','BCOM(GEN)','4','BUSINESS LAW-2','COM 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(60,'2','BCOM(GEN)','4','BUSINESS STATASTICS-2','COM 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(61,'2','BCOM(GEN)','4','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(62,'2','BCOM(GEN)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(63,'2','BCOM(GEN)','4','ENVIRONMENTAL STUDIES ','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(64,'3','BCOM(GEN)','5','CORPORATE ACCOUNTING','COM 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(65,'3','BCOM(GEN)','5','PRINCIPLES OF COSTING','COM 095',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(66,'3','BCOM(GEN)','5','CENTRAL EXCISE TAX/SERVICES MARKETING','COM 065/085',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(67,'3','BCOM(GEN)','5','COMPANY LAW','COM 035A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(68,'3','BCOM(GEN)','5','WEALTH TAX & SERVICE TAX/SELESMANSHIP E-COMMERCE','COM 055/075',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(69,'3','BCOM(GEN)','6','MANAGEMENT ACCOUNTANCY','COM 096',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(70,'3','BCOM(GEN)','6','CORPORATE ACCOUNTING-2','COM 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(71,'3','BCOM(GEN)','6','FINANCIAL MANAGEMENT/ENTERPRENEURSHIP','COM 066/086',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(72,'3','BCOM(GEN)','6','AUDITING','COM 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(73,'3','BCOM(GEN)','6','CUSTOMS/ADVERTISING','COM 056/076',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(74,'3','BCOM(GEN)','6','COMMERCE LAB','COM 106',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(75,'1','BCOM(CS)','1','BUSINESS ECONOMICS-1','ECO 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(76,'1','BCOM(CS)','1','FINANCIAL ACCOUNTING-1','COM 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(77,'1','BCOM(CS)','1','BUSINESS ORGANISATION AND MANAGEMENT','COM 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(78,'1','BCOM(CS)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(79,'1','BCOM(CS)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(80,'1','BCOM(CS)','1','SCIENCE,TECHNOLOGY&DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(81,'1','BCOM(CS)','2','BUSINESS ECONOMICS-2','ECO 22A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(82,'1','BCOM(CS)','2','FINANCIAL ACCOUNTING-2','COM 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(83,'1','BCOM(CS)','2','BANKING AND FINANCIAL SERVICES ','COM 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(84,'1','BCOM(CS)','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(85,'1','BCOM(CS)','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(86,'1','BCOM(CS)','2','CONTEMPORARY INDIA-ECONOMY ,POLITY&SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(87,'2','BCOM(CS)','3','FINANCIAL ACCOUNTING-3','COM 073',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(88,'2','BCOM(CS)','3','BUSINESS STATASTICS-1','COM 023',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(89,'2','BCOM(CS)','3','BUSINESS LAW-1','COM 083',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(90,'2','BCOM(CS)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(91,'2','BCOM(CS)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(92,'2','BCOM(CS)','3','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(93,'2','BCOM(CS)','4','FINANCIAL ACCOUNTING-4','COM 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(94,'2','BCOM(CS)','4','BUSINESS LAW-2','COM 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(95,'2','BCOM(CS)','4','BUSINESS STATASTICS-2','COM 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(96,'2','BCOM(CS)','4','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(97,'2','BCOM(CS)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(98,'2','BCOM(CS)','4','ENVIRONMENTAL STUDIES ','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(99,'3','BCOM(CS)','5','CORPORATE ACCOUNTING','COM 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(100,'3','BCOM(CS)','5','PRINCIPLES OF COSTING','COM 095',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(101,'3','BCOM(CS)','5','MANAGEMENT INFORMATION SYSTEMS','CAP 075',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(102,'3','BCOM(CS)','5','COMPANY LAW','COM 035A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(103,'3','BCOM(CS)','5','E-COMMERCE','CAP 065',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(104,'3','BCOM(CS)','6','MANAGEMENT ACCOUNTANCY','COM 096',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(105,'3','BCOM(CS)','6','CORPORATE ACCOUNTING-2','COM 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(106,'3','BCOM(CS)','6','AUDITING','COM 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(107,'3','BCOM(CS)','6','WEB DESIGNING','CAP 096A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(108,'3','BCOM(CS)','6','COMMERCE LAB','COM 106',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(109,'1','BSC(MPC)','1','3D & VECTOR CALCULUS ','MAT 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(110,'1','BSC(MPC)','1','MECHANICS, RELATIVITY AND ULTRASONIC','PHY 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(111,'1','BSC(MPC)','1','PHYSICAL AND GENERAL CHEMISTRY','CHE 011B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(112,'1','BSC(MPC)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(113,'1','BSC(MPC)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(114,'1','BSC(MPC)','1','CONTEMPORARY INDIA-ECONOMY, POLITY&SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(115,'1','BSC(MPC)','2','DIFFERENTIAL EQUATIONS, NUMBTER THEORY & 3D','MAT 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(116,'1','BSC(MPC)','2','WAVES AND OSCILLATIONS','PHY 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(117,'1','BSC(MPC)','2','ORGANIC & INORGANIC CHEMISTRY -1','CHE 012B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(118,'1','BSC(MPC)','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(119,'1','BSC(MPC)','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(120,'1','BSC(MPC)','2','SCIENCE , TECHNOLOGYA & DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(121,'2','BSC(MPC)','3','REAL ANALYSIS & GROUP THEORY-1','MAT 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(122,'2','BSC(MPC)','3','OPTICS','PHY 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(123,'2','BSC(MPC)','3','ORGANIC & INORGANIC CHEMISTRY-2','CHE 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(124,'2','BSC(MPC)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(125,'2','BSC(MPC)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(126,'2','BSC(MPC)','3','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(127,'2','BSC(MPC)','4','REAL ANALYSIS & GROUP THEORY-2','MAT 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(128,'2','BSC(MPC)','4','ELCTRICITY & MAGNETISM','PHY 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(129,'2','BSC(MPC)','4','PHYSICAL AND GENERAL CHEMISTRY-2','CHE 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(130,'2','BSC(MPC)','4','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(131,'2','BSC(MPC)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(132,'2','BSC(MPC)','4','ENVIRONMENTAL STUDIES ','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(133,'3','BSC(MPC)','5','RING THEORY&VECTOR SPACES','MAT 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(134,'3','BSC(MPC)','5','THERMODYNAMICS','PHY 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(135,'3','BSC(MPC)','5','ORGANIC & INORGANIC CHEMISTRY-3','CHE 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(136,'3','BSC(MPC)','5','NUMERICAL ANALYSIS& SPECIAL FUNCTIONS-1','MAT 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(137,'3','BSC(MPC)','5','A.C FUNDAMENTALS & ELECTRONICS','PHY 045',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(138,'3','BSC(MPC)','5','PHYSICAL & ORGANIC CHEMISTRY','CHE 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(139,'3','BSC(MPC)','6','LINEAR TRANSFORMATION & MATRICES','MAT 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(140,'3','BSC(MPC)','6','NUCLEAR PHYSICS& SOLID STATE PHYSICS','PHY 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(141,'3','BSC(MPC)','6','CHEMISTRY & INDUSTRY-1','CHE 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(142,'3','BSC(MPC)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS-2','MAT 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(143,'3','BSC(MPC)','6','SPECTROSCOPY & QUANTUM MECHANICS','PHY 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(144,'3','BSC(MPC)','6','CHEMISTRY & INDUSTRY-2','CHE 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(145,'1','BA','1','CONTEMPORARY INDIA-ECONOMY ,POLITY&SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(146,'1','BA','2','SCIENCE,TECHNOLOGY&DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(147,'2','BA','4','GENERAL ENGLISH(PRACTICAL)','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(148,'2','BA','4','WORD PROCESSING','IDC 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(149,'2','BA','4','VISUAL PRESENTATION','IDC 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(150,'2','BA','4','WORD PROCESSING & VISUAL PRESENTATION','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(151,'3','BA','6','SPREAD SHEETS & DATABASES','IDC 330',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(152,'3','BA','6','SPREAD SHEETS','IDC 300',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(153,'3','BA','6','DATA BASES','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(154,'1','BCOM(GEN)','1','INCOME TAX-1/PRINCIPLES OF MANAGEMENT','COM 021/031',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(155,'1','BCOM(GEN)','2','INCOME TAX-II/BUSINESS ENVIRONMENT','COM 032/042',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(156,'2','BCOM(GEN)','3','INCOME TAX-III/MARKETING-1','COM 043/053',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(157,'2','BCOM(GEN)','4','GENERAL ENGLISH(PRACTICAL)','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(158,'2','BCOM(GEN)','4','WORD PROCESSING','IDC 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(159,'2','BCOM(GEN)','4','VISUAL PRESENTATION','IDC 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(160,'2','BCOM(GEN)','4','WORD PROCESSING,VISUAL PRESENTATION&SPREAD SHEETS','IDC 340',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(161,'2','BCOM(GEN)','4','A.P. VAT ACT/MARKETING-II','COM 044/054',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(162,'3','BCOM(GEN)','6','COMPUTERIZED ACCOUNTING TALLY','IDC 050',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(163,'3','BCOM(GEN)','6','TALLY(PRACTICAL)','CAP 086',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(164,'1','BCOM(CS)','1','FUNDAMENTALS OF COMPUTERS','CAP 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(165,'1','BCOM(CS)','2','OFFICE AUTOMATION TOOLS','CAP 032',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(166,'2','BCOM(CS)','3','PROGRAMMING WITH C','CAP 023',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(167,'2','BCOM(CS)','4','GENERAL ENGLISH(PRACTICAL)','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(168,'2','BCOM(CS)','4','DATABASE MANAGEMENT SYSTEMS','CAP 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(169,'2','BCOM(CS)','4','BUSINESS MATHEMATICS','IDC 390',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(170,'3','BCOM(CS)','6','WEB DESIGNING','CAP 106',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(171,'3','BCOM(CS)','6','COMPUTERIZED ACCOUNTING(TALLY)','IDC 050',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(172,'3','BCOM(CS)','6','TALLY(PRACTICAL)','CAP 086',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(173,'1','BSC(MPC)','2','3D VC,DE &NUMBER THEORY','MAT 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(174,'1','BSC(MPC)','2','PRACTICAL -I','PHY 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(175,'1','BSC(MPC)','2','INORGANIC CHEMISTRY','CHE 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(176,'2','BSC(MPC)','4','REAL ANALYSIS & GROUP THEORY-1,2','MAT 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(177,'2','BSC(MPC)','4','PRACTICAL -II','PHY 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(178,'2','BSC(MPC)','4','VOLUMETRIC ANALYSIS','CHE 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(179,'2','BSC(MPC)','4','GENERAL ENGLISH(PRACTICAL)','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(180,'2','BSC(MPC)','4','WORD PROCESSING','IDC 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(181,'2','BSC(MPC)','4','VISUAL PRESENTATION','IDC 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(182,'2','BSC(MPC)','4','WORD PROCESSING& VISUAL PRESENTATION','IDC 300',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(183,'3','BSC(MPC)','6','LINEAR TRANSFORMATION & MATRICES','MAT 066',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(184,'3','BSC(MPC)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS','MAT 076',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(185,'3','BSC(MPC)','6','PRACTICAL -III','PHY 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(186,'3','BSC(MPC)','6','PRACTICAL -IV','PHY 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(187,'3','BSC(MPC)','6','ORGANIC CHEMISTRY','CHE 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(188,'3','BSC(MPC)','6','PHYSICAL CHEMISTRY','CHE 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(189,'3','BSC(MPC)','6','SPREAD SHEETS','IDC 300',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(190,'3','BSC(MPC)','6','DATA BASES','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(191,'3','BSC(MPC)','6','SPREAD SHEETS&DATA BASES','IDC 320',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(192,'1','BSC(MSCS)','1','3D & VECTOR CALCULUS','MAT 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(193,'1','BSC(MSCS)','1','DESCRIPTIVE STATASTICS & PROBABILITY','STA011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(194,'1','BSC(MSCS)','1','PROGRAMMING IN C','CAP 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(195,'1','BSC(MSCS)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(196,'1','BSC(MSCS)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(197,'1','BSC(MSCS)','1','SCIENCE , TECHNOLOGYA & DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(198,'1','BSC(MSCS)','2','DIFFERENTIAL EQUATIONS, NUMBTER THEORY & 3D
','MAT 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(199,'1','BSC(MSCS)','2','PROBABILITY AND DISTRIBUTIONS
','STA 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(200,'1','BSC(MSCS)','2','DATA STRUCTURES
','CAP 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(201,'1','BSC(MSCS)','2','ENGLISH-2
','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(202,'1','BSC(MSCS)','2','TELUGU-2/HINDI-2
','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(203,'1','BSC(MSCS)','2','CONTEMPORARY INDIA-ECONOMY, POLITY&SOCIETY
','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(204,'1','BSC(MSCS)','2','3D VC,DE &NUMBER THEORY
','MAT 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(205,'1','BSC(MSCS)','2','PRACTICAL -I PROB&DISTR
','STA 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(206,'1','BSC(MSCS)','2','C AND DS & MS OFFICE
','CAP 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(207,'2','BSC(MSCS)','3','REAL ANALYSIS & GROUP THEORY-1
','MAT 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(208,'2','BSC(MSCS)','3','STATASTICAL METHODS AND INFERENCE-1
','STA 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(209,'2','BSC(MSCS)','3','OBJECT ORIENTED PROGRAMMING
','CAP 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(210,'2','BSC(MSCS)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(211,'2','BSC(MSCS)','3','TELUGU-3/HINDI-3
','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(212,'2','BSC(MSCS)','3','ENVIRONMENTAL STUDIES
','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(213,'2','BSC(MSCS)','4','REAL ANALYSIS & GROUP THEORY-2','MAT 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(214,'2','BSC(MSCS)','4','STATASTICAL INFERENCE-2
','STA 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(215,'2','BSC(MSCS)','4','DATA BASE MANAGEMENT SYSTEMS 
','CAP 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(216,'2','BSC(MSCS)','4','ENGLISH-4
','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(217,'2','BSC(MSCS)','4','TELUGU-4/HINDI-4
','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(218,'2','BSC(MSCS)','4','ENVIRONMENTAL STUDIES 
','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(219,'2','BSC(MSCS)','4','REAL ANALYSIS & GROUP THEORY-1,2
','MAT 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(220,'2','BSC(MSCS)','4','STATASTICAL INFERENCE-1,2
','STA 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(221,'2','BSC(MSCS)','4','JAVA & ORACLE','CAP 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(222,'2','BSC(MSCS)','4','GENERAL ENGLISH(PRACTICAL)','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(223,'3','BSC(MSCS)','5','RING THEORY&VECTOR SPACES
','MAT 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(224,'3','BSC(MSCS)','5','APPLIED STATASTICS-1','STA 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(225,'3','BSC(MSCS)','5','INTERNET PROGRAMMING','CAP 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(226,'3','BSC(MSCS)','5','NUMERICAL ANALYSIS& SPECIAL FUNCTIONS-1','MAT 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(227,'3','BSC(MSCS)','5','OPERATIONS RESEARCH-1','STA 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(228,'3','BSC(MSCS)','5','SOFTWARE ENGINEERING','CAP 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(229,'3','BSC(MSCS)','6','LINEAR TRANSFORMATION & MATRICES','MAT 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(230,'3','BSC(MSCS)','6','APPLIED STATASTICS-2','STA 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(231,'3','BSC(MSCS)','6','OPERATING SYSTEMS','CAP 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(232,'3','BSC(MSCS)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS-2
','MAT 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(233,'3','BSC(MSCS)','6','OPERATIONS RESEARCH-2
','STA 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(234,'3','BSC(MSCS)','6','SYSTEMS PROGRAMMING
','CAP 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(235,'3','BSC(MSCS)','6','LINEAR TRANSFORMATION & MATRICES','MAT 066',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(236,'3','BSC(MSCS)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS
','MAT 076',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(237,'3','BSC(MSCS)','6','APPLIED STATASTICS
','STA 036B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(238,'3','BSC(MSCS)','6','OPERATIONS RESEARCH
','STA 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(239,'3','BSC(MSCS)','6','PROJECT','CAP 046',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(240,'3','BSC(MSCS)','6','ADV.JAVA(TP) & LINUX','CAP 036',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(241,'1','BSC(MPCS)','1','3D & VECTOR CALCULUS','MAT 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(242,'1','BSC(MPCS)','1','MECHANICS, RELATIVITY AND ULTRASONIC','PHY 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(243,'1','BSC(MPCS)','1','PROGRAMMING IN C
','CAP 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(244,'1','BSC(MPCS)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(245,'1','BSC(MPCS)','1','TELUGU-1/HINDI-1
','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(246,'1','BSC(MPCS)','1','SCIENCE , TECHNOLOGYA & DEVELOPMENT
','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(247,'1','BSC(MPCS)','2','DIFFERENTIAL EQUATIONS, NUMBTER THEORY & 3D
','MAT 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(248,'1','BSC(MPCS)','2','WAVES AND OSCILLATIONS','PHY 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(249,'1','BSC(MPCS)','2','DATA STRUCTURES','CAP 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(250,'1','BSC(MPCS)','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(251,'1','BSC(MPCS)','2','TELUGU-2/HINDI-2','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(252,'1','BSC(MPCS)','2','CONTEMPORARY INDIA-ECONOMY, POLITY&SOCIETY
','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(253,'1','BSC(MPCS)','2','3D VC,DE &NUMBER THEORY','MAT 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(254,'1','BSC(MPCS)','2','PRACTICAL -I','PHY 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(255,'1','BSC(MPCS)','2','C AND DS & MS OFFICE','CAP 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(256,'2','BSC(MPCS)','3','REAL ANALYSIS & GROUP THEORY-1','MAT 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(257,'2','BSC(MPCS)','3','OPTICS','PHY 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(258,'2','BSC(MPCS)','3','OBJECT ORIENTED PROGRAMMING
','CAP 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(259,'2','BSC(MPCS)','3','ENGLISH-3
','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(260,'2','BSC(MPCS)','3','TELUGU-3/HINDI-3
','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(261,'2','BSC(MPCS)','3','ENVIRONMENTAL STUDIES
','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(262,'2','BSC(MPCS)','4','REAL ANALYSIS & GROUP THEORY-2
','MAT 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(263,'2','BSC(MPCS)','4','ELECTRICITY AND MAGNETISM
','PHY 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(264,'2','BSC(MPCS)','4','DATA BASE MANAGEMENT SYSTEMS','CAP 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(265,'2','BSC(MPCS)','4','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(266,'2','BSC(MPCS)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(267,'2','BSC(MPCS)','4','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(268,'2','BSC(MPCS)','4','REAL ANALYSIS & GROUP THEORY-1,2
','MAT 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(269,'2','BSC(MPCS)','4','PRACTICAL -II
','PHY 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(270,'2','BSC(MPCS)','4','JAVA & ORACLE
','CAP 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(271,'2','BSC(MPCS)','4','GENERAL ENGLISH(PRACTICAL)','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(272,'3','BSC(MPCS)','5','RING THEORY&VECTOR SPACES','MAT 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(273,'3','BSC(MPCS)','5','THERMODYNAMICS','PHY 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(274,'3','BSC(MPCS)','5','INTERNET PROGRAMMING
','CAP 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(275,'3','BSC(MPCS)','5','NUMERICAL ANALYSIS& SPECIAL FUNCTIONS-1
','MAT 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(276,'3','BSC(MPCS)','5','A.C.FUNDAMENTALS & ELECTRONICS
','PHY 045',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(277,'3','BSC(MPCS)','5','SOFTWARE ENGINEERING
','CAP 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(278,'3','BSC(MPCS)','6','LINEAR TRANSFORMATION & MATRICES
','MAT 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(279,'3','BSC(MPCS)','6','NUCLEAR PHYSICS  & SOLID STATE PHYSICS
','PHY 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(280,'3','BSC(MPCS)','6','OPERATING SYSTEMS

','CAP 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(281,'3','BSC(MPCS)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS-2

','MAT 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(282,'3','BSC(MPCS)','6','SPECTROSCOPY & QUANTUM MECHANICS 

','PHY 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(283,'3','BSC(MPCS)','6','SYSTEMS PROGRAMMING

','CAP 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(284,'3','BSC(MPCS)','6','LINEAR TRANSFORMATION & MATRICES

','MAT 066',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(285,'3','BSC(MPCS)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS

','MAT 076',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(286,'3','BSC(MPCS)','6','PRACTICAL -III

','PHY 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(287,'3','BSC(MPCS)','6','PRACTICAL -IV','PHY 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(288,'3','BSC(MPCS)','6','PROJECT','CAP 046',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(289,'3','BSC(MPCS)','6','ADV.JAVA(TP) & LINUX','CAP 036',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(290,'1','BSC(MECS)','1','3D & VECTOR CALCULUS 

','MAT 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(291,'1','BSC(MPCS)','1','CIRCUIT THEORY

','ELE 031',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(292,'1','BSC(MPCS)','1','PROGRAMMING IN C


','CAP 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(293,'1','BSC(MPCS)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(294,'1','BSC(MPCS)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(295,'1','BSC(MPCS)','1','CONTEMPORARY INDIA-ECONOMY, POLITY&SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(296,'1','BSC(MECS)','2','DIFFERENTIAL EQUATIONS, NUMBTER THEORY & 3D


','MAT 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(297,'1','BSC(MPCS)','2','BASIC ELECTRONICS 


','ELE 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(298,'1','BSC(MPCS)','2','DATA STRUCTURES



','CAP 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(299,'1','BSC(MPCS)','2','ENGLISH-2
','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(300,'1','BSC(MPCS)','2','TELUGU-2/HINDI-2
','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(301,'1','BSC(MPCS)','2','SCIENCE , TECHNOLOGYA & DEVELOPMENT
','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(302,'1','BSC(MPCS)','2','C.THEORY & B.ELECTRONICS','ELE 062',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(303,'1','BSC(MPCS)','2','C AND DS & MS OFFICE


','CAP 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(304,'2','BSC(MECS)','3','REAL ANALYSIS & GROUP THEORY-1','MAT 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(305,'2','BSC(MPCS)','3','ELECTRONIC DEVICES AND CIRCUITS','ELE 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(306,'2','BSC(MPCS)','3','OBJECT ORIENTED PROGRAMMING','CAP 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(307,'2','BSC(MPCS)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(308,'2','BSC(MPCS)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(309,'2','BSC(MPCS)','3','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(310,'2','BSC(MECS)','4','REAL ANALYSIS & GROUP THEORY-2
','MAT 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(311,'2','BSC(MPCS)','4','ANALOG AND DIGITAL CIRCUITS
','ELE 054',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(312,'2','BSC(MPCS)','4','DATA BASE MANAGEMENT SYSTEMS 
','CAP 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(313,'2','BSC(MPCS)','4','ENGLISH-4
','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(314,'2','BSC(MPCS)','4','TELUGU-4/HINDI-4
','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(315,'2','BSC(MPCS)','4','ENVIRONMENTAL STUDIES 
','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(316,'2','BSC(MPCS)','4','REAL ANALYSIS & GROUP THEORY-1,2
','MAT 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(317,'2','BSC(MPCS)','4','ELEC DEVICES,ANALOG,DIGITAL CIRCUITS','ELE 064',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(318,'2','BSC(MPCS)','4','JAVA & ORACLE','CAP 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(319,'2','BSC(MPCS)','4','GENERAL ENGLISH(PRACTICAL)','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(320,'3','BSC(MECS)','5','RING THEORY&VECTOR SPACES','MAT 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(321,'3','BSC(MPCS)','5','ANALOG AND DIGITAL COMMUNICATIONS','ELE 055',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(322,'3','BSC(MPCS)','5','INTERNET PROGRAMMING','CAP 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(323,'3','BSC(MPCS)','5','NUMERICAL ANALYSIS& SPECIAL FUNCTIONS-1','MAT 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(324,'3','BSC(MPCS)','5','8085 MICROPROCESSORS','ELE 075',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(325,'3','BSC(MPCS)','5','SOFTWARE ENGINEERING','CAP 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(326,'3','BSC(MECS)','6','LINEAR TRANSFORMATION & MATRICES
','MAT 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(327,'3','BSC(MPCS)','6','OPTICAL FIBRE COMMUNICATIONS & APPLICATIONS
','ELE 126',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(328,'3','BSC(MPCS)','6','OPERATING SYSTEMS
','CAP 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(329,'3','BSC(MPCS)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS-2
','MAT 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(330,'3','BSC(MPCS)','6','MICRO CONTROLLERS & EMBEDDED SYSTEMS
','ELE 136A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(331,'3','BSC(MPCS)','6','SYSTEMS PROGRAMMING
','CAP 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(332,'3','BSC(MPCS)','6','LINEAR TRANSFORMATION & MATRICES

','MAT 066',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(333,'3','BSC(MPCS)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS
','MAT 076',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(334,'3','BSC(MPCS)','6','F.OPTICS, COMM,APPLI & ANLOG,DIGITAL COMM
','ELE 156',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(335,'3','BSC(MPCS)','6','MICRO PROCESSORS/CONTROLLERS & EMBEDDED SYSTEMS
','ELE 166',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(336,'3','BSC(MPCS)','6','PROJECT
','CAP 046',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(337,'3','BSC(MPCS)','6','ADV.JAVA(TP) & LINUX
','CAP 036',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(338,'1','BSC(MSCA)','1','3D & VECTOR CALCULUS 

','MAT 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(339,'1','BSC(MSCA)','1','DESCRIPTIVE STATASTICS & PROBABILITY

','STA011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(340,'1','BSC(MSCA)','1','PROGRAMMING IN C

','CAP 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(341,'1','BSC(MSCA)','1','ENGLISH-1

','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(342,'1','BSC(MSCA)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(343,'1','BSC(MSCA)','1','SCIENCE , TECHNOLOGYA & DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(344,'1','BSC(MSCA)','2','DIFFERENTIAL EQUATIONS, NUMBTER THEORY & 3D
','MAT 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(345,'1','BSC(MSCA)','2','PROBABILITY AND DISTRIBUTIONS','STA 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(346,'1','BSC(MSCA)','2','DATA STRUCTURES','CAP 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(347,'1','BSC(MSCA)','2','ENGLISH-2


','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(348,'1','BSC(MSCA)','2','TELUGU-2/HINDI-2
','TEL 012B/HIN022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(349,'1','BSC(MSCA)','2','CONTEMPORARY INDIA-ECONOMY, POLITY&SOCIETY
','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(350,'1','BSC(MSCA)','2','3D VC,DE &NUMBER THEORY','MAT 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(351,'1','BSC(MSCA)','2','PRACTICAL -I PROB&DISTR','STA 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(352,'1','BSC(MSCA)','2','C AND DS & MS OFFICE

','CAP 022',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(353,'2','BSC(MSCA)','3','REAL ANALYSIS & GROUP THEORY-1

','MAT 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(354,'2','BSC(MSCA)','3','STATASTICAL METHODS AND INFERENCE-1
','STA 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(355,'2','BSC(MSCA)','3','OBJECT ORIENTED PROGRAMMING
','CAP 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(356,'2','BSC(MSCA)','3','ENGLISH-3



','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(357,'2','BSC(MSCA)','3','TELUGU-3/HINDI-3

','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(358,'2','BSC(MSCA)','3','ENVIRONMENTAL STUDIES

','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(359,'2','BSC(MSCA)','4','REAL ANALYSIS & GROUP THEORY-2


','MAT 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(360,'2','BSC(MSCA)','4','STATASTICAL INFERENCE-2

','STA 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(361,'2','BSC(MSCA)','4','DATA BASE MANAGEMENT SYSTEMS 

','CAP 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(362,'2','BSC(MSCA)','4','ENGLISH-4




','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(363,'2','BSC(MSCA)','4','TELUGU-4/HINDI-4


','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(364,'2','BSC(MSCA)','4','ENVIRONMENTAL STUDIES 


','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(365,'2','BSC(MSCA)','4','REAL ANALYSIS & GROUP THEORY-1,2
','MAT 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(366,'2','BSC(MSCA)','4','STATASTICAL INFERENCE-1,2
','STA 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(367,'2','BSC(MSCA)','4','JAVA & ORACLE


','CAP 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(368,'2','BSC(MSCA)','4','GENERAL ENGLISH(PRACTICAL)

','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(369,'3','BSC(MSCA)','5','RING THEORY&VECTOR SPACES



','MAT 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(370,'3','BSC(MSCA)','5','APPLIED STATASTICS-1


','STA 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(371,'3','BSC(MSCA)','5','INTERNET PROGRAMMING


','CAP 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(372,'3','BSC(MSCA)','5','NUMERICAL ANALYSIS& SPECIAL FUNCTIONS-1





','MAT 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(373,'3','BSC(MSCA)','5','OPERATIONS RESEARCH-1



','STA 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(374,'3','BSC(MSCA)','5','SOFTWARE ENGINEERING



','CAP 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(375,'3','BSC(MSCA)','6','LINEAR TRANSFORMATION & MATRICES

','MAT 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(376,'3','BSC(MSCA)','6','APPLIED STATASTICS-2



','STA 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(377,'3','BSC(MSCA)','6','OPERATING SYSTEMS
','CAP 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(378,'3','BSC(MSCA)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS-2






','MAT 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(379,'3','BSC(MSCA)','6','OPERATIONS RESEARCH-2

','STA 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(380,'3','BSC(MSCA)','6','SYSTEMS PROGRAMMING
','CAP 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(381,'3','BSC(MSCA)','6','LINEAR TRANSFORMATION & MATRICES

','MAT 066',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(382,'3','BSC(MSCA)','6','NUMERICAL ANALYSIS & SPECIAL FUNCTIONS

','MAT 076',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(383,'3','BSC(MSCA)','6','APPLIED STATASTICS



','STA 036B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(384,'3','BSC(MSCA)','6','OPERATIONS RESEARCH


','STA 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(385,'3','BSC(MSCA)','6','PROJECT
','CAP 046',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(386,'3','BSC(MSCA)','6','ADV.JAVA(TP) & LINUX
','CAP 036',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(387,'1','BSC(FMC)','1','HUMAN PHYSIOLOGY','FST 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(388,'1','BSC(FMC)','1','INTRODUCTORY MICROBIOLOGY','MIC 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(389,'1','BSC(FMC)','1','PHYSICAL AND GENERAL CHEMISTRY-1','CHE 011B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(390,'1','BSC(FMC)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(391,'1','BSC(FMC)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(392,'1','BSC(FMC)','1','CONTEMPORARY INDIA -ECONOMY, POLITY & SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(393,'1','BSC(FMC)','2','BASIC NUTRITION','FST 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(394,'1','BSC(FMC)','2','MICROBIOLOGICAL TECHNIQUES','MIC 012A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(395,'1','BSC(FMC)','2','ORGANIC&INORGANIC CHEMISTRY-1','CHE 012B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(396,'1','BSC(FMC)','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(397,'1','BSC(FMC)','2','TELUGU-2/HINDI-2','TEL 012B/HIN 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(398,'1','BSC(FMC)','2','SCIENCE, TECHNOLOGY & DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(399,'1','BSC(FMC)','2','HUMAN PHYSIOLOGY&BASIC NUTRITION','FST 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(400,'1','BSC(FMC)','2','QUALITATIVE ANALYSIS','BCH 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(401,'1','BSC(FMC)','2','MICROBIOLOGICAL TECHNIQUES','MIC 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(402,'2','BSC(FMC)','3','FOOD SCIENCE','FST 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(403,'2','BSC(FMC)','3','MICROBIAL PHYSIOLOGY','MIC 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(404,'2','BSC(FMC)','3','ORGANIC & INORGANIC CHEMISTRY-2','CHE 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(405,'2','BSC(FMC)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(406,'2','BSC(FMC)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(407,'2','BSC(FMC)','3','ENVIRONMENTAL SCIENCE','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(408,'2','BSC(FMC)','4','FOOD TECHNLOGY','FST 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(409,'2','BSC(FMC)','4','MICROBIAL GENETICS','MIC 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(410,'2','BSC(FMC)','4','PHYSICAL & GENERAL CHEMISTRY-2','CHE 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(411,'2','BSC(FMC)','4','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(412,'2','BSC(FMC)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(413,'2','BSC(FMC)','4','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(414,'2','BSC(FMC)','4','FOOD SCIENCE&TECHNOLOGY','FST 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(415,'2','BSC(FMC)','4','QUANTITATIVE ANALYSIS','BCH 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(416,'2','BSC(FMC)','4','MICROBIAL PHYSIOLOGY&GENETICS','MIC 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(417,'2','BSC(FMC)','4','GENERAL ENGLISH(PRACTICAL','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(418,'2','BSC(FMC)','4','WORD PROCESSING','IDC 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(419,'2','BSC(FMC)','4','VISUAL PRESENTATION','IDC 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(420,'2','BSC(FMC)','4','WORD PROCESSING&VISUAL PRESENTATION','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(421,'3','BSC(FMC)','5','NORMAL NUTRITION & FOOD ADULTERATION','FST 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(422,'3','BSC(FMC)','5','IMMUNOLOGY','MIC 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(423,'3','BSC(FMC)','5','INORGANIC & ORGANIC CHEMISTRY-3','che 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(424,'3','BSC(FMC)','5','ADVANCE DIETETICS','FST 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(425,'3','BSC(FMC)','5','MEDICAL MICROBIOLOGY','MIC 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(426,'3','BSC(FMC)','5','PHYSICAL & ORGANIC CHEMISTRY','CHE 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(427,'3','BSC(FMC)','6','FOOD PRESERVATION, HYGIENE,SANITATION','FST 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(428,'3','BSC(FMC)','6','AGRICULTURE & ENVIRONMENT MICROBIOLOGY','MIC 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(429,'3','BSC(FMC)','6','CHEMISTRY&INDUSTRY-1','CHE 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(430,'3','BSC(FMC)','6','ADVANCED DIETITICS & COMMUNITY NUTRITION','FST 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(431,'3','BSC(FMC)','6','FOOD & INDUSTRIAL MICROBIOLOGY','MIC 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(432,'3','BSC(FMC)','6','CHEMISTRY&INDUSTRY-2','CHE 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(433,'3','BSC(FMC)','6','NORM NUTRI,ADULTRATION&PRESERVATION','FST 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(434,'3','BSC(FMC)','6','ADVANCED NUTRITION','FST 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(435,'3','BSC(FMC)','6','APPLIED BIOCHEMISTRY','BCH 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(436,'3','BSC(FMC)','6','CLINICAL ANALYSIS','BCH 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(437,'3','BSC(FMC)','6','FOOD&ENVIRONEMENTAL MICROBIOLOGY','MIC 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(438,'3','BSC(FMC)','6','MEDICAL MICROBIOLOGY','MIC 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(439,'3','BSC(FMC)','6','SPREAD SHEETS','IDC 300',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(440,'3','BSC(FMC)','6','DATA BASES','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(441,'3','BSC(FMC)','6','SPREAD SHEETS&DATA BASES','IDC 330',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(443,'1','BSC(FMB)','1','HUMAN PHYSIOLOGY','FST 011',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(444,'1','BSC(FMB)','1','INTRODUCTORY MICROBIOLOGY','MIC 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(445,'1','BSC(FMB)','1','PHYSICAL AND GENERAL CHEMISTRY-1','CHE 011B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(446,'1','BSC(FMB)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(447,'1','BSC(FMB)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(448,'1','BSC(FMB)','1','CONTEMPORARY INDIA -ECONOMY, POLITY & SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(449,'1','BSC(FMB)','2','BASIC NUTRITION','FST 012',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(450,'1','BSC(FMB)','2','MICROBIOLOGICAL TECHNIQUES','MIC 012A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(451,'1','BSC(FMB)','2','ORGANIC&INORGANIC CHEMISTRY-1','CHE 012B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(452,'1','BSC(FMB)','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(453,'1','BSC(FMB)','2','TELUGU-2/HINDI-2','TEL 012B/HIN 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(454,'1','BSC(FMB)','2','SCIENCE, TECHNOLOGY & DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(455,'1','BSC(FMB)','2','HUMAN PHYSIOLOGY&BASIC NUTRITION','FST 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(456,'1','BSC(FMB)','2','QUALITATIVE ANALYSIS','BCH 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(457,'1','BSC(FMB)','2','MICROBIOLOGICAL TECHNIQUES','MIC 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(458,'2','BSC(FMB)','3','FOOD SCIENCE','FST 013',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(459,'2','BSC(FMB)','3','MICROBIAL PHYSIOLOGY','MIC 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(460,'2','BSC(FMB)','3','ORGANIC & INORGANIC CHEMISTRY-2','CHE 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(461,'2','BSC(FMB)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(462,'2','BSC(FMB)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(463,'2','BSC(FMB)','3','ENVIRONMENTAL SCIENCE','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(464,'2','BSC(FMB)','4','FOOD TECHNLOGY','FST 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(465,'2','BSC(FMB)','5','MICROBIAL GENETICS','MIC 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(466,'2','BSC(FMB)','5','INTERMDIARY METABOLISM','BCH 014B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(467,'2','BSC(FMB)','5','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(468,'2','BSC(FMB)','5','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(469,'2','BSC(FMB)','5','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(470,'2','BSC(FMB)','5','FOOD SCIENCE&TECHNOLOGY','FST 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(471,'2','BSC(FMB)','5','QUANTITATIVE ANALYSIS','BCH 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(472,'2','BSC(FMB)','5','MICROBIAL PHYSIOLOGY&GENETICS','MIC 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(473,'2','BSC(FMB)','5','GENERAL ENGLISH PRACTICAL','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(474,'2','BSC(FMB)','5','WORD PROCESSING','IDC 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(475,'2','BSC(FMB)','5','VISUAL PRESENTATION','IDC 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(476,'2','BSC(FMB)','5','WORD PROCESSING&VISUAL PRESENTATION','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(477,'3','BSC(FMB)','5','NORMAL NUTRITION & FOOD ADULTERATION','FST 015',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(478,'3','BSC(FMB)','5','IMMUNOLOGY','MIC 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(479,'3','BSC(FMB)','5','PHYSIOLOGY','BCH 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(480,'3','BSC(FMB)','5','ADVANCE DIETETICS','FST 025',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(481,'3','BSC(FMB)','5','MEDICAL MICROBIOLOGY','MIC 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(482,'3','BSC(FMB)','5','MOLECULAR BIOLOGY','MIC 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(483,'3','BSC(FMB)','6','FOOD PRESERVATION, HYGIENE,SANITATION','FST 016',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(484,'3','BSC(FMB)','6','AGRICULTURE & ENVIRONMENT MICROBIOLOGY','MIC 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(485,'3','BSC(FMB)','6','ENDOCRINOLOGY & NUTRITION','BCH 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(486,'3','BSC(FMB)','6','ADVANCED DIETITICS & COMMUNITY NUTRITION','FST 026',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(487,'3','BSC(FMB)','6','FOOD & INDUSTRIAL MICROBIOLOGY','MIC 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(488,'3','BSC(FMB)','6','CLINICAL BIOCHEMISTRY','BCH 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(489,'3','BSC(FMB)','6','NORM NUTRI,ADULTRATION&PRESERVATION','FST 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(490,'3','BSC(FMB)','6','ADVANCED NUTRITION','FST 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(491,'3','BSC(FMB)','6','APPLIED BIOCHEMISTRY','BCH 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(492,'3','BSC(FMB)','6','CLINICAL ANALYSIS','BCH 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(493,'3','BSC(FMB)','6','FOOD&ENVIRONEMENTAL MICROBIOLOGY','MIC 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(494,'3','BSC(FMB)','6','MEDICAL MICROBIOLOGY','MIC 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(495,'3','BSC(FMB)','6','SPREAD SHEETS','IDC 300',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(496,'3','BSC(FMB)','6','DATA BASES','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(497,'3','BSC(FMB)','6','SPREAD SHEETS&DATA BASES','IDC 330',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(498,'1','BSC(BZC)','1','DIVERSITY OF MICROBES AND THALLOPHYTA','BOT 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(499,'1','BSC(BZC)','1','BIOLOGY OF INVERTEBRATES','ZOO 011A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(500,'1','BSC(BZC)','1','PHYSICAL AND GENERAL CHEMISTRY-1','CHE 011B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(501,'1','BSC(BZC)','1','ENGLISH-1','ENG 051',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(502,'1','BSC(BZC)','1','TELUGU-1/HINDI-1','TEL 011A/HIN 021A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(503,'1','BSC(BZC)','1','CONTEMPORARY INDIA -ECONOMY, POLITY & SOCIETY','FOC 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(504,'1','BSC(BZC)','2','BRYOPHYTA,PTERODOPHYTA & GYMNOSPERMS','BOT 012A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(505,'1','BSC(BZC)','2','BIOLOGY OF CHORDATES','ZOO 012A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(506,'1','BSC(BZC)','2','ORGANIC&INORGANIC CHEMISTRY-1','CHE 012B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(507,'1','BSC(BZC)','2','ENGLISH-2','ENG 052',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(508,'1','BSC(BZC)','2','TELUGU-2/HINDI-2','TEL 012B/HIN 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(509,'1','BSC(BZC)','2','SCIENCE, TECHNOLOGY & DEVELOPMENT','FOC 020',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(510,'1','BSC(BZC)','2','PLANT TAX,EMB,RYO,ANG,MEDICAL BOTANY','BOT 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(511,'1','BSC(BZC)','2','BIOLOGY OF INVERT,EMBRYOLOGY&HIST','ZOO 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(512,'2','BSC(BZC)','3','TAXONOMY & EMBRYOLOGY','BOT 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(513,'2','BSC(BZC)','3','BIOMOLECULES, EMBRYOLOGY & ORGANIC EVOLUTION','ZOO 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(514,'2','BSC(BZC)','3','ORGANIC & INORGANIC CHEMISTRY-2','CHE 013A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(515,'2','BSC(BZC)','3','ENGLISH-3','ENG 033',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(516,'2','BSC(BZC)','3','TELUGU-3/HINDI-3','TEL 013B/HIN 033A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(517,'2','BSC(BZC)','3','ENVIRONMENTAL SCIENCE','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(518,'2','BSC(BZC)','4','ANATOMY & MEDICINAL BOTANY','BOT 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(519,'2','BSC(BZC)','4','CELL BIOLOGY,GENETICS & ANIMAL BIOTECHNOLOGY','ZOO 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(520,'2','BSC(BZC)','4','PHYSICAL & GENERAL CHEMISTRY-2','CHE 014A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(521,'2','BSC(BZC)','4','ENGLISH-4','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(522,'2','BSC(BZC)','4','TELUGU-4/HINDI-4','TEL 014A/HIN 034A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(523,'2','BSC(BZC)','4','ENVIRONMENTAL STUDIES','ENS 010',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(524,'2','BSC(BZC)','4','MICROBIOL DIVERSITY,CRYPT,GYMNOS PERMS','BOT 022A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(525,'2','BSC(BZC)','4','BIOLOGY OF CHOR,OSTOL,CYTOLO& GENETICS','ZOO 024A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(526,'2','BSC(BZC)','4','GENERAL ENGLISHPRACTICAL','ENG 034',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(527,'2','BSC(BZC)','4','WORD PROCESSING','IDC 014',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(528,'2','BSC(BZC)','4','VISUAL PRESENTATION','IDC 024',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(529,'2','BSC(BZC)','4','WORD PROCESSING&VISUAL PRESENTATION','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(530,'3','BSC(BZC)','5','PHYSIOLOGY-1 & BIOTECHNOLOGY','BOT 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(531,'3','BSC(BZC)','5','ANIMAL ECOLOGY& ANIMAL BEHAVIOUR','ZOO 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(532,'3','BSC(BZC)','5','INORGANIC & ORGANIC CHEMISTRY-3','che 015A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(533,'3','BSC(BZC)','5','CELL BIOLOGY& GENETICS','BOT 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(534,'3','BSC(BZC)','5','AQUACULTURE','ZOO 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(535,'3','BSC(BZC)','5','PHYSICAL & ORGANIC CHEMISTRY','CHE 025A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(536,'3','BSC(BZC)','6','PHYSIOLOGY-2, SEED TECHNOLOGY & HORTI CULUTURE','BOT 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(537,'3','BSC(BZC)','6','ANIMAL PHYSIOLGOY','ZOO 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(538,'3','BSC(BZC)','6','CHEMISTRY&INDUSTRY-1','CHE 016A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(539,'3','BSC(BZC)','6','APPLIED MICROBIOLOGY&ECOLOGY','BOT 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(540,'3','BSC(BZC)','6','CLINICAL SCIENCE, PARASITOLOGY & IMMUNOLOGY','ZOO 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(541,'3','BSC(BZC)','6','CHEMISTRY&INDUSTRY-2','CHE 026A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(542,'3','BSC(BZC)','6','CELL BIOL,GENET,APPLIED MICROBIOLOGY','BOT 046A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(543,'3','BSC(BZC)','6','PHYSIOL,TISS,CNL TYPE,BIOTECH,SEED TECH AND HORTICUSEOL','BOT 036A',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(544,'3','BSC(BZC)','6','ANIMAL ECOLOGY AND AQUACULTURE','ZOO 036B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(545,'3','BSC(BZC)','6','ANIMAL PHYSIOLGY AND CLINICAL SCIENCE','ZOO 046B',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(546,'3','BSC(BZC)','6','SPREAD SHEETS','IDC 300',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(547,'3','BSC(BZC)','6','DATA BASES','IDC 310',1);
REPLACE INTO "master" ("id", "year", "branch", "semister", "paper", "paperCode", "active") VALUES
	(548,'3','BSC(BZC)','6','SPREAD SHEETS&DATA BASES','IDC 330',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE "master" ENABLE KEYS;*/


#
# Table structure for table 'typeonemaster'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "typeonemaster" (
  "id" int(11) NOT NULL auto_increment,
  "studentId" varchar(45) default NULL,
  "branch" varchar(45) default NULL,
  "year" varchar(45) default NULL,
  "semister" varchar(50) default NULL,
  "paper" varchar(90) default NULL,
  "inter1" varchar(45) default NULL,
  "assignment" varchar(45) default NULL,
  "attendance" varchar(45) default NULL,
  "rating" varchar(45) default NULL,
  "guid" varchar(45) default NULL,
  "active" int(11) default NULL,
  "surname" varchar(45) default NULL,
  "firstname" varchar(45) default NULL,
  "internalType" varchar(45) default NULL,
  PRIMARY KEY  ("id")
) AUTO_INCREMENT=2 /*!40100 DEFAULT CHARSET=latin1 COMMENT='Table to Strore Internal Marks Type - I'*/;



#
# Dumping data for table 'typeonemaster'
#

/*!40000 ALTER TABLE "typeonemaster" DISABLE KEYS;*/
LOCK TABLES "typeonemaster" WRITE;
REPLACE INTO "typeonemaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter1", "assignment", "attendance", "rating", "guid", "active", "surname", "firstname", "internalType") VALUES
	(1,'1111','BA','1','1','INDIAN HISTORY AND CULTURE 700AD','18','0','0','0','0779c09b-322a-4ccb-8a7b-07ec8c72f2de',NULL,'',NULL,'1');
UNLOCK TABLES;
/*!40000 ALTER TABLE "typeonemaster" ENABLE KEYS;*/


#
# Table structure for table 'typetwomaster'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "typetwomaster" (
  "id" int(11) NOT NULL auto_increment,
  "studentId" varchar(45) default NULL,
  "branch" varchar(45) default NULL,
  "year" varchar(45) default NULL,
  "semister" varchar(50) default NULL,
  "paper" varchar(90) default NULL,
  "inter2" varchar(45) default NULL,
  "assignment" varchar(45) default NULL,
  "attendance" varchar(45) default NULL,
  "rating" varchar(45) default NULL,
  "guid" varchar(45) default NULL,
  "active" int(11) default NULL,
  "surname" varchar(45) default NULL,
  "firstname" varchar(45) default NULL,
  "internalType" varchar(45) default NULL,
  PRIMARY KEY  ("id")
) AUTO_INCREMENT=2 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'typetwomaster'
#

/*!40000 ALTER TABLE "typetwomaster" DISABLE KEYS;*/
LOCK TABLES "typetwomaster" WRITE;
REPLACE INTO "typetwomaster" ("id", "studentId", "branch", "year", "semister", "paper", "inter2", "assignment", "attendance", "rating", "guid", "active", "surname", "firstname", "internalType") VALUES
	(1,'1111','BA','1','1','INDIAN HISTORY AND CULTURE 700AD','15','0','4','0','8fd2ffeb-c26c-4d4f-83fd-c4a2df6628dd',NULL,'',NULL,'2');
UNLOCK TABLES;
/*!40000 ALTER TABLE "typetwomaster" ENABLE KEYS;*/
/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
