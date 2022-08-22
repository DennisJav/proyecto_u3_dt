package com.uce.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Cliente;
import com.uce.ec.repository.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo clienteRepo;
	
	@Override
	public void crearCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.crearCliente(cliente);
	}

	@Override
	public Cliente buscarClienteCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarClienteCedula(cedula);
	}
	

}
