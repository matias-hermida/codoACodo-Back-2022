package ar.com.codoacodo.dao;

import ar.com.codoacodo.domain.Producto;

public interface IProductoDAO {

	/* define los metodos de acceso a la tabla PRODUCTOS */
	/* CRUD */
	public Producto getById(Long id) throws Exception;
	// select * from producto where id = id

	public Producto[] findAll();
	// select * from producto

	public void delete(Long id);
	// delete from producto where id = id

	public void update(Producto producto);
	// update producto
	// set campo1 = valor1.....
	// where id = producto.id

	public void create(Producto newProduct);
	// insert into producto (campo1, ....m campoN)
	// values(newProducto.campo1, ...newProducto.campoN)

}