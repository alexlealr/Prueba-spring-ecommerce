package co.ecommerce.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import java.util.List;


@Entity
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 524556446344543065L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	@Column
	@NotBlank
	private String codigo;
	@Column
	private String nombre;
	@Column
	private String foto;
	@Column
	private String categoria_padre;
	@OneToMany(mappedBy = "categ")
	private List<Producto> codigoProducto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
  
}
