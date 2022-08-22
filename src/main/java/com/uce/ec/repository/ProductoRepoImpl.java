package com.uce.ec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Producto;

@Transactional
@Repository
public class ProductoRepoImpl implements IProductoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscarProductoId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarProductoCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub'
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras =: valor", Producto.class);
		myQuery.setParameter("valor", codigoBarras);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizarProducto(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

}
