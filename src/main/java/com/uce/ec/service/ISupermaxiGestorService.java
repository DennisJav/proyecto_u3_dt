package com.uce.ec.service;

import java.util.List;

public interface ISupermaxiGestorService {

	void crearFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras);
	void crearFacturaElectronica(String numeroFactura);
	void actualizarStock(String numeroFactura);
}
