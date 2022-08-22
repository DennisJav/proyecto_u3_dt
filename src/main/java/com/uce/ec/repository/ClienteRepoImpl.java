package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Cliente;

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crearCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarClienteCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("Select c From Cliente c Where c.cedula =: valor",
				Cliente.class);
		myQuery.setParameter("valor", cedula);
		return myQuery.getSingleResult();
	}

}
