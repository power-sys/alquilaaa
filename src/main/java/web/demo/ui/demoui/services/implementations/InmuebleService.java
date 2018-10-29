package web.demo.ui.demoui.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.demo.ui.demoui.domain.Address;
import web.demo.ui.demoui.domain.Detail;
import web.demo.ui.demoui.domain.PlaceType;
import web.demo.ui.demoui.domain.Property;
import web.demo.ui.demoui.dtos.InmuebleDTO;
import web.demo.ui.demoui.repositories.PlacesRepository;
import web.demo.ui.demoui.services.InmuebleServiceInterface;

/**
 *
 * @author Amadeo F. Garcia
 * userGit{AmadeoO}
 * emailGit{amadeo.fgarcia@gmail.com}
 */

@Service
public class InmuebleService implements InmuebleServiceInterface{

	@Autowired
	private PlacesRepository propertyRepository;

	@Override
	public boolean insertInmueble(InmuebleDTO inmueble) {
		Property p = new Property();
		Address a = new Address();
		a.setNumber(inmueble.getDireccion());
		p.setPrice(inmueble.getPrecio());
		Detail d = new Detail();
		d.setName(inmueble.getDetallesInmueble());
		p.getDetails().add(d);
		Detail d2 = new Detail();
		d2.setName(inmueble.getOtrosDetalles());
		p.getDetails().add(d2);
		p.setAdress(a);
		p.setType(PlaceType.DEPARMENT);
		p.setDescription(inmueble.getDetallesLegales());
		this.propertyRepository.save(p);
		return true;
	}

}
