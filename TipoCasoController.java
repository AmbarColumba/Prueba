package com.oficinaJuridica.SGLPWEB.controller;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;




import com.oficinaJuridica.SGLPWEB.model.Ctl_TipoCasos;
import com.oficinaJuridica.SGLPWEB.services.ICtl_TipoCasosServices;

@Controller

public class TipoCasoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ICtl_TipoCasosServices servicio;

    @GetMapping("/ListarTipoCaso")
    public String listarTipoCasoPage(Model model) {
    	List<Ctl_TipoCasos> listarTipoCaso= servicio.listarCtl_TipoCasos(); 
    	model.addAttribute("listarTipoCaso",listarTipoCaso );
    	return "/TipoCaso/ListarTipoCasos";
    }
    

    @PostMapping("/TipoCaso/guardar")
    public String guardarTipoCaso(@ModelAttribute Ctl_TipoCasos tipoCaso) {
    	
    	tipoCaso.setIdTipoCasos(0);
        servicio.guardar(tipoCaso); // Llamar al servicio para guardar
        return "redirect:/ListarTipoCaso"; // Redirigir a la lista después de guardar
    }
    
    @GetMapping("/TipoCaso/eliminar/{id}")
    public String eliminarTipoCaso(@PathVariable("id") int id) {
        servicio.eliminar(id); // Llamar al servicio para eliminar
        return "redirect:/ListarTipoCaso"; // Redirigir a la lista después de eliminar
    }


    @PostMapping(value = "/TipoCaso/editar/{id}", 
            consumes = "application/json", 
            produces = "application/json")

@ResponseBody
public ResponseEntity<Map<String, Object>> editarTipoCaso(@PathVariable("id") int id, @RequestBody Ctl_TipoCasos tipoCaso) {
   Map<String, Object> response = new HashMap<>();
   try {
       Optional<Ctl_TipoCasos> optionalCaso = servicio.obtenerPorId(id);
       if (optionalCaso.isPresent()) {
           Ctl_TipoCasos casoExistente = optionalCaso.get();
           casoExistente.setDetalleCtl_TipoCasos(tipoCaso.getDetalleCtl_TipoCasos());
           casoExistente.setEstado(tipoCaso.isEstado());
           servicio.guardar(casoExistente);

           response.put("status", "success");
           response.put("message", "Caso actualizado correctamente");
           response.put("caso", casoExistente);
           return ResponseEntity.ok(response);
       } else {
           response.put("status", "error");
           response.put("message", "Caso no encontrado");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
       }
   } catch (Exception e) {
       response.put("status", "error");
       response.put("message", "Error interno: " + e.getMessage());
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
   }
}
    
    
    @PostMapping("/TipoCaso/guardarR")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> guardarTipoCasoR(@RequestBody Ctl_TipoCasos nuevoCaso) {
        Map<String, Object> response = new HashMap<>();
        try {
            nuevoCaso.setIdTipoCasos(0); // Asegura que se cree un nuevo registro
            servicio.guardar(nuevoCaso);

            response.put("status", "success");
            response.put("message", "Registro agregado correctamente");
            response.put("caso", nuevoCaso);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error interno: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }






	
	
	
}
