CREATE TABLE ticket (
  id INT(11) NOT NULL AUTO_INCREMENT,
  placa_vehiculo VARCHAR(8) NOT NULL,
  tipo_vehiculo INT NULL,
  hora_entrada datetime NULL,
  hora_salida VARCHAR(45) NULL,
  created_at datetime NOT NULL,
  total_pagado DOUBLE NULL,
  PRIMARY KEY (id)
  );