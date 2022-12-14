package ar.com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;

@WebServlet("/DeleteProductoController")
public class DeleteProductoController extends HttpServlet{

	public static void main(String[] args) throws Exception{

		//recibo el id desde el front (enviado por un formario o por url)
		Long id = 4l;
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//eliminar
		dao.delete(id);//ctrl+t
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("idProducto"));//viene como String -> Long.parseLong()
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//eliminar
		try {
			dao.delete(id);
			//mensaje de exito
		} catch (Exception e) {
			e.printStackTrace();
			//mensaje de error
		}//ctrl+t
		
		//ahora redirect!!!!
		getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
	}
}