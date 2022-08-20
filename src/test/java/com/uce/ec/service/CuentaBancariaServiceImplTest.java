package com.uce.ec.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.ec.modelo.CuentaBancaria;
@SpringBootTest
@Transactional
@Rollback(true)
class CuentaBancariaServiceImplTest {
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	@Test
	void testActualizar() {
		CuentaBancaria cuenta = this.iCuentaBancariaService.buscarCuentaBancariaNumero("123");
		cuenta.setTipo("Corriente");
		this.iCuentaBancariaService.actualizar(cuenta);
		assertNotEquals(this.iCuentaBancariaService.buscarCuentaBancariaNumero("123").getTipo(),"Ahorro");
	}

	@Test
	void testBuscarCuentaBancariaNumero() {
		String numero = "123";
		assertEquals(numero, this.iCuentaBancariaService.buscarCuentaBancariaNumero(numero).getNumeroCuenta());
	}

}
