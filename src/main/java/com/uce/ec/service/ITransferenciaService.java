package com.uce.ec.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public interface ITransferenciaService {

	void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto);
	void realizarTransferenciaFachada(String cuentaOrigen, String cuentaDestino, BigDecimal monto);
}
