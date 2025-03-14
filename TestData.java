package com.oficinaJuridica.SGLPWEB.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.services.ICtl_TipoCasosServices;

@RestController  // 🔹 Cambiado de @Controller a @RestController
@RequestMapping("/api/tipocaso")  // 🔹 Se usa un prefijo común para la API
public class TestData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ICtl_TipoCasosServices servicio;

    @GetMapping("/listar")  // 🔹 Ahora devuelve JSON en lugar de una vista
    public List<Ctl_TipoCasos> listarTipoCaso() {
        return servicio.listarCtl_TipoCasos();
    }
}
