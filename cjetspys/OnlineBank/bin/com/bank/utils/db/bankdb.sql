#
# Database structure for database 'bankdb'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bankdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bankdb`;


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
) ENGINE=InnoDB AUTO_INCREMENT=1 /*!40100 DEFAULT CHARSET=latin1*/;



