package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class EstadoCalendario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstadoCalendario ;
	private String descripcionEstadoCalendario;
	
	@OneToMany(mappedBy = "estadoCalendario")
	@JsonManagedReference("estadoCalendario-caso")
	private List<Calendario> calendario;
	

}
