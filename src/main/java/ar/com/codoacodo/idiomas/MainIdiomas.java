package ar.com.codoacodo.idiomas;

public class MainIdiomas {

	public static void main(String[] args) {

		Persona carlos = new Persona("carlos","español");
		carlos.decir("hola", "ingles");

		Persona eduardo = new Persona("eduardo", "ingles"); 
		eduardo.decir("hola", "ingles");

		//recrear a carlos 
		carlos = new Persona("carlos", "ingles");
		carlos.decir("hola", "ingles");
	}

}