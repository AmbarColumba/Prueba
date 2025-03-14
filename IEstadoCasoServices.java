package com.oficinaJuridica.SGLPWEB.services;

import java.util.List;
import java.util.Optional;

import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.model.EstadoCaso;

public interface IEstadoCasoServices {
	public void insertarEstadoCaso(EstadoCaso nuevo) ;
	
	public List<EstadoCaso> listarEstadoCaso();
	
	public void guardar(EstadoCaso nuevo);
	
	public void eliminar(int idTipoCasos);
	
	Optional<EstadoCaso> obtenerPorId(int id);


}
