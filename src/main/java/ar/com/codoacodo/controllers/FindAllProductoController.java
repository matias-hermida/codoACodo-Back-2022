package ar.com.codoacodo.controllers;

import java.util.List;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class FindAllProductoController {

	public static void main(String[] args) throws Exception{

		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		List<Producto> productos = dao.findAll();//[p1,p2...pN] ctrl+t
		//puedo iterar la lista
		
		for(Producto aux  : productos) {
			System.out.println(aux);
			System.out.println("-------------");
		}
	}

}