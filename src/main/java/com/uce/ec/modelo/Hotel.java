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
@Table(name = "hotel")
public class Hotel {

	@Id
	@Column(name = "hote_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hote_sec_id")
	@SequenceGenerator(name = "hote_sec_id", sequenceName = "hote_sec_id", allocationSize = 1)
	private Integer id;
	@Column(name = "hote_nombre")
	private String nombre;
	@Column(name = "hote_direccion")
	private String direccion;
	
	//relacion
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
	private List<Habitacion> habitaciones;
	
	
	
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	//set y get
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", habitaciones=" + habitaciones
				+ "]";
	}
	
	
	
	
}
