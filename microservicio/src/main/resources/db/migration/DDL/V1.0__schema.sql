create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE IF NOT EXISTS `mydb`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `placa_vehiculo` VARCHAR(8) NOT NULL,
  `tipo_vehiculo` TIME NOT NULL,
  `hora_entrada` TIME NOT NULL,
  `hora_salida` VARCHAR(45) NULL,
  `created_at` TIMESTAMP NOT NULL,
  `total_pagado` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB