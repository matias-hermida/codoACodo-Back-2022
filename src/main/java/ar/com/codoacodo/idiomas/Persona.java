package ar.com.codoacodo.idiomas;

public class Persona implements IHablar {
	private String nombre;
	private IIdioma idioma;

	private IIdioma[] otrosIdiomas;

	public Persona(String nombre, IIdioma idioma) {
		this.nombre = nombre;
		this.idioma = idioma;
		this.otrosIdiomas = new IIdioma[0];
	}

	// ctrl+space
	public void hablar() {
		System.out.println(this.nombre + "sabe hablar: ");
		System.out.println(this.idioma);
		for (IIdioma idioma : this.otrosIdiomas) {
			System.out.println(idioma);
		}
	}

	public void decir(String palabra, IIdioma idioma) {

		if (this.idioma == idioma) {
			System.out.println(this.nombre + " dice: " + palabra);
		} else {
			System.out.println(this.nombre + " no sabe decir " + palabra + " en " + idioma);
		}

	}

	public void aprender(IIdioma idioma) {

		if (!this.idioma.equals(idioma)) {// f6 f7
			// ver si existe en el array de otrosIdiomas
			if (hablaEsteIdioma(idioma)) {// f6
				System.out.println(this.nombre + " ya habla " + idioma);
			} else {
				System.out.println(this.nombre + " aprede " + idioma);
				this.otrosIdiomas = copiarIdiomas(idioma);
			}
		} else {
			System.out.println(this.nombre + " ya habla " + idioma);
		}
	}

	private IIdioma[] copiarIdiomas(IIdioma idioma) {
		// agregarlo a la lista!!!!
		IIdioma[] aux = new IIdioma[this.otrosIdiomas.length + 1];// [ ,]
		for (int i = 0; i < this.otrosIdiomas.length; i++) {
			aux[i] = this.otrosIdiomas[i];
		}
		// al final de nuevo array aux, agrego el idioma que aprende
		aux[aux.length - 1] = idioma;
		return aux;
	}

	private boolean hablaEsteIdioma(IIdioma idioma) {
		boolean existe = false;
		for (int i = 0; !existe && i < this.otrosIdiomas.length; i++) {
			existe = this.otrosIdiomas[i].equals(idioma);// true|false
		}
		return existe;
	}

	public void decirAlgoEnTodosLosIdiomas(String algo) {
		// dice algo SEGUROOOOOOO en el idoma nativo
		this.idioma.decir(algo);

		for (IIdioma aux : this.otrosIdiomas) {
			aux.decir(algo);
		}
	}

}// ctrl+sfhit+f