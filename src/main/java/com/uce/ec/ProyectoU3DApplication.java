package com.uce.ec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.ec.modelo.Auto;
import com.uce.ec.modelo.Comerciante;
import com.uce.ec.modelo.Habitacion;
import com.uce.ec.modelo.Hotel;
import com.uce.ec.service.IComercianteService;
import com.uce.ec.service.IHotelService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class ProyectoU3DApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IComercianteService iComercianteService;
	
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
//		LOG.info("Relacionamiento Where");
//		List<Hotel> listaHotel=this.hotelService.buscarHotelOuterJoinwhere("Normal");
//		for(Hotel h: listaHotel) {
//			LOG.info("Hotel : "+h.getNombre() + " "+h.getDireccion());
//		}
//		
//		LOG.info("INNER JOIN EAGER/LAZY");
//		List<Hotel> listaHotel2=this.hotelService.buscarHotelInnerJoin("Normal");
//		for(Hotel h: listaHotel2) {
//			LOG.info("Hotel 2  : "+h.getNombre() + " "+h.getDireccion());
//			for(Habitacion hab:h.getHabitaciones()) {
//				LOG.info("Hotel 2  habitaciones: "+hab);
//			}
//		}
//		
//		LOG.info("Relacionamiento Fetch");
//		List<Hotel> listaHotel3=this.hotelService.buscarHotelOuterJoinFetch("Normal");
//		for(Hotel h: listaHotel3) {
//			LOG.info("Hotel : "+h.getNombre() + " "+h.getDireccion());
//			for(Habitacion hab:h.getHabitaciones()) {
//				LOG.info("Hotel 2  habitaciones: "+hab);
//			}
//		}
//		
//		
//		LOG.info("INNER JOIN");
//		List<Comerciante> listaComerciantes = this.iComercianteService.buscarComercianteInnerJoin("Toyota");
//		for(Comerciante h: listaComerciantes) {
//			LOG.info("Hotel : "+h.getNombre()+" "+h.getCedula());
//		}
//		
//		LOG.info("lEFT JOIN");
//		List<Comerciante> listaComerciantes1 = this.iComercianteService.buscarComercianteOuterJoinLeft("Toyota");
//		for(Comerciante h: listaComerciantes1) {
//			LOG.info("Hotel : "+h.getNombre()+" "+h.getCedula());
//		}
//		
//		LOG.info("RIGHT JOIN");
//		List<Comerciante> listaComerciantes2 = this.iComercianteService.buscarComercianteOuterJoinRight("Toyota");
//		for(Comerciante h: listaComerciantes2) {
//			LOG.info("Hotel : "+h.getNombre()+" "+h.getCedula());
//		}
//	
//		
//		LOG.info("lEFT JOIN sin arg");
//		List<Comerciante> listaComerciantes3 = this.iComercianteService.buscarComercianteOuterJoinLeft();
//		for(Comerciante h: listaComerciantes3) {
//			LOG.info("Hotel : "+h.getNombre()+" "+h.getCedula());
//		}
//		
//		LOG.info("Inner JOIN sin arg");
//		List<Comerciante> listaComerciantes4 = this.iComercianteService.buscarComercianteInnerJoin();
//		for(Comerciante h: listaComerciantes4) {
//			LOG.info("Hotel : "+h.getNombre()+" "+h.getCedula());
//		}

		
		LOG.info("Relacionamiento Where");
		List<Comerciante> listaComerciantes4 = this.iComercianteService.buscarComercianteOuterJoinwhere("Toyota");
		for(Comerciante h: listaComerciantes4) {
			LOG.info("Comerciante : "+h.getNombre()+" "+h.getCedula());
		}
		
		
		LOG.info("Relacionamiento Fetch");
		List<Comerciante> listaComerciantes5=this.iComercianteService.buscarComercianteOuterJoinFetch("Toyota");
		for(Comerciante h: listaComerciantes5) {
			LOG.info("Comerciante : "+h.getNombre() );
			for(Auto hab:h.getAutos()) {
				LOG.info("Comerciante  Autos: "+hab);
			}
		}
		
		
		
	}

}
