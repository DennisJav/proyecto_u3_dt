package com.uce.ec.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "auto")
public class Auto {

	@Id
	@Column(name = "auto_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aut_sec_id")
	@SequenceGenerator(name = "aut_sec_id", sequenceName = "aut_sec_id", allocationSize = 1)
	private Integer id;
	@Column(name = "auto_modelo")
	private String modelo;
	@Column(name = "auto_marca")
	private String marca;
	@Column(name = "auto_cilindraje")
	private String cilindraje;
	@Column(name = "auto_placa")
	private String placa;
	
	
	@ManyToOne
	@JoinColumn(name = "auto_id_comerciante")
	private Comerciante comerciante;
	
	
	public Comerciante getComerciante() {
		return comerciante;
	}
	public void setComerciante(Comerciante comerciante) {
		this.comerciante = comerciante;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "Auto [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", cilindraje=" + cilindraje + ", placa="
				+ placa + ", comerciante=" + comerciante + "]";
	}

 
	
	
	
	
}
