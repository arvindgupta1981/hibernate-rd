DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `STOCK_ID` INT(10) UNSIGNED NOT NULL ,
  `STOCK_CODE` VARCHAR(10) NOT NULL,
  `STOCK_NAME` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
 
 
DROP TABLE IF EXISTS `stock`.`stock_daily_record`;
CREATE TABLE  `stock`.`stock_daily_record` (
  `RECORD_ID` INT(10) UNSIGNED NOT NULL ,
  `PRICE_OPEN` FLOAT(6,2) DEFAULT NULL,
  `PRICE_CLOSE` FLOAT(6,2) DEFAULT NULL,
  `PRICE_CHANGE` FLOAT(6,2) DEFAULT NULL,
  `VOLUME` BIGINT(20) UNSIGNED DEFAULT NULL,
  `DATE` DATE NOT NULL,
  `STOCK_ID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_DAILY_DATE` (`DATE`),
  KEY `FK_STOCK_TRANSACTION_STOCK_ID` (`STOCK_ID`),
  CONSTRAINT `FK_STOCK_TRANSACTION_STOCK_ID` FOREIGN KEY (`STOCK_ID`) 
  REFERENCES `stock` (`STOCK_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;