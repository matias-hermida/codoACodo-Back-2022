package ar.com.codoacodo.controllers;

import java.util.Date;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class CreateProductoController implements IAccion {


	@Override
	public void execute() {
		/*
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//facil
		Producto newProducto = new Producto("codigo00", "Codo a Codo FullStack java", 1D,new Date(), "Autor123", null);
		
		dao.create(newProducto);
		
		System.out.println("id generado para el nuevo producto: " + newProducto.getId());
		
		 */
	}
	
	public static void main(String[] args) throws Exception{

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//facil
		Producto newProducto = new Producto("codigo00", "Codo a Codo FullStack java", 1D,new Date(), "Autor123", null);
		
		dao.create(newProducto);
		
		System.out.println("id generado para el nuevo producto: " + newProducto.getId());
	}

}