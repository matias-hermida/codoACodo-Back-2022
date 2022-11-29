package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.domain.Producto;

public class ProductoDAOMysqlImpl implements IProductoDAO {

	@Override
	public Producto getById(Long id) throws Exception {

		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
		Statement statement = connection.createStatement();

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery(sql);

		// verifico si hay datos
		if (resultSet.next()) {
			// obtengo el dato del campo id
			Long idDb = resultSet.getLong("id");
			String codigo = resultSet.getString("codigo");
			String titulo = resultSet.getString("titulo");
			Double precio = resultSet.getDouble("precio");
			Date fechaAlta = resultSet.getDate("fecha_alta");
			String autor = resultSet.getString("autor");
			String img = resultSet.getString("img");

			return new Producto(idDb, codigo, titulo, precio, fechaAlta, autor, img);
		}
		// flata cerrar la connection!!!
		return null;
	}

	@Override
	public Producto[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(Producto newProduct) {
		// TODO Auto-generated method stub

	}

}