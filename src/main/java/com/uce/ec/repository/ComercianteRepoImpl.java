package com.uce.ec.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Comerciante;

@Repository
@Transactional
public class ComercianteRepoImpl implements IComercianteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Comerciante> buscarComercianteInnerJoin(String modelo) {
		TypedQuery<Comerciante> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Comerciante c JOIN c.autos a WHERE a.modelo = :valorUno", Comerciante.class);
		myQuery.setParameter("valorUno", modelo);
		return myQuery.getResultList();
	}

	@Override
	public List<Comerciante> buscarComercianteInnerJoin() {
		TypedQuery<Comerciante> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Comerciante c JOIN c.autos a", Comerciante.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinLeft(String modelo) {
		TypedQuery<Comerciante> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Comerciante c LEFT JOIN c.autos a WHERE a.modelo = :valorUno", Comerciante.class);
		myQuery.setParameter("valorUno", modelo);
		return myQuery.getResultList();
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinLeft() {
		TypedQuery<Comerciante> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Comerciante c LEFT JOIN c.autos a", Comerciante.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinRight(String modelo) {
		TypedQuery<Comerciante> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Comerciante c RIGHT JOIN c.autos a WHERE a.modelo = :valorUno", Comerciante.class);
		myQuery.setParameter("valorUno", modelo);
		return myQuery.getResultList();
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinwhere(String modelo) {
		TypedQuery<Comerciante> myQuery = this.entityManager.createQuery(
				"SELECT C FROM Comerciante C, Auto a WHERE c = a.comerciante AND a.modelo =:valorUno", Comerciante.class);
		myQuery.setParameter("valorUno", modelo);
		return myQuery.getResultList();
	}

	@Override
	public List<Comerciante> buscarComercianteOuterJoinFetch(String modelo) {
		TypedQuery<Comerciante> myQuery = this.entityManager.createQuery(
				"SELECT c FROM Comerciante c JOIN FETCH c.autos a WHERE a.modelo = :valorUno", Comerciante.class);
		myQuery.setParameter("valorUno", modelo);
		return myQuery.getResultList();
	}

}
