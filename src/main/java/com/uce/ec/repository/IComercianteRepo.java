package com.uce.ec.repository;

import java.util.List;

import com.uce.ec.modelo.Comerciante;

public interface IComercianteRepo {
	List<Comerciante> buscarComercianteInnerJoin(String modelo);
	List<Comerciante> buscarComercianteInnerJoin();
	List<Comerciante> buscarComercianteOuterJoinLeft(String modelo);
	List<Comerciante> buscarComercianteOuterJoinLeft();
	List<Comerciante> buscarComercianteOuterJoinRight(String modelo);
	List<Comerciante> buscarComercianteOuterJoinwhere(String modelo);
	List<Comerciante> buscarComercianteOuterJoinFetch(String modelo);

}
