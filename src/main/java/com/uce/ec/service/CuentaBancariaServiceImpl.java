package com.uce.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.CuentaBancaria;
import com.uce.ec.repository.ICuentaBancariaRepo;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;
	
	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaBancariaRepo.actualizar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria buscarCuentaBancariaNumero(String numeroCuenta) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepo.buscarCuentaBancariaNumero(numeroCuenta);
	}

}
