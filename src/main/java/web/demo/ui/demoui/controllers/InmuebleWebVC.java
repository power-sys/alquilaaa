package web.demo.ui.demoui.controllers;

import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.demo.ui.demoui.domain.Property;
import web.demo.ui.demoui.dtos.ImageDTO;
import web.demo.ui.demoui.dtos.InmuebleDTO;
import web.demo.ui.demoui.services.StorageService;
import web.demo.ui.demoui.services.implementations.InmuebleWhitImageService;

@Controller
public class InmuebleWebVC {

	private InmuebleWhitImageService inmuebleService;
	
	private StorageService image;

	public InmuebleWebVC(InmuebleWhitImageService service, StorageService image) {
		this.inmuebleService = service;
		this.image = image;
	}

	@RequestMapping(value = "/cargarInmueble", method = RequestMethod.GET)
	public String cargarInmuebleForm(Model model) {
		model.addAttribute("inmueble", new InmuebleDTO());
		return "form3";
	}
	
	@PostMapping("/cargarInmueble")
	public String altaInmueble(@ModelAttribute ImageDTO imageDTO) {
		imageDTO.setPath(this.image.store(imageDTO.getImage()));
		this.inmuebleService.insertInmueble(imageDTO);
		return "redirect:/";
	}

	@GetMapping(value = "/")
	public String home(Model model) {
		List<Property> ps = this.inmuebleService.findAll();
		model.addAttribute("inmueble", ps);
		return "home1";
	}
	
	
}
