package ar.com.codoacodo.mensajeria;

public class MensajeBuilder {

	// METODO DE CLASE, no de instancia
	// no necesito crear un objeto de la clase MensajeBuilder
	// para usar el metodo buildMensaje(String)
	public static IMensaje buildMensaje(String destino) {
		IMensaje msj;

		switch (destino) {// f6
		case "A":
			msj = new SMS();
			break;
		case "B":
			msj = new DB();
			break;
		case "C":
			msj = new Mail();
			break;
		case "D":
			msj = new DD();
			break;
		default:
			msj = null;
			System.out.println("No existe implementacion para " + destino);
		}
		return msj;
	}

}