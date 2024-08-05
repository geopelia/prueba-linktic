CREATE DATABASE IF NOT EXISTS mydatabase;
GRANT ALL PRIVILEGES ON mydatabase.* TO 'myuser'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE mydatabase;
CREATE TABLE clientes(
	tipo_documento tinyint(1) NOT NULL, 
	numero_documento varchar(30) NOT NULL, 
	nombres varchar(200) NOT null, 
	apellidos varchar(200) NOT NULL, 
	sexo tinyint(1) NOT NULL, 
	fecha_nacimiento DATE NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	PRIMARY KEY(tipo_documento, numero_documento) 
);
CREATE TABLE amparos(
	codigo int NOT NULL PRIMARY KEY,
	descripcion varchar(200) NOT null
);
CREATE TABLE primas(
	id int not null auto_increment PRIMARY KEY,
	codigo_amparo int NOT NULL,
	edad_minima tinyint unsigned NOT NULL,
	edad_maxima tinyint unsigned NOT NULL,
	porcentaje_prima decimal(5,5) NOT NULL,
	FOREIGN KEY (codigo_amparo) REFERENCES amparos(codigo) ON DELETE cascade
);
INSERT INTO clientes values
(1, "79000001", "NOMBRE1", "APELLIDO1",1, str_to_date("10-01-1945", "%d-%m-%Y")),
(1, "79000002", "NOMBRE2", "APELLIDO2",1, str_to_date("10-01-1950", "%d-%m-%Y")),
(1, "79000003", "NOMBRE3", "APELLIDO3",1, str_to_date("10-01-1955", "%d-%m-%Y")),
(2, "51000001", "NOMBRE4", "APELLIDO4",2, str_to_date("10-01-1960", "%d-%m-%Y")),
(2, "51000002", "NOMBRE5", "APELLIDO5",2, str_to_date("10-01-1965", "%d-%m-%Y")),
(2, "51000003", "NOMBRE6", "APELLIDO6",2, str_to_date("10-01-1970", "%d-%m-%Y"));

INSERT INTO amparos values
(1, "Muerte accidental"),
(2, "Desmembración"),
(3, "Auxilio funerario"),
(4, "Renta vitalicia");

INSERT into primas(codigo_amparo, edad_minima, edad_maxima, porcentaje_prima) values
(1, 18, 45, 0.02304),
(1, 46, 75, 0.02012),
(2, 18, 50, 0.1809),
(2, 51, 70, 0.16043),
(3, 18, 60, 0.14123),
(3, 61, 70, 0.1545),
(4, 18, 50, 0.12123),
(4, 51, 70, 0.1345);
