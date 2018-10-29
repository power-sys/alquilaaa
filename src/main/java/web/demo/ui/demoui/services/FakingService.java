package web.demo.ui.demoui.services;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public interface FakingService {
	
	public Person getPersonFaker();
	
	public Fairy getFaker();

}
