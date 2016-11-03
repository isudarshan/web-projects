# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             asi_db
# Server version:       5.0.45-community-nt
# Server OS:            Win32
# Target-Compatibility: Same as source server (MySQL 5.0.45-community-nt)
# max_allowed_packet:   1048576
# HeidiSQL version:     3.1 RC1 Revision: 1064
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1*/;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0*/;


#
# Database structure for database 'asi_db'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `asi_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `asi_db`;


#
# Table structure for table 'appuser'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `appuser` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `question` varchar(255) default NULL,
  `answer` varchar(255) default NULL,
  `userrole` varchar(255) default NULL,
  `createdon` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedon` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'appuser'
#

/*!40000 ALTER TABLE `appuser` DISABLE KEYS*/;
LOCK TABLES `appuser` WRITE;
REPLACE INTO `appuser` (`id`, `guid`, `username`, `password`, `question`, `answer`, `userrole`, `createdon`, `createdby`, `modifiedon`, `modifiedby`, `active`) VALUES
	(1,'1f09aefe-545c-438d-a72d-a1232bf54ecb','admin','admin','What is your pet name ?','sunny','admin','2013-03-03 16:16:32',1,'2013-03-03 16:16:32',1,1),
	(13,'2289c0a7-5b86-4062-8d14-2ef8b28f52a8','111','SAI181802013','What was your childhood nickname?','siddu','student','2013-03-23 15:21:37',1,'2013-03-23 15:22:58',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `appuser` ENABLE KEYS*/;


#
# Table structure for table 'department'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `department` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `deptname` varchar(255) default NULL,
  `deptcode` varchar(255) default NULL,
  `createdon` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedon` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'department'
#

/*!40000 ALTER TABLE `department` DISABLE KEYS*/;
LOCK TABLES `department` WRITE;
REPLACE INTO `department` (`id`, `guid`, `deptname`, `deptcode`, `createdon`, `createdby`, `modifiedon`, `modifiedby`, `active`) VALUES
	(1,'93d843ea-d7ad-478f-a3ce-1303b7ee760a','Computer Science Engineering','CSE',NULL,NULL,NULL,NULL,NULL),
	(2,'56aaf6be-97a0-471b-9146-1b4bfbd5182b','Master of Computer Applications','MCA',NULL,NULL,NULL,NULL,NULL),
	(3,'a645f218-af7b-4ff1-aa82-71581a2e151e','Ecectronics Engineering','ECE',NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `department` ENABLE KEYS*/;


#
# Table structure for table 'faculty'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `faculty` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `facultyName` varchar(255) default NULL,
  `departmentName` varchar(255) default NULL,
  `departmentCode` varchar(50) default NULL,
  `email` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `createdOn` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedOn` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'faculty'
#

/*!40000 ALTER TABLE `faculty` DISABLE KEYS*/;
LOCK TABLES `faculty` WRITE;
REPLACE INTO `faculty` (`id`, `guid`, `facultyName`, `departmentName`, `departmentCode`, `email`, `mobile`, `createdOn`, `createdby`, `modifiedOn`, `modifiedby`, `active`) VALUES
	(6,'a4e91e35-816c-45f6-9fde-212f21834a15','Sudarsan','Computer Science Engineering','CSE','zarvis.a@gmail.com','9676534400',NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `faculty` ENABLE KEYS*/;


#
# Table structure for table 'facultymap'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `facultymap` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `subjectName` varchar(255) default NULL,
  `subjectCode` varchar(255) default NULL,
  `departmentName` varchar(255) default NULL,
  `departmentCode` varchar(50) default NULL,
  `year` varchar(255) default NULL,
  `semister` varchar(255) default NULL,
  `facultyname` varchar(255) default NULL,
  `createdOn` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedOn` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'facultymap'
#

/*!40000 ALTER TABLE `facultymap` DISABLE KEYS*/;
LOCK TABLES `facultymap` WRITE;
REPLACE INTO `facultymap` (`id`, `guid`, `subjectName`, `subjectCode`, `departmentName`, `departmentCode`, `year`, `semister`, `facultyname`, `createdOn`, `createdby`, `modifiedOn`, `modifiedby`, `active`) VALUES
	(7,'c15fbb74-cb02-400b-8f28-45f65226368e','Java','JAVA','Computer Science Engineering','CSE','Year - I','1','Sudarsan',NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `facultymap` ENABLE KEYS*/;


#
# Table structure for table 'feedback'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `feedback` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `subjectName` varchar(255) default NULL,
  `subjectCode` varchar(255) default NULL,
  `departmentName` varchar(255) default NULL,
  `departmentCode` varchar(50) default NULL,
  `year` varchar(255) default NULL,
  `semister` varchar(255) default NULL,
  `studentId` varchar(255) default NULL,
  `facultyName` varchar(255) default NULL,
  `feedBackTotal` varchar(255) default NULL,
  `createdOn` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedOn` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'feedback'
#

/*!40000 ALTER TABLE `feedback` DISABLE KEYS*/;
LOCK TABLES `feedback` WRITE;
REPLACE INTO `feedback` (`id`, `guid`, `subjectName`, `subjectCode`, `departmentName`, `departmentCode`, `year`, `semister`, `studentId`, `facultyName`, `feedBackTotal`, `createdOn`, `createdby`, `modifiedOn`, `modifiedby`, `active`) VALUES
	(12,'2b528a3c-5b43-4154-9c8b-d77c6a46df62','Java','JAVA','Computer Science Engineering','CSE','Year - I','1','111','Sudarsan','30',NULL,NULL,NULL,NULL,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS*/;


#
# Table structure for table 'student'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `student` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `subjectName` varchar(255) default NULL,
  `subjectCode` varchar(255) default NULL,
  `departmentName` varchar(255) default NULL,
  `departmentCode` varchar(50) default NULL,
  `year` varchar(255) default NULL,
  `semister` varchar(255) default NULL,
  `studentId` varchar(255) default NULL,
  `firstName` varchar(255) default NULL,
  `lastName` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `createdOn` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedOn` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'student'
#

/*!40000 ALTER TABLE `student` DISABLE KEYS*/;
LOCK TABLES `student` WRITE;
REPLACE INTO `student` (`id`, `guid`, `subjectName`, `subjectCode`, `departmentName`, `departmentCode`, `year`, `semister`, `studentId`, `firstName`, `lastName`, `email`, `mobile`, `address`, `createdOn`, `createdby`, `modifiedOn`, `modifiedby`, `active`) VALUES
	(12,'03a4995b-51db-4387-95e9-be7a41401fc5','subject',NULL,'Computer Science Engineering','CSE','Year - I','1','111','Sai','A','zarvis.a@gmail.com','9676534400','TestTest','2013-03-23 15:21:37',1,'2013-03-23 15:21:37',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `student` ENABLE KEYS*/;


#
# Table structure for table 'subject'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `subject` (
  `id` int(10) NOT NULL auto_increment,
  `guid` varchar(255) NOT NULL,
  `subjectName` varchar(255) default NULL,
  `subjectCode` varchar(255) default NULL,
  `departmentName` varchar(255) default NULL,
  `departmentCode` varchar(50) default NULL,
  `year` varchar(255) default NULL,
  `semister` varchar(255) default NULL,
  `createdOn` datetime default NULL,
  `createdby` int(10) default NULL,
  `modifiedOn` datetime default NULL,
  `modifiedby` int(10) default NULL,
  `active` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'subject'
#

/*!40000 ALTER TABLE `subject` DISABLE KEYS*/;
LOCK TABLES `subject` WRITE;
REPLACE INTO `subject` (`id`, `guid`, `subjectName`, `subjectCode`, `departmentName`, `departmentCode`, `year`, `semister`, `createdOn`, `createdby`, `modifiedOn`, `modifiedby`, `active`) VALUES
	(7,'c02e04c7-d0e0-4e59-b3d0-ab697bbc67dc','Java','JAVA','Computer Science Engineering','CSE','Year - I','1',NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `subject` ENABLE KEYS*/;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS*/;
