package com.uce.ec.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.ec.modelo.Hotel;
import com.uce.ec.repository.HotelRepoImpl;
import com.uce.ec.repository.IHotelRepo;

@Service
public class HotelServiceImpl implements IHotelService{

	private static final Logger LOG = LogManager.getLogger(HotelServiceImpl.class);
	
	@Autowired
	private IHotelRepo hotelRepo;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelOuterJoinLeft();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinwhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepo.buscarHotelOuterJoinwhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa service: "+TransactionSynchronizationManager.isActualTransactionActive());
		
		return this.hotelRepo.buscarHotelOuterJoinFetch(tipoHabitacion);
	}



}
