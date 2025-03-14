package com.oficinaJuridica.SGLPWEB.services;

import java.util.List;
import java.util.Optional;

import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;

public interface ICtl_TipoCasosServices {
	public void insertarCtl_TipoCasos(Ctl_TipoCasos nuevo) ;
	
	public List<Ctl_TipoCasos> listarCtl_TipoCasos();
	
	public void guardar(Ctl_TipoCasos nuevo);
	
	public void eliminar(int idTipoCasos);
	
	Optional<Ctl_TipoCasos> obtenerPorId(int id);


}
