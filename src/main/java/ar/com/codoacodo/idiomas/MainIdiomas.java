package ar.com.codoacodo.idiomas;

import ar.com.codoacodo.interfaces.Espanol;
import ar.com.codoacodo.interfaces.Ingles;

public class MainIdiomas {

	public static void main(String[] args) {

		// Interface i = new ClaseQueImplementaN()
		IIdioma idioma = new Espanol();

		Persona carlos = new Persona("carlos", idioma);
		carlos.decir("hola", "ingles");

		idioma = new Ingles();

		Persona eduardo = new Persona("eduardo", idioma);
		eduardo.decir("hola", "ingles");

		// recrear a carlos
		carlos = new Persona("carlos", idioma);
		carlos.decir("hola", "ingles");

		// f3
		eduardo.aprender("ingles");
		eduardo.aprender("español");// f5
		eduardo.aprender("chino");// f5
	}// f8

}