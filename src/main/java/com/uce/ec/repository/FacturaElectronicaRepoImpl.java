package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepoImpl implements IFacturaElectronicaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearFacturaElectronica(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(facturaElectronica);
		//throw new RuntimeException();
	}

}
