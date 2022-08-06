package com.uce.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.ec.modelo.Habitacion;
import com.uce.ec.modelo.Hotel;
import com.uce.ec.service.IHotelService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class ProyectoU3DApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU3DApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3DApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		LOG.info("INNER JOIN");
//		List<Hotel> listaHotel=this.hotelService.buscarHotelInnerJoin("Normal");
//		for(Hotel h: listaHotel) {
//			LOG.info("Hotel : "+h.getNombre() + " "+h.getDireccion());
//		}
//		
//		LOG.info("lEFT JOIN");
//		List<Hotel> listaHotelL=this.hotelService.buscarHotelOuterJoinLeft("Normal");
//		for(Hotel h: listaHotelL) {
//			LOG.info("Hotel : "+h.getNombre() + " "+h.getDireccion());
//		}
//		
//		LOG.info("RIGHT JOIN");
//		List<Hotel> listaHotelR=this.hotelService.buscarHotelOuterJoinRight("Normal");
//		for(Hotel h: listaHotelR) {
//			LOG.info("Hotel : "+h.getNombre() + " "+h.getDireccion());
//		}
//	
//		
//		LOG.info("lEFT JOIN sin arg");
//		List<Hotel> listaHotelSinArg=this.hotelService.buscarHotelOuterJoinLeft();
//		for(Hotel h: listaHotelSinArg) {
//			LOG.info("Hotel : "+h);
//		}
//		
//		LOG.info("Inner JOIN sin arg");
//		List<Hotel> listaHoteInnerSinArg=this.hotelService.buscarHotelInnerJoin();
//		for(Hotel h: listaHotelSinArg) {
//			LOG.info("Hotel : "+h);
//		}
//		
		LOG.info("Relacionamiento Where");
		List<Hotel> listaHotel=this.hotelService.buscarHotelOuterJoinwhere("Normal");
		for(Hotel h: listaHotel) {
			LOG.info("Hotel : "+h.getNombre() + " "+h.getDireccion());
		}
		
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHotel2=this.hotelService.buscarHotelInnerJoin("Normal");
		for(Hotel h: listaHotel2) {
			LOG.info("Hotel 2  : "+h.getNombre() + " "+h.getDireccion());
			for(Habitacion hab:h.getHabitaciones()) {
				LOG.info("Hotel 2  habitaciones: "+hab);
			}
		}
		
		LOG.info("Relacionamiento Fetch");
		List<Hotel> listaHotel3=this.hotelService.buscarHotelOuterJoinFetch("Normal");
		for(Hotel h: listaHotel3) {
			LOG.info("Hotel : "+h.getNombre() + " "+h.getDireccion());
			for(Habitacion hab:h.getHabitaciones()) {
				LOG.info("Hotel 2  habitaciones: "+hab);
			}
		}
		
		
	}

}
