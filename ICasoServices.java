package com.oficinaJuridica.SGLPWEB.services;

import java.util.List;
import java.util.Optional;

import com.oficinaJuridica.SGLPWEB.model.Caso;
import com.oficinaJuridica.SGLPWEB.model.Cliente;
import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.model.EstadoCaso;

public interface ICasoServices {
	
	public void insertarCaso(Caso nuevo) ;
	
	public List<Caso> listarCaso();
	
	public void guardar(Caso nuevo);
	
	public void eliminar(int idTipoCasos);
	
	Optional<Caso> obtenerPorId(int id);
	
	Caso buscarPorId(int id);
	public void actualizar(Caso Caso);
	
	Caso buscarPorCodigo(Integer codigo); // Nuevo método de búsqueda por cédula
	Optional<Caso> findFirstByIdCaso(Integer codigo);
	
	public List<Ctl_TipoCasos> listarCtl_TipoCasos();
	
	public List<Cliente> listarClientes();
	
	public List<EstadoCaso> listarEstadoCasos();
	
	
				   

}
