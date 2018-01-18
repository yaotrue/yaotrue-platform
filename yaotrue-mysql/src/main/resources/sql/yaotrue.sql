SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS t_la_member;




/* Create Tables */

CREATE TABLE t_la_member
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	user_name varchar(100) NOT NULL,
	password varchar(500),
	real_name varbinary(100),
	gender tinyint,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (user_name)
);



