package ar.com.codoacodo.herencia;

public class PlayStation extends Consola {

	private int version;

	public PlayStation(int version) {
		// invocar al constructor del padre
		super(1024, "PlayStation");
		this.version = version;
	}

	public int getVersion() {
		return this.version;
	}

	public void detalle() {
		System.out.println(this.toString() + " (version=" + version + ")");
	}

}