package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/CreateProductoController")
public class CreateProductoController extends BaseController {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//capturo los parametros que viene en el request enviado por el form
		String titulo = req.getParameter("titulo");//name de input
		String codigo = req.getParameter("codigo");//name de input
		String precio = req.getParameter("precio");//name de input
		String fechaAlta = req.getParameter("fechaAlta");//name de input (ver como parsear la fecha)
		String autor = req.getParameter("autor");//name de input
		String cat = req.getParameter("cat");//name de input
		
		//validaciones!
		List<String> errores = new ArrayList<>();
		if(titulo == null || "".equals(titulo)) {
			errores.add("Titulo vacío");
		}
		if(codigo== null || "".equals(codigo)) {
			errores.add("Codigo vacío");
		}
		//agrego las demas validaciones!!!! (uds)
		if(!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			//vuelvo a la jsp con la lista de errores cargadas 
			super.irA("/nuevo.jsp", req, resp);
			return;
		}
		
		//TODO ver si podemos armar logica para cargar binario
		String img = req.getParameter("img");//name de input (tratamiento especial)
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//facil
		Producto newProducto = new Producto(codigo, titulo, Double.parseDouble(precio), new Date(), autor, img, cat);
		
		try {
			dao.create(newProducto);
			//si todo ok ir a listado.jsp
			//agregar mensaje de exito
			req.setAttribute("success", List.of("Alta de producto exitosa"));
		} catch (Exception e) {
			//si falla volver al nuevo.jsp
			e.printStackTrace();
		}
		
		//ahora donde vamos!!!
		//ahora redirect!!!!
		//getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
		super.irA("/FindAllProductoController", req, resp);
	}

}