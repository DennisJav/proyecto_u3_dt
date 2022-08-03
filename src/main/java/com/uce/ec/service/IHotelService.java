package com.uce.ec.service;

import java.util.List;

import com.uce.ec.modelo.Hotel;

public interface IHotelService {
	List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	List<Hotel> buscarHotelInnerJoin();
	List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	List<Hotel> buscarHotelOuterJoinLeft();
	List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion);
	List<Hotel> buscarHotelOuterJoinwhere(String tipoHabitacion);
	List<Hotel> buscarHotelOuterJoinFetch(String tipoHabitacion);
}
