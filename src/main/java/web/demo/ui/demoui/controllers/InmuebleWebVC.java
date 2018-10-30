package web.demo.ui.demoui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.demo.ui.demoui.dtos.InmuebleDTO;
//import com.powersys.Alquila.models.Inmueble;
import web.demo.ui.demoui.services.implementations.InmuebleService;

@Controller
public class InmuebleWebVC {

	private InmuebleService inmuebleService;

	public InmuebleWebVC(InmuebleService service) {
		this.inmuebleService = service;
	}

	@RequestMapping(value = "/cargarInmueble", method = RequestMethod.GET)
	public String cargarInmuebleForm(Model model) {
		model.addAttribute("inmueble", new InmuebleDTO());
		return "cargarInmueble";
	}

	@GetMapping(value = "/listar/inmuebles")
	public String listarInmueble(Model model) {
		model.addAttribute("inmueble", this.inmuebleService.findAll());
		return "listarInmuebles";
	}

	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("inmueble", this.inmuebleService.findAll());
		return "home1";
	}
}
