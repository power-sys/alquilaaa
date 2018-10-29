package web.demo.ui.demoui.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.demo.ui.demoui.domain.Property;

@Repository
public interface PlacesRepository extends CrudRepository<Property, Long> {
	Property findById(Long id);
}
