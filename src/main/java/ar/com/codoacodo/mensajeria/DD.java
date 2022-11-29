package ar.com.codoacodo.mensajeria;

public class DD implements IMensaje {
	public void enviar(String msj) {
		System.out.println("Grabando en DISCO en /temp- " + msj);
	}
}