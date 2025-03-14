package com.oficinaJuridica.SGLPWEB.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oficinaJuridica.SGLPWEB.model.Caso;
import com.oficinaJuridica.SGLPWEB.model.Cliente;
import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.model.EstadoCaso;
import com.oficinaJuridica.SGLPWEB.services.ICasoServices;



@Controller
public class CasoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICasoServices servicio;
	
	@GetMapping("/ListarCasos")
	public String listarCaso(Model modelo) {
	    List<Caso> listarCasosN = servicio.listarCaso();

	    if (listarCasosN == null) {
	        listarCasosN = new ArrayList<>();
	    }

	    // Crear una lista con información adicional
	    List<Map<String, Object>> casosConClientes = new ArrayList<>();

	    for (Caso caso : listarCasosN) {
	        Map<String, Object> datosCaso = new HashMap<>();
	        datosCaso.put("idCaso", caso.getIdCaso());
	        datosCaso.put("codigo", caso.getCodigo());	        
	        datosCaso.put("nombreCaso", caso.getNombreCaso());
	        datosCaso.put("fechaInicio", caso.getFechaInicio());
	        datosCaso.put("estado", caso.isEstado());
	        
	        // Obtener el nombre del cliente
	        if (caso.getCliente() != null) {
	            datosCaso.put("nombreCliente", caso.getCliente().getNombres());
	            datosCaso.put("CI", caso.getCliente().getCI());
	        } else {
	            datosCaso.put("nombreCliente", "Sin Cliente");
	        }
	        
	        if (caso.getCtl_TipoCasos() != null) {
	        	datosCaso.put("detalleCtl_TipoCasos", caso.getCtl_TipoCasos().getDetalleCtl_TipoCasos());
	            datosCaso.put("descripcionEstadoCaso", caso.getEstadoCaso().getDescripcionEstadoCaso());
	            
	            //datosCaso.put("CI", caso.));
	        } else {
	            datosCaso.put("detalleCtl_TipoCasos", "Sin detalleCtl_TipoCasos");
	        }

	        casosConClientes.add(datosCaso);
	    }

	    modelo.addAttribute("listarCasos", casosConClientes);

	    return "/Casos/ListarCasos";
	}

	@GetMapping("/nuevoCaso")
	public String nuevoCaso(Model model) {
		Caso nuevoCaso = new Caso();
		nuevoCaso.setEstado(true);
		
		model.addAttribute("registroCaso", nuevoCaso);
		List<Ctl_TipoCasos> listarTipoCaso= servicio.listarCtl_TipoCasos();
		model.addAttribute("listaTiposCasos", listarTipoCaso);
		
		List<Cliente> listarClientes= servicio.listarClientes();
		model.addAttribute("listarClientes", listarClientes);
		
		List<EstadoCaso> listarEstadoCaso= servicio.listarEstadoCasos();
		
		model.addAttribute("listarEstadoCaso", listarEstadoCaso);
		return "/Casos/NuevoCaso";		
	}
	
	@GetMapping("/editar/{id}")
	public String editarCaso(@PathVariable("id") int id , Model model) {
		Caso caso= servicio.buscarPorId(id);
		
		if(caso== null) {
			return "redirect:/listarCasos";
		}
		
		
		if (caso.getFechaInicio() != null) {
	        // Asegurar que la fecha se formatea correctamente antes de enviarla al formulario
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String fechaFormateada = caso.getFechaInicio().toString();
	        
	        //String fechaFormateada2 = caso.setFechaInicio('2025-02-02');
	        
	        	        
	       // model.addAttribute("fechaInicioFormateada", caso.getFechaInicio());
	        // model.addAttribute("fechaInicio", "fechaInicioFormateada");
	    }
		else {
	        model.addAttribute("fechaInicioFormateada", "2025-01-01");
	    }
		
		
		//model.addAttribute("fechaInicioFormateada", "2025-04-01");
		model.addAttribute("registroCaso", caso);
		
		return "/Casos/ActualizarCaso";
		
	}
	
	@PostMapping("/guardarCaso")
	public String guardar(@ModelAttribute("registroCaso") Caso caso ) {
		Optional<Caso> casoExiste= servicio.findFirstByIdCaso(caso.getCodigo());
		if(caso.getIdCaso()>0) {
			//caso.setIdCaso(casoExiste.get().getIdCaso());
			servicio.actualizar(caso);
		}
		else
		{
			caso.setIdCaso(0);
			servicio.guardar(caso);
		}
		
		
		return "redirect:/ListarCasos";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(@PathVariable("id") int id) {
		
		servicio.eliminar(id);
		
		return "redirect:/ListarCasos";
		
	}

}
