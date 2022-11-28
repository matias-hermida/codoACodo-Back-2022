package ar.com.codoacodo.idiomas;

public class Persona {
	private String nombre;
	private String idioma;
	private String[] otrosIdiomas;

	public Persona(String nombre, String idioma) {
		this.nombre = nombre;
		this.idioma = idioma;
		this.otrosIdiomas = new String[10];
	}

	public void decir(String palabra, String idioma) {

		if (this.idioma.equalsIgnoreCase(idioma)) {
			System.out.println(this.nombre + " dice: " + palabra);
		} else {
			System.out.println(this.nombre + " no sabe decir " + palabra + " en " + idioma);
		}

	}
}
// ctrl+sfhit+f para formateo de texto