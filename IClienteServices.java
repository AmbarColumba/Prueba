package com.oficinaJuridica.SGLPWEB.services;

import java.util.List;
import java.util.Optional;

import com.oficinaJuridica.SGLPWEB.model.Cliente;

public interface IClienteServices {
	
	public void insertarCliente(Cliente nuevo) ;
	
	public List<Cliente> listarCliente();
	
	public void guardar(Cliente nuevo);
	
	public void eliminar(int idTipoCasos);
	
	Optional<Cliente> obtenerPorId(int id);
	
	Cliente buscarPorId(int id);
	void actualizar(Cliente cliente);
	
	Cliente buscarPorCI(String ci); // Nuevo método de búsqueda por cédula
	Optional<Cliente> findFirstByCIOrderByIdClienteAsc(String ci);
}
