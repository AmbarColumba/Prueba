package com.oficinaJuridica.SGLPWEB.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalendario;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;
    public boolean estado;
    public String Detalle;

    
    @OneToOne
    @JoinColumn(name = "idCaso", nullable = false)
    @JsonBackReference("Calendario-Caso")
    private Caso  caso;
    
    @ManyToOne
    @JoinColumn(name = "idEstadoCalendario", nullable = false)
    @JsonBackReference("Calendario-EstadoCalendario")
    private EstadoCalendario  estadoCalendario;
}
