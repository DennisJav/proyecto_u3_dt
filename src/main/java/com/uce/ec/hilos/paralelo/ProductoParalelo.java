package com.uce.ec.hilos.paralelo;

public class ProductoParalelo {
	private String nombre;
	private String codigoBarras;
	
	
	
	public ProductoParalelo() {
	}
	public ProductoParalelo(String nombre, String codigoBarras) {
		super();
		this.nombre = nombre;
		this.codigoBarras = codigoBarras;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	@Override
	public String toString() {
		return "ProductoParalelo [nombre=" + nombre + ", codigoBarras=" + codigoBarras + "]";
	}

	
	
	
}
