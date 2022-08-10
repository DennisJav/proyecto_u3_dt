package com.uce.ec.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@Column(name = "tra_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tra_sec_id")
	@SequenceGenerator(name = "tra_sec_id", sequenceName = "tra_sec_id", allocationSize = 1)
	private Integer id;
	@Column(name = "tra_fecha")
	private LocalDateTime fecha;
	@Column(name = "tra_monto")
	private BigDecimal monto;

	
	
	@ManyToOne
	@JoinColumn(name = "tra_cta_origen")
	private CuentaBancaria cuentaBancariaOrigen;
	
	@ManyToOne
	@JoinColumn(name = "tra_cta_destino")
	private CuentaBancaria cuentaBancariaDestino;

	
	//set y get
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaBancariaOrigen() {
		return cuentaBancariaOrigen;
	}

	public void setCuentaBancariaOrigen(CuentaBancaria cuentaBancariaOrigen) {
		this.cuentaBancariaOrigen = cuentaBancariaOrigen;
	}

	public CuentaBancaria getCuentaBancariaDestino() {
		return cuentaBancariaDestino;
	}

	public void setCuentaBancariaDestino(CuentaBancaria cuentaBancariaDestino) {
		this.cuentaBancariaDestino = cuentaBancariaDestino;
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + "]";
	}

	
	
	
	
}
