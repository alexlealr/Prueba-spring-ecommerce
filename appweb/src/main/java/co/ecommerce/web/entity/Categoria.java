package co.ecommerce.web.entity;

import java.util.List;


public class Categoria {

	private Long id;
	private String codigo;
	private String nombre;
	private String foto;
	private String categoria_padre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getCategoria_padre() {
		return categoria_padre;
	}
	public void setCategoria_padre(String categoria_padre) {
		this.categoria_padre = categoria_padre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
}
