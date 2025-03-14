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
public class Ctl_TipoCasos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoCasos;
	String detalleCtl_TipoCasos;
	private boolean estado;
	
	
	 @OneToMany(mappedBy = "ctl_TipoCasos")
	    @JsonManagedReference("tipoCaso-caso") // 🔹 Nombre único que coincide con @JsonBackReference en Caso.java
	    private List<Caso> casos;

}
