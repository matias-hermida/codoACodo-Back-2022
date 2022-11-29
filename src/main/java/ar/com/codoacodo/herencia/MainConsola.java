package ar.com.codoacodo.herencia;

public class MainConsola {

	public static void main(String[] args) {
		Consola[] listado = Vendedor.listado();
		for (Consola c : listado) {
			System.out.println(c.getClass().getName());
			//Imprimo de metodo q es igual para todos los hijos
			System.out.println(c.getDatos());
			//Imprimo de metodo q NO es igual para todos los hijos (el detalle() de PlayStation es diferente)
			c.detalle();
			System.out.println("--------------------------------------------");	
		}
	}

}