package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/CreateProductoController")
public class CreateProductoController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capturo los parametros que viene en el request enviado por el form
		String titulo = req.getParameter("titulo");//name de input
		String codigo = req.getParameter("codigo");//name de input
		String precio = req.getParameter("precio");//name de input
		String fechaAlta = req.getParameter("fechaAlta");//name de input (ver como parsear la fecha)
		String autor = req.getParameter("autor");//name de input
		
		//TODO ver si podemos armar logica para cargar binario
		String img = req.getParameter("img");//name de input (tratamiento especial)
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//facil
		Producto newProducto = new Producto(codigo, titulo, Double.parseDouble(precio), new Date(), autor, img);
		
		try {
			dao.create(newProducto);
			//si todo ok ir a listado.jsp
		} catch (Exception e) {
			//si falla volver al nuevo.jsp
			e.printStackTrace();
		}
		
		//ahora donde vamos!!!
		
	}
	
	public static void main(String[] args) throws Exception{

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//facil
		Producto newProducto = new Producto("codigo00", "Codo a Codo FullStack java", 1D,new Date(), "Autor123", null);
		
		dao.create(newProducto);
		
		System.out.println("id generado para el nuevo producto: " + newProducto.getId());
	}

}