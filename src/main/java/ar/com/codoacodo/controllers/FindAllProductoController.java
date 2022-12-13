package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

//una clase que extiendo de HttpServlet
//GET > http://localhost:8080/app-web/FindAllProductoController

@WebServlet("/FindAllProductoController")
public class FindAllProductoController extends HttpServlet{

	//tienen dos metondos:
	//doGet
	//doPost
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		//tengo la lista
		List<Producto> productos = new ArrayList<>();
		
		//si explota la consulta a la la base, solo atrapo el error y muestro con consola el error
		try {
			productos = dao.findAll();//[p1,p2...pN] ctrl+
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		//antes de irme a la nueva pagina
		//clave, valor
		req.setAttribute("productos", productos);
		
		//este bloque de codigo lo vamos a usar en todos lados
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}

}