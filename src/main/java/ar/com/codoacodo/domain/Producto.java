package ar.com.codoacodo.domain;

import java.util.Date;

public class Producto {

	private Long id;
	private String codigo;
	private String titulo;
	private Double precio;
	private Date fechaAlta;
	private String autor;
	private String img;
	private String cat;

	public Producto(String codigo, String titulo, Double precio, Date fechaAlta, String autor, String img, String cat) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.precio = precio;
		this.fechaAlta = fechaAlta;
		this.autor = autor;
		this.img = img;
		this.cat = cat;
	}

	public Producto(Long id, String codigo, String titulo, Double precio, Date fechaAlta, String autor, String img, String cat) {
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
		this.precio = precio;
		this.fechaAlta = fechaAlta;
		this.autor = autor;
		this.img = img;
		this.cat = cat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", precio=" + precio
				+ ", fechaAlta=" + fechaAlta + ", autor=" + autor + ", img=" + img + "]";
	}

	// alt+shift+s

}