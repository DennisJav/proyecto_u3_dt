package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Transferencia;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional( value = TxType.MANDATORY)
	public void crearTransferencia(Transferencia transferencia) {
		// TODO Auto-generated method stub

		this.entityManager.persist(transferencia);

	}

}
