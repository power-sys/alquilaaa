package web.demo.ui.demoui.services.implementations;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import io.codearte.jfairy.producer.person.Person;
import web.demo.ui.demoui.exception.NotImplementedYetException;
import web.demo.ui.demoui.services.FakingService;
import web.demo.ui.demoui.services.PersonService;

@Service("test")
public class PersonServiceImp implements PersonService {
	
	private FakingService dataFaker;
	
	public PersonServiceImp(FakingService dataFaker) {
		this.dataFaker = dataFaker;
	}

	@Override
	public Person getAnInstance() throws NotImplementedYetException {
		throw new NotImplementedYetException();
	}

	@Override
	public List<Person> getManyInstances() {
		return new ArrayList<>();
	}

}
