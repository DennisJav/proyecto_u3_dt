package com.uce.ec.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comerciante")
public class Comerciante {

	@Id
	@Column(name = "come_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "com_sec_id")
	@SequenceGenerator(name = "com_sec_id", sequenceName = "com_sec_id", allocationSize = 1)
	private Integer id;
	@Column(name = "come_nombre")
	private String nombre;
	@Column(name = "come_apellido")
	private String apellido;
	@Column(name = "come_cedula")
	private String cedula;
	@Column(name = "come_agencia")
	private String agencia;
	
	
	@OneToMany(mappedBy = "comerciante",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Auto> autos;
	
	
	
	public List<Auto> getAutos() {
		return autos;
	}
	
	
	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	@Override
	public String toString() {
		return "Comerciante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", agencia=" + agencia + "]";
	}
	
	
	
	
	
}
