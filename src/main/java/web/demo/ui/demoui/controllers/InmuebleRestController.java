/**
 * 
 */
package web.demo.ui.demoui.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import web.demo.ui.demoui.dtos.InmuebleDTO;
import web.demo.ui.demoui.services.implementations.InmuebleService;


/**
 * @author Amadeo F. Garcia
 * userGit{AmadeoO}
 * email{amadeo.fgarcia@gmail.com}
 */

@Controller
public class InmuebleRestController {
	
	private InmuebleService inmuebleService;
	
	public InmuebleRestController(InmuebleService service) {
		this.inmuebleService = service;
	}
		
	@PostMapping("/api/cargarInmueble")
	public String altaInmueble(@ModelAttribute InmuebleDTO inmuebleDTO, Model model) {
		this.inmuebleService.insertInmueble(inmuebleDTO);
		return "redirect:/";
	}
	
	@GetMapping("/api/mostrarInmuebles")
	public List<InmuebleDTO> getInmuebles(){
		return null;
	}

}
