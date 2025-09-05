use newhr;

drop table request_log;


CREATE TABLE `request_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `req_class` varchar(50) DEFAULT NULL,
  `req_method` varchar(50) DEFAULT NULL,
  `req_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;

select * from request_log;