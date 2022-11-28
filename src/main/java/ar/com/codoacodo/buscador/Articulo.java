package ar.com.codoacodo.buscador;

public class Articulo {

	// atributos
	private String img;
	private String titulo;
	private String autor;
	private double precio;

	// contructor
	public Articulo(String img, String titulo, String autor, double precio) {
		this.img = img;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	// metodos
	public void detalle() {
		System.out.println("detallando articulo..");
		System.out.println(
				"Articulo [img=" + img + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]");
	}

	// uso Alt+Shift+S, pongo Generate toString(), y copio el formato del string
	// para usarlo en el println de detalle()
	/*
	 * @Override public String toString() { return "Articulo [img=" + img +
	 * ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]"; }
	 */
}