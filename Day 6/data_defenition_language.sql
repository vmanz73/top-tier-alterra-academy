-- membuat database 'alta_online_shop'
CREATE DATABASE alta_online_shop;
use alta_online_shop;


-- create table
CREATE TABLE `alta_online_shop`.`users` ( `pelanggan_id` INT(34) NOT NULL , `nama` VARCHAR(128) NOT NULL , `alamat` TEXT NOT NULL , `tanggal_lahir` DATE NOT NULL , `status_user` VARCHAR(128) NOT NULL , `gender` VARCHAR(5) NOT NULL , `created_at` TIMESTAMP NOT NULL ,  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,  PRIMARY KEY (`pelanggan_id`));
CREATE TABLE `alta_online_shop`.`products` ( `product_id` INT(34) NOT NULL , `product_name` VARCHAR(128) NOT NULL , `product_type` VARCHAR(128) NOT NULL , `product_description` TEXT NULL , `operator` VARCHAR(128) NOT NULL , `payment_methods` VARCHAR(50) NOT NULL,  PRIMARY KEY (`product_id`));
CREATE TABLE `alta_online_shop`.`transaction` ( `transaction_id` INT(34) NOT NULL, `product_id` INT(34) NOT NULL , `qty` VARCHAR(128) NOT NULL , `transaction_date` TIMESTAMP NOT NULL , `product_description` TEXT NULL , `price` INT(128) NOT NULL ,  `pelanggan_id` INT(34) NOT NULL ,  PRIMARY KEY (`transaction_id`));


-- create tabel kurir
CREATE TABLE `alta_online_shop`.`kurir` ( `kurir_id` INT(34) NOT NULL , `nama` VARCHAR(128) NOT NULL , `created_at` TIMESTAMP NOT NULL ,  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,  PRIMARY KEY (`pelanggan_id`));


-- tambah ongkos_dasar tabel 'kurir'
ALTER TABLE `kurir` ADD `ongkos_dasar` INT(128) NOT NULL;

-- rename
ALTER TABLE `kurir` RENAME TO `shipping`;

-- drop table
DROP TABLE `shipping`;

