CREATE TABLE bankapp.address (
	AddressId bigint(20) DEFAULT 0 NOT NULL,
	DoorNo varchar(255),
	StreetName varchar(255),
	City varchar(25),
	Country varchar(25),
	District varchar(255),
	State varchar(255),
	pincode bigint(20),
	PRIMARY KEY (AddressId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
GO
CREATE TABLE bankapp.balance (
	AccountId bigint(20) DEFAULT 0 NOT NULL,
	Balance double,
	PRIMARY KEY (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
GO
CREATE TABLE bankapp.bankuser (
	UserId bigint(20) DEFAULT 0 NOT NULL,
	password varchar(25555),
	SecretKey varchar(25555),
	role varchar(255),
	PRIMARY KEY (UserId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
GO
CREATE TABLE bankapp.customer (
	AccountId bigint(20) DEFAULT 0 NOT NULL,
	DetaildId bigint(20),
	UserId bigint(20),
	PRIMARY KEY (AccountId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
GO
CREATE TABLE bankapp.details (
	DetailsId bigint(20) DEFAULT 0 NOT NULL,
	First_Name varchar(255),
	Last_Name varchar(255),
	Mobile varchar(25),
	EmailId varchar(255),
	Picture mediumblob,
	Signature mediumblob,
	AccountType varchar(25),
	MinimumBalance double,
	AddressID bigint(20),
	PRIMARY KEY (DetailsId)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
GO
