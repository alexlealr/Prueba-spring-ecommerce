package co.ecommerce.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;



public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2593804100626327375L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long id;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private int peso;
	@Column
	private long precio;
	@Column
	private String imagen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")
	private Categoria categ;
}
