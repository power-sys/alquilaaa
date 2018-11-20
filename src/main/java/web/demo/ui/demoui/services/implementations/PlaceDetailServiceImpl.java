package web.demo.ui.demoui.services.implementations;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import web.demo.ui.demoui.domain.Detail;
import web.demo.ui.demoui.domain.PlaceType;
import web.demo.ui.demoui.domain.Property;
import web.demo.ui.demoui.dtos.DetailDTO;
import web.demo.ui.demoui.dtos.PropertyDTO;
import web.demo.ui.demoui.repositories.PlacesRepository;
import web.demo.ui.demoui.services.PlaceDetailService;

@Primary
@Service
public class PlaceDetailServiceImpl implements PlaceDetailService {

	@Autowired
	private PlacesRepository placesRepo;
	
	@Override
	public PropertyDTO get(Long id) {
		
		Property p = getOne(id);
		
		String pt = (p.getType().equals(PlaceType.DEPARMENT))?"Departamento":"Casa";
		
		String[] photos = {
				"https://via.placeholder.com/256",
				"https://via.placeholder.com/256", 
				"https://via.placeholder.com/256"};
		PropertyDTO pd = new PropertyDTO();
				 pd.setId(p.getId().toString());
				 pd.setaStreet(p.getAdress().getStreet());
				 pd.setaNumber(p.getAdress().getNumber());
				 pd.setDescription(p.getDescription());
				 pd.setPhotos(Arrays.asList(photos));
				 pd.setPlaceType(pt);
				 pd.setPrice(Integer.toString(p.getPrice()));
				 pd.setRooms("3");
				 pd.getaDetails().add(new DetailDTO("Edificio", "Constelación"));
				 pd.getaDetails().add(new DetailDTO("Piso", "6"));
				 pd.getaDetails().add(new DetailDTO("Dto", "B"));
				 pd.getaDetails().add(new DetailDTO("Otros", "A 200 mts de la xxx, frente a la xxx de xxx."));
//				 pd.getpDetails().add(new DetailDTO("Baño", "En la suite principal"));
//				 pd.getpDetails().add(new DetailDTO("Garaje", "Sin techo"));
//				 pd.getpDetails().add(new DetailDTO("Patio", "Con pileta"));
//				 pd.getpDetails().add(new DetailDTO("Garage", ""));
				 
				for(Detail d : p.getDetails()) {
						DetailDTO dto = new DetailDTO(d.getName(), d.getValue());
						pd.getpDetails().add(dto);
				}
				
				for(Detail d : p.getLegals()) {
					pd.addDetail(d.getName(), d.getValue());
				}
				
				pd.setPublished(p.getPublished().format(DateTimeFormatter.ISO_DATE));
				
				return pd;
	}
	
	private Property getOne(Long id) {
		return placesRepo.findById(id);
	}

}
