 
USE `citystars`;
SELECT *   FROM CHANNEL;
Drop  TABLE IF EXISTS `channel`;
 
CREATE TABLE IF NOT EXISTS `channel` (
  `channel_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '0',
  `value` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


 
INSERT INTO `channel` (`name`, `value`) VALUES
	('EMAIL', 10),
	('FACEBOOK', 5),
	('WHATSAPP', 15),
	('SMS', 20),
	('EMAGAZINE', 15);
 