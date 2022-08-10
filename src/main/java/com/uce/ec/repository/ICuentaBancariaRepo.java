package com.uce.ec.repository;

import com.uce.ec.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {

	void actualizar(CuentaBancaria cuentaBancaria);
	CuentaBancaria buscarCuentaBancariaNumero(String numeroCuenta);
	
}
