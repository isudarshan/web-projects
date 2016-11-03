
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



CREATE TABLE `TBL_CUSTOMER` (

   `id` INT(10) NOT NULL AUTO_INCREMENT, 
   `guid` VARCHAR (255) NOT NULL, 
   `accountNumber` VARCHAR (255) default NULL, 
   `firstName` VARCHAR (255) default NULL, 
   `lastName` VARCHAR (255) default NULL, 
   `gender` VARCHAR (255) default NULL, 
   `dateOfBirth` VARCHAR (255) default NULL, 
   `email` VARCHAR (255) default NULL, 
   `mobile` VARCHAR (255) default NULL, 
   `userPic` LONGBLOB default NULL, 
   `signature` LONGBLOB default NULL, 
   `createdon` DATE default NULL, 
   `createdby` INT(10) default NULL, 
   `modifiedon` DATE default NULL, 
   `modifiedby` INT(10) , 
   `active` INT(10) default NULL, 
   PRIMARY KEY(`id`)
 ) ENGINE = InnoDB AUTO_INCREMENT=1;
