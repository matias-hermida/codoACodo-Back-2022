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

@WebServlet("/EditarProductoController")
public class EditarProductoController extends BaseController {

	
	//guardar los datos
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//carpturar los parametros que se van a actualizar
		
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
		super.irA("/editar.jsp", req, resp);
	}

}