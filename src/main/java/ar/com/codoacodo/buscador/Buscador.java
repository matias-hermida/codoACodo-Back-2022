package ar.com.codoacodo.buscador;

public class Buscador {

	// atributos
	private String claveBusqueda;
	private int cantidad;
	private Articulo[] resultados;

	public Buscador() {
		// TODO Auto-generated constructor stub
	}

	// metodos
	public void buscar() {
		// crear dos articulos y ponerlos dentro de
		// array/vector resultados

		// crear un array
		/*
		 * int[] array = new int[2]; String[] nombres = new String[2]; boolean[] flags =
		 * new boolean[2]; Articulo[] otroRes = new Articulo[2];
		 */

		// select * from articulo
		// magica convertis esos a datos a objetos

		// creo el array de articulos
		resultados = new Articulo[2];

		// creo 2 resultados Articulos
		Articulo res1 = new Articulo("http://sitio.com.ar/img/1.jpg", claveBusqueda, " autor 1", 2450);
		Articulo res2 = new Articulo("http://sitio.com.ar/img/2.jpg", claveBusqueda, " autor 2", 1850);

		// cargar en cada posicion un articulo
		resultados[0] = res1;
		resultados[1] = res2;

		// actualizo la cantidad de resultados
		// en base al tamanio del vector
		cantidad = resultados.length;
	}

	public void setClaveBusqueda(String claveQueVieneDeAfuera) {
		claveBusqueda = claveQueVieneDeAfuera;
	}

	public Articulo[] getResultados() {
		return resultados;
	}

	public int getTotal() {
		return cantidad;
	}
}