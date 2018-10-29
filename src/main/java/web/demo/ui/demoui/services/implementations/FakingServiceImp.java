package web.demo.ui.demoui.services.implementations;

import org.springframework.stereotype.Service;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import web.demo.ui.demoui.services.FakingService;

@Service
public class FakingServiceImp implements FakingService {

	@Override
	public Person getPersonFaker() {
		return Fairy.create().person();
	}

	@Override
	public Fairy getFaker() {
		return Fairy.create();
	}

}
