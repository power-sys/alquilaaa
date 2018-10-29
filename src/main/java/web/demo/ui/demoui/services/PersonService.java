package web.demo.ui.demoui.services;

import java.util.List;

import io.codearte.jfairy.producer.person.Person;
import web.demo.ui.demoui.exception.NotImplementedYetException;


public interface PersonService {
	
	public Person getAnInstance() throws NotImplementedYetException;
	
	public List<Person> getManyInstances();
	
}
