package com.uce.ec.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.ec.modelo.Hotel;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :valorUno", Hotel.class);
		myQuery.setParameter("valorUno", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"Select h from Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo =:valorUno", Hotel.class);
		myQuery.setParameter("valorUno", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				//      iZQUIERDA HOTEL              LA DERECHA ES HABITACION 
				"Select h from Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo =:valorUno", Hotel.class);
		myQuery.setParameter("valorUno", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinwhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				//      iZQUIERDA HOTEL              LA DERECHA ES HABITACION 
				"Select h from Hotel h JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				//      iZQUIERDA HOTEL              LA DERECHA ES HABITACION 
				"Select h from Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

}
