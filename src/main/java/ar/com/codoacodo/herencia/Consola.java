package ar.com.codoacodo.herencia;

//una clase abstracta no se puede instanciar
public abstract class Consola {

	protected int bit;
	private String name;

	public Consola(int bit, String name) {
		this.bit = bit;
		this.name = name;
	}

	public int getBit() {
		return this.bit;
	}

	public String getName() {
		return name;
	}

	// alt+shit+s
	public String getDatos() {
		return this.getName() + " - " + String.valueOf(this.getBit());
	}

	public void detalle() {
		System.out.println(this.toString());
	}

	public String toString() {
		return "Consola [bit=" + bit + ", name=" + name + "]";
	}

	// alt+shit+s

}