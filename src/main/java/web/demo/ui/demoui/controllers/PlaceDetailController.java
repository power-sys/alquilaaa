package web.demo.ui.demoui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import web.demo.ui.demoui.services.PlaceDetailService;

@Controller
@RequestMapping("/property/")
public class PlaceDetailController {
	
	private PlaceDetailService placeDetail;
	
	
	public PlaceDetailController(PlaceDetailService placeDetail) {
		this.placeDetail = placeDetail;
	}
	
	@GetMapping("/{id}")
	public String place(@PathVariable Long id, Model model) {
		model.addAttribute("property", this.placeDetail.get(id));
		return "propertyDetails";
	}
	
	@GetMapping("/add")
	public String place(Model model) {
		return "form3";
	}
}
