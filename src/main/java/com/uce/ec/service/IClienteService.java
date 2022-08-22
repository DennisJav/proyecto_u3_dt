package com.uce.ec.service;

import com.uce.ec.modelo.Cliente;

public interface IClienteService {
	void crearCliente(Cliente cliente);
	Cliente buscarClienteCedula(String cedula);

}
