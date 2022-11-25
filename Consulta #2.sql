CREATE TABLE libro (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	articulo_id INT NOT NULL /*foreign key*/,
	ibsn VARCHAR(15) NOT NULL /*unique*/,
	sinopsis VARCHAR(100),
	editorial VARCHAR(50)
);
DESCRIBE libro;

/*ahora agrego UNIQUE al campo*/
ALTER TABLE libro ADD CONSTRAINT UN_libro_ibsn UNIQUE INDEX(ibsn);
/*ahora agrego UNIQUE al campo*/
ALTER TABLE libro ADD CONSTRAINT UN_libro_articulo_id UNIQUE INDEX(articulo_id);

/*agregar una foreign key en tabla producto*/
ALTER TABLE libro ADD CONSTRAINT FK_libro_articulo_id FOREIGN KEY (articulo_id) REFERENCES producto(id);
/*ALTER TABLE libro ADD CONSTRAINT FK_libro_producto_articulo_id FOREIGN KEY (articulo_id) REFERENCES producto(id);*/

/*producto no es posible agregar valores < 0*/
ALTER TABLE producto ADD CONSTRAINT CHECK(precio >= 0);

/*consultas basicas de sql*/
/*todos los producto - libros*/
SELECT * 
FROM producto p
	INNER JOIN libro l
		ON p.id = l.articulo_id;
/*solo producto - libros q cumplen condicion del where*/
SELECT * 
FROM producto p
	INNER JOIN libro l
		ON p.id = l.articulo_id
	WHERE p.id > 2;
/*solo ciertos campos de producto - libros q cumplen condicion del where*/
SELECT p.codigo, p.precio,
	l.ibsn 
FROM producto p
	INNER JOIN libro l
		ON p.id = l.articulo_id
	WHERE p.precio BETWEEN 100 AND 30000; /*p.precio >= 100 AND p.precio <= 30000*/
	
/*productos tal que un campo sea = a los siguientes valores: IN(VAL1,VAL2,...,VALn)*/
SELECT * FROM producto
WHERE tipo_producto_id IN(1,3,4) OR tipo_producto_id IS NULL;

/*funciones*/
SELECT MAX(PRECIO) FROM producto;
SELECT MIN(PRECIO) FROM producto;

/*limitar cantidad de elementos que traigo de una base*/
SELECT * FROM producto LIMIT 2 OFFSET 1;

/*LIKE*/
SELECT * FROM producto WHERE titulo LIKE 'Ter%';
SELECT * FROM producto WHERE UPPER(titulo) LIKE '%RX';
SELECT * FROM producto WHERE LOWER(titulo) LIKE '%fono%';

/*articulos que sean libros, precio >= 100 and precio <= 5000 and exista una imagen*/
SELECT * 
	FROM producto p
		INNER JOIN libro l
			ON l.articulo_id = p.id
	WHERE p.precio BETWEEN 100 AND 5000
		AND p.img IS NOT NULL
		OR p.precio >= 35000;
		
UPDATE producto
	SET img = 'una url de mentira'
	WHERE id = 8;

/*group / order*/
SELECT * FROM producto ORDER BY precio DESC;
SELECT * FROM producto ORDER BY fecha_alta ASC, id DESC;

/*exists*/
/*group*/
/*having*/

