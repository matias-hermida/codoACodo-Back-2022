package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.Internal.ListAdapter;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/SearchProductosByCategoryController")
public class SearchProductosByCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//buscar en la db productos por titulo
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Set<String> setCategoria = null;
		
		//le pido al dao todas las categorias de productos
		try {
			setCategoria = dao.allCategories();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//elimino aquellas no tildadas
		List<String> listCategoriasTildadas = new ArrayList<String>();
		
		for(String cat : setCategoria) {
			String clave = req.getParameter(cat);
			if(clave != null) {
				listCategoriasTildadas.add(cat);
			};
		}

		//busco!
		List<Producto> productos;
		if(listCategoriasTildadas.isEmpty()) {
			try {
				productos = dao.findAll();
			} catch (Exception e) {
				productos = List.of();//crea una lista vacia
				e.printStackTrace();
			}
		} else {
			try {
				productos = dao.searchByCategory(listCategoriasTildadas);
			} catch (Exception e) {
				productos = List.of();//crea una lista vacia
				e.printStackTrace();
			}
		}
		
		//guardar en el request, los datos que encontre en la busqueda
		//antes de irme a la nueva pagina: guardo en el request los datos que puede necesitar la JSP
		//clave, valor
		req.setAttribute("productos", productos);
		
		//este bloque de codigo lo vamos a usar en todos lados
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}