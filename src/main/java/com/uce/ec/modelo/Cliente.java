package com.uce.ec.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_id_clie")
	@SequenceGenerator(name = "sec_id_clie", sequenceName = "sec_id_clie", allocationSize = 1)
	private Integer id;
	
	
	@Column(name = "clie_cedula")
	private String cedula;
	@Column(name = "clie_numero_tarjeta")
	private String numeroTarjeta;

	//relaciones

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Factura> facturas;
	
	
	//set y get
	
	
	public List<Factura> getFacturas() {
		return facturas;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	
	
	
	
}
