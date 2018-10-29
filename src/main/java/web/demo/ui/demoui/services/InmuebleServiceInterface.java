/**
 * 
 */
package web.demo.ui.demoui.services;


import web.demo.ui.demoui.dtos.InmuebleDTO;

import java.util.List;

import web.demo.ui.demoui.domain.Property;

/**
 * @author Amadeo F. Garcia
 * userGit{AmadeoO}
 * emailGit{amadeo.fgarcia@gmail.com}
 */
public interface InmuebleServiceInterface {
	
	public boolean insertInmueble(InmuebleDTO inmueble);
	public List<Property> findAll();

}
