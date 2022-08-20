package com.uce.ec.service;

import com.uce.ec.modelo.CuentaBancaria;

public interface ICuentaBancariaService {

	void actualizar(CuentaBancaria cuentaBancaria);
	CuentaBancaria buscarCuentaBancariaNumero(String numeroCuenta);
}
