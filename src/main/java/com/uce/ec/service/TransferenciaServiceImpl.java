package com.uce.ec.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.ec.modelo.CuentaBancaria;
import com.uce.ec.modelo.Transferencia;
import com.uce.ec.repository.HotelRepoImpl;
import com.uce.ec.repository.ICuentaBancariaRepo;
import com.uce.ec.repository.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	private static final Logger LOG = LogManager.getLogger(TransferenciaServiceImpl.class);
	
	
	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;
	@Autowired
	private ITransferenciaRepo transferenciaRepo;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
//	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub

		LOG.info("Transaccion activa service transferencia: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		CuentaBancaria ctaOrigen = this.cuentaBancariaRepo.buscarCuentaBancariaNumero(cuentaOrigen);
		CuentaBancaria ctaDestino = this.cuentaBancariaRepo.buscarCuentaBancariaNumero(cuentaDestino);
		

		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));	
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		
		this.cuentaBancariaRepo.actualizar(ctaOrigen);
		this.cuentaBancariaRepo.actualizar(ctaDestino);
		
		
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaBancariaDestino(ctaDestino);
		transferencia.setCuentaBancariaOrigen(ctaOrigen);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		
		this.transferenciaRepo.crearTransferencia(transferencia);
		
		
	}


	@Override
	@Transactional(value = TxType.REQUIRED)
//	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferenciaFachada(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa service transferencia fachada: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
	}

}
