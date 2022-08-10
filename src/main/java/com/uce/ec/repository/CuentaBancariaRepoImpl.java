package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.ec.modelo.CuentaBancaria;
import com.uce.ec.modelo.Hotel;

@Transactional
@Repository
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {

	private static final Logger LOG = LogManager.getLogger(CuentaBancariaRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa repository INSERTAR: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED) 
	public CuentaBancaria buscarCuentaBancariaNumero(String numeroCuenta) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa repository BUSCAR: "+TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numeroCuenta =:valorUno", CuentaBancaria.class);
		myQuery.setParameter("valorUno", numeroCuenta);
		return myQuery.getSingleResult();
	}

}
