package ar.com.codoacodo.controllers;

import java.util.Scanner;

public class AccionManager {

	public static IAccion buildAccion(int opcion, Scanner teclado) {
		IAccion  accion = null;
		switch (opcion) {
		case 1:
			accion = new CreateProductoController();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;

		default:
			break;
		}

		return accion;
	}
}