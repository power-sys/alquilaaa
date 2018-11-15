package web.demo.ui.demoui.listeners;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import web.demo.ui.demoui.domain.Address;
import web.demo.ui.demoui.domain.Detail;
import web.demo.ui.demoui.domain.Owner;
import web.demo.ui.demoui.domain.Property;
import web.demo.ui.demoui.domain.PlaceType;
import web.demo.ui.demoui.repositories.PlacesRepository;
import web.demo.ui.demoui.services.FakingService;

@Component
public class DataBaseSeedeListener {
	
	@Autowired
	private PlacesRepository placeRepo;
	
	@Autowired 
	FakingService fakingService;
	
	@EventListener
	public void seeder(ContextRefreshedEvent event) {
		System.out.println("::::::::::::::::::::::::DB SEEDING:::::::::::::::::::::::::");
		
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(2018, Month.NOVEMBER, 3));
		dates.add(LocalDate.of(2018, Month.NOVEMBER, 7));
		dates.add(LocalDate.of(2018, Month.NOVEMBER, 8));
		dates.add(LocalDate.of(2018, Month.NOVEMBER, 12));
		dates.add(LocalDate.of(2018, Month.NOVEMBER, 2));
		dates.add(LocalDate.of(2018, Month.NOVEMBER, 5));
		dates.add(LocalDate.of(2018, Month.OCTOBER, 30));
		dates.add(LocalDate.of(2018, Month.OCTOBER, 21));
		dates.add(LocalDate.of(2018, Month.OCTOBER, 22));
		dates.add(LocalDate.of(2018, Month.OCTOBER, 2));
		dates.add(LocalDate.of(2018, Month.SEPTEMBER, 3));
		dates.add(LocalDate.of(2018, Month.SEPTEMBER, 1));
		dates.add(LocalDate.of(2018, Month.SEPTEMBER, 10));
		dates.add(LocalDate.of(2018, Month.SEPTEMBER, 13));
		dates.add(LocalDate.of(2018, Month.AUGUST, 29));
		dates.add(LocalDate.of(2018, Month.AUGUST, 16));
		dates.add(LocalDate.of(2018, Month.AUGUST, 8));
		dates.add(LocalDate.of(2018, Month.AUGUST, 3));
		dates.add(LocalDate.of(2018, Month.AUGUST, 19));
		dates.add(LocalDate.of(2018, Month.JUNE, 26));
		
		for (int i = 0; i < 20; i++) {
			BaseProducer fake = fakingService.getFaker().baseProducer();
			TextProducer fakeText = fakingService.getFaker().textProducer();
			Person p = fakingService.getPersonFaker();
			
			Address adress = new Address();
			adress.setStreet(fakeText.latinWord(1));
			adress.setNumber(Integer.toString(fake.randomInt(999)));
			
			String firstName = p.getFirstName();
			String lastName = p.getLastName();
			String phone = p.getTelephoneNumber();
			String email = p.getEmail();
			String url = fakingService.getFaker().company().getUrl();
			Owner owner = new Owner();
			owner.setName(firstName);
			owner.setLastName(lastName);
			owner.setPhone(phone);
			owner.setEmail(email);
			owner.setAvatar(url);
			
			List<Detail> details = new ArrayList<>();
			details.add(new Detail());
			details.add(new Detail());
			details.get(0).setName(fakeText.randomString(15));
			details.get(0).setValue(fakeText.randomString(20));
//			details.get(1).setName(fakeText.randomString(10));
//			details.get(1).setValue(fakeText.randomString(20));
			
			List<Detail> legals = new ArrayList<>();
//			legals.add(new Detail());
//			legals.add(new Detail());
//			legals.add(new Detail());
//			legals.get(0).setName(fakeText.latinWord(1));
//			legals.get(0).setValue(fakeText.latinWord(1));
//			legals.get(1).setName(fakeText.latinWord(1));
//			legals.get(1).setValue(fakeText.latinWord(1));
//			legals.get(2).setName(fakeText.latinWord(1));
//			legals.get(2).setValue(fakeText.latinWord(1));
			
			Integer amount = fake.randomBetween(2000, 30000);
			Property entity = new Property();
			entity.setAdress(adress);
			entity.setOwner(owner);
			entity.setDescription(fakeText.loremIpsum().substring(0, 200));
			entity.setDetails(details);
			entity.setLegals(legals);
			entity.setPrice(amount);
			entity.setType((i % 2 == 0)? PlaceType.DEPARMENT : PlaceType.HOUSE);
			entity.addImage(fakeText.latinSentence(10));
			entity.setPublished(dates.get(i));
			placeRepo.save(entity);
		}
		
	}

}
