package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/SearchProductosController")
public class SearchProductosController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//buscar en la db productos por titulo
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		//obtengo la clave enviado desde el formulario que esta en navbar.jsp 
		String clave = req.getParameter("claveBusqueda");
		
		//FALTAN VALIDACIONES!!!
		
		//busco!
		List<Producto> productos;
		try {
			productos = dao.search(clave);
		} catch (Exception e) {
			productos = List.of();//crea una lista vacia
			e.printStackTrace();
		}
		
		//guardar en el request, los datos que encontre en la busqueda
		//antes de irme a la nueva pagina: guardo en el request los datos que puede necesitar la JSP
		//clave, valor
		req.setAttribute("productos", productos);
		
		//este bloque de codigo lo vamos a usar en todos lados
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}