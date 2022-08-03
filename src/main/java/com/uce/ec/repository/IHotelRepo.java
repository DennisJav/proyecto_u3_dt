package com.uce.ec.repository;

import java.util.List;

import com.uce.ec.modelo.Hotel;

public interface IHotelRepo {

	List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	List<Hotel> buscarHotelInnerJoin();
	List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	List<Hotel> buscarHotelOuterJoinLeft();
	List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion);
	List<Hotel> buscarHotelOuterJoinwhere(String tipoHabitacion);
	List<Hotel> buscarHotelOuterJoinFetch(String tipoHabitacion);

}	

