package com.uce.ec.repository;

import com.uce.ec.modelo.Cliente;

public interface IClienteRepo {

	void crearCliente(Cliente cliente);
	Cliente buscarClienteCedula(String cedula);
	
}
