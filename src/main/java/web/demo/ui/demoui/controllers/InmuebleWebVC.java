package com.powersys.Alquila.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.powersys.Alquila.DTOs.InmuebleDTO;
//import com.powersys.Alquila.models.Inmueble;
import com.powersys.Alquila.services.implementations.InmuebleService;

@Controller
public class InmuebleWebVC {
	
	@Autowired
	private InmuebleService inmuebleService;
	
	 @RequestMapping(value="/cargarInmueble", method=RequestMethod.GET)
	    public String cargarInmuebleForm(Model model){
	        model.addAttribute("inmueble", new InmuebleDTO());
	        return "cargarInmueble";
	    }
	 
	 
	 @GetMapping(value="/listar/inmuebles")
	 public String listarInmueble(Model model) {
		 model.addAttribute("inmueble", this.inmuebleService.findAll());
		 return "listarInmueble";
	 }
}
