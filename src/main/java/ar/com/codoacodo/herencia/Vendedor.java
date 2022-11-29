package ar.com.codoacodo.herencia;

public class Vendedor {

	// crear un metodo de Clase
	public static Consola[] listado() {
		// Crear consolas
		PlayStation p1 = new PlayStation(1);
		PlayStation p2 = new PlayStation(2);
		PlayStation p3 = new PlayStation(3);
		var nw = new NintendoSwitch();
		var sg = new SegaGenesis();
		var xbox360 = new Xbox360();

		Consola[] listado = new Consola[] { p1, p2, p3, nw, sg, xbox360 };

		return listado;
	}
}