package com.uce.ec.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@Column(name = "cuba_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuba_sec_id")
	@SequenceGenerator(name = "cuba_sec_id", sequenceName = "cuba_sec_id", allocationSize = 1)
	private Integer id;
	@Column(name = "cuba_numero_cuenta")
	private String numeroCuenta;
	@Column(name = "cuba_saldo")
	private BigDecimal saldo;
	@Column(name = "cuba_tipo")
	private String tipo;

	
	@OneToMany(mappedBy = "cuentaBancariaOrigen", cascade = CascadeType.ALL)
	private List<Transferencia> transferenciasOrigen;
	
	@OneToMany(mappedBy = "cuentaBancariaDestino", cascade = CascadeType.ALL)
	private List<Transferencia> transferenciasDestino;

	
	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Transferencia> getTransferenciasOrigen() {
		return transferenciasOrigen;
	}

	public void setTransferenciasOrigen(List<Transferencia> TransferenciasOrigen) {
		this.transferenciasOrigen = TransferenciasOrigen;
	}

	public List<Transferencia> getTransferenciasDestino() {
		return transferenciasDestino;
	}

	public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
		this.transferenciasDestino = transferenciasDestino;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", tipo=" + tipo
				+ ", transferenciasOrigen=" + transferenciasOrigen + ", transferenciasDestino=" + transferenciasDestino + "]";
	}
	
	
	
	
	
}
