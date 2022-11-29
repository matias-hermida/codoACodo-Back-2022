package ar.com.codoacodo.mensajeria;

public class DB implements IMensaje {
	public void enviar(String msj) {
		System.out.println("Grabando en DB: TABLA XYZ - " + msj);
	}
}