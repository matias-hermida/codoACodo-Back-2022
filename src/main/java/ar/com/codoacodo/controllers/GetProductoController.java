package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class GetProductoController {
	
	public static void main(String[] args) throws Exception {

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Long id = 1l;

		Producto p = dao.getById(id);

		if (p != null) {
			System.out.println(p);
		} else {
			System.err.println("no existe el id:" + id);
		}
	}

}