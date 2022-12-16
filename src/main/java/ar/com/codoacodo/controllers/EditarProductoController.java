package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/EditarProductoController")
public class EditarProductoController extends BaseController {

	
	//guardar los datos
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capturar los parametros que se van a actualizar
		String id = req.getParameter("id");
		
		//datos
		String titulo = req.getParameter("titulo");//name de input
		String precio = req.getParameter("precio");//name de input
		String autor = req.getParameter("autor");//name de input
		
		//validaciones!!!
		
		//ok
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto pDB = null;
		try {
			pDB = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			req.setAttribute("errors", List.of("Error actualizando Producto" + e.getMessage()));
		}
		if(pDB == null) {
			irA("/FindAllProductoController", req, resp);
			return;
		}
		
		//recarga en el request el producto para poder verlo en ls jsp  
		
		
		//si existe y no da error sigo!!!
		try {
			//ahora actualizo los datos en el producto
			pDB.setAutor(autor);
			pDB.setPrecio(Double.parseDouble(precio));
			pDB.setTitulo(titulo);
			
			//a la base
			dao.update(pDB);
			
			//aca mensaje de exito, PERO COMO UNA LISTA
			req.setAttribute("success", List.of("Producto id:" + pDB.getId() + " actualizado correctamente"));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("Erro actualizando Producto" + e.getMessage()));
		}
		
		irA("/FindAllProductoController", req, resp);
	}

	//cargar el producto y enviarlo a la jsp
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		//validaciones!!!
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto p = null;
		//cargo los datos 
		try {
			p = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//guardar el producto en request y pasar dicho producto a la jsp
		req.setAttribute("producto", p);
		
		//redirect
		irA("/editar.jsp", req, resp);
	}

}