package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;
import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class CasoHistorica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCasoHistorica;
	
	@Column(unique = false, nullable = true, length = 50)
	private Integer codigo;
	private String nombreCaso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio; 
	@Column( nullable = true)
	private boolean estado;
	@Column( nullable = true)
	private Integer idEstadoCaso;    
	    
}
