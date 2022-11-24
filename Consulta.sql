/*insertar registro en una tabla*/ 
INSERT INTO producto (codigo,titulo,precio,fecha_alta,autor,img)
	VALUES ('abcde00000','microfono hyperx',2500,CURDATE(),'Juan',NULL);
	
/*SELECT columnas from tabla*/
SELECT * FROM producto;

/*UPPERcase*/
INSERT INTO producto (codigo,titulo,precio,fecha_alta,autor,img)
	VALUES (UPPER('abcde00001'),UPPER('microfono hyperx'),2500,CURDATE(),UPPER('Juan'),NULL);
	
/*para actualizar un campo de una tabla*/
UPDATE producto
SET img = 'http://misitio.com.ar/img/abc.jpg'
WHERE ID = 4;

/*consulta por campo especifico*/
SELECT * FROM producto
WHERE ID = 4;

/*eliminar un registro de una tabla, siempre poner el WHERE*/
DELETE FROM producto
WHERE ID = 2;

/*SELECT consultar todos los registros de la tabla*/
SELECT * FROM producto;

/*UPDATE de 2 o mas campos*/
UPDATE producto
SET titulo = UPPER('termo lumilago'), 
	precio = 35000, 
	img = 'http://misitio.com.ar/img/def.jpg'
WHERE ID = 1;

/*SELECT con campos especificos*/
SELECT id,titulo,precio,img FROM producto;

/*CREAR TABLA VIA SCRIPT*/
/*DDL*/
CREATE TABLE producto_1 (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	codigo VARCHAR(10) NOT NULL,
	titulo VARCHAR(100) NOT NULL,
	precio FLOAT NOT NULL,
	fecha_creacion DATE NOT NULL,
	autor VARCHAR(50),
	img VARCHAR(100)
);
/*ahora agrego UNIQUE al campo codigo*/
ALTER TABLE producto_1 ADD CONSTRAINT UN_producto_codigo UNIQUE INDEX(CODIGO);

/*describir la tabla, viendo campos y atributos*/
DESCRIBE producto;
DESCRIBE producto_1;

/*restriccion de precio >= 0*/
ALTER TABLE producto_1 ADD CONSTRAINT CHECK(precio >= 0);
ALTER TABLE producto ADD CONSTRAINT CHECK(precio >= 0);

/*este falla pq precio < 0*/
INSERT INTO producto_1 (codigo,titulo,precio,fecha_creacion,autor,img)
	VALUES (UPPER('abcde00001'),UPPER('microfono hyperx'),-100,CURDATE(),UPPER('Jose'),NULL);
	
/*este no falla pq precio >= 0*/
INSERT INTO producto_1 (codigo,titulo,precio,fecha_creacion,autor,img)
	VALUES (UPPER('abcde00001'),UPPER('microfono hyperx'),0,CURDATE(),UPPER('Jose'),NULL);
	
	
/*creo tabla aux*/
CREATE TABLE producto_2 (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	codigo VARCHAR(10) NOT NULL,
	titulo VARCHAR(100) NOT NULL,
	precio FLOAT NOT NULL,
	fecha_creacion DATE NOT NULL,
	autor VARCHAR(50),
	img VARCHAR(100)
);

/*elimino tabla aux*/
DROP TABLE producto_2;

DESCRIBE producto_2;


/*crear tabla tipo producto*/
CREATE TABLE tipo_producto (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	descripcion VARCHAR(50) NOT NULL
);

INSERT INTO tipo_producto (descripcion) VALUES ('LIBRO');
INSERT INTO tipo_producto (descripcion) VALUES ('MUSICA');
INSERT INTO tipo_producto (descripcion) VALUES ('PELICULA');
INSERT INTO tipo_producto (descripcion) VALUES ('PASATIEMPO');

/*agregarle un campo a tabla producto*/
ALTER TABLE producto ADD tipo_producto_id INT;

/*agregar una foreign key en tabla producto*/
ALTER TABLE producto ADD CONSTRAINT FK_producto_tipo_producto_id FOREIGN KEY (tipo_producto_id) REFERENCES tipo_producto(id);

/*intento insertar un tipo_producto_id que NO existe en tipo_producto*/
INSERT INTO producto (codigo,titulo,precio,fecha_alta,autor,img,tipo_producto_id)
	VALUES (UPPER('abcde00002'),UPPER('microfono genius'),100,CURDATE(),UPPER('jose'),NULL,5);

/*intento insertar un tipo_producto_id que SI existe en tipo_producto*/
INSERT INTO producto (codigo,titulo,precio,fecha_alta,autor,img,tipo_producto_id)
	VALUES (UPPER('abcde00002'),UPPER('microfono genius'),100,CURDATE(),UPPER('jose'),NULL,4);

SELECT * FROM producto
WHERE tipo_producto_id IS NOT NULL;

/*para actualizar un campo de una tabla*/
UPDATE producto
SET tipo_producto_id = 2
WHERE ID = 1;

UPDATE producto
SET tipo_producto_id = 1
WHERE ID = 4;

/*busco en la tabla tipo_producto el registro que tenga id=1*/
SELECT * FROM tipo_producto WHERE id = 1;

/*consultas con join*/
SELECT * FROM producto JOIN tipo_producto 
	WHERE producto.tipo_producto_id = tipo_producto.id;
	
/*alias de campos*/
SELECT
	id AS ID_PROD,
	tipo_producto_id AS TIPO
FROM producto;

/*alias de tablas*/
SELECT *	
FROM producto AS p
JOIN tipo_producto AS tp
WHERE p.tipo_producto_id = tp.id;


SELECT *	
	FROM producto AS p
		INNER JOIN tipo_producto AS tp
	WHERE p.id = tp.id;

SELECT *	
	FROM producto AS p
		INNER JOIN tipo_producto AS tp
	WHERE p.id = tp.id
	AND p.precio > 5000;

SELECT *	
	FROM producto AS p
		INNER JOIN tipo_producto AS tp
			ON p.tipo_producto_id = tp.id;

SELECT P.id, P.autor, P.precio, TP.descripcion
	FROM producto P
		INNER JOIN tipo_producto TP
			ON P.tipo_producto_id = TP.id
			WHERE P.id >= 4;
			



/***********************************************************************/
/*CREATE TABLE `producto` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`codigo` VARCHAR(10) NOT NULL DEFAULT '0' COLLATE 'latin1_spanish_ci',
	`titulo` VARCHAR(100) NOT NULL DEFAULT '0' COLLATE 'latin1_spanish_ci',
	`precio` FLOAT NOT NULL DEFAULT '0',
	`fecha_alta` DATE NOT NULL,
	`autor` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_spanish_ci',
	`img` VARCHAR(100) NULL DEFAULT NULL COLLATE 'latin1_spanish_ci',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `codigo` (`codigo`) USING BTREE
)
COMMENT='primer tabla del crso de db: codo a codo'
COLLATE='latin1_spanish_ci'
ENGINE=InnoDB
;

INSERT INTO `codo-a-codo-22569`.`producto` (`titulo`, `precio`, `fecha_alta`) VALUES ('TERMO_STANLEY', 30000, '2022-11-24');*/