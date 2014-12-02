CREATE TABLE `company` (
  `Cid` varchar(50) NOT NULL,
  `MarketValuation` double DEFAULT NULL,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `hold` (
  `userID` varchar(50) NOT NULL,
  `Sid` varchar(50) NOT NULL,
  `shares` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`,`Sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `investors` (
  `userID` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `Assets` double NOT NULL,
  `AmountofShares` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `market` (
  `marketIndex` int(11) DEFAULT NULL,
  `VariationRange` double DEFAULT NULL,
  `OverallCapital` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `stock` (
  `Sid` varchar(50) NOT NULL,
  `Price_share` double DEFAULT NULL,
  `OverallShares` int(11) DEFAULT NULL,
  `Variation_Range` double DEFAULT NULL,
  `Cid` varchar(50) NOT NULL,
  PRIMARY KEY (`Sid`),
  UNIQUE KEY `Cid_UNIQUE` (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `events` (
  `eventID` int(11) NOT NULL,
  `incident` varchar(256) DEFAULT NULL,
  `Variation_Range` double NOT NULL,
  PRIMARY KEY (`eventID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




