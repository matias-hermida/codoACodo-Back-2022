package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;

public class DeleteProductoController {

	public static void main(String[] args) throws Exception{

		//recibo el id desde el front (enviado por un formario o por url)
		Long id = 4l;
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//eliminar
		dao.delete(id);//ctrl+t
	}

}