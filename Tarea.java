package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import lombok.Data;
@Data
@Entity
public class Tarea implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTarea;
	private String Detalle;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private boolean estado;	
	
	@ManyToOne
	@JoinColumn(name = "idCasos")
	@JsonBackReference("Tarea-caso") // 🔹 Se asigna un nombre único a la referencia
	private Caso fkcaso;

	@ManyToOne	
	@JoinColumn(name = "idAsesor")
	@JsonBackReference("Tarea-asesor") // 🔹 Se asigna un nombre único a la referencia
	private Cliente cliente;
	
	@ManyToOne	
	@JoinColumn(name = "idEstadoTarea")
	@JsonBackReference("Tarea-caso") // 🔹 Se asigna un nombre único a la referencia
	private EstadoTarea fkestadoTarea;
	    
}
