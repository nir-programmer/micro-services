DROP TABLE IF EXISTS customer; 
DROP TABLE IF EXISTS accounts;


CREATE TABLE `customer`(
	`customer_id` int AUTO_INCREMENT PRIMARY KEY, 
	`name` VARCHAR(100) NOT NULL, 
	`email` VARCHAR(100) NOT NULL, 
	`mobile_number` VARCHAR(20) NOT NULL,
	`create_dt` date DEFAULT NULL

);


CREATE TABLE `accounts`( 

`customer_id` int NOT NULL, 
`account_number` int AUTO_INCREMENT PRIMARY KEY, 
`account_type` VARCHAR(100) NOT NULL, 
`branch_address` VARCHAR(200) NOT NULL, 
`create_dt` date DEFAULT NULL



)	;


INSERT INTO `customer` (`name`, `email`, `mobile_number`, `create_dt`)
VALUES('Nir Itzhak' ,'niritzhak10@gmail.com', '9544678017', CURDATE());  


INSERT INTO `accounts` (`customer_Id`, `account_number`, `account_type`, `branch_address`, `create_dt`)
VALUES(1, 186576453, 'Savings','123 Hod Hasharon, Israel', CURDATE() );


