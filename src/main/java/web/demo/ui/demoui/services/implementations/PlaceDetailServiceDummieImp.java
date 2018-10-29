//package web.demo.ui.demoui.services.implementations;
//
//import web.demo.ui.demoui.domain.PlaceType;
//
//import org.springframework.stereotype.Service;
//
//import web.demo.ui.demoui.dtos.PlaceDetailDTO;
//import web.demo.ui.demoui.services.FakingService;
//import web.demo.ui.demoui.services.PlaceDetailService;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//@Service("dummie")
//public class PlaceDetailServiceDummieImp implements PlaceDetailService {
//	
//	@Autowired
//	private FakingService fake;
//
//	@Override
//	public PlaceDetailDTO get(Long id) {
//		String[] photos = {
//				"https://via.placeholder.com/256",
//				"https://via.placeholder.com/256", 
//				"https://via.placeholder.com/256"};
//		return PlaceDetailDTO.builder()
//				.address("Av. Siempre Viva 666")
//				.description(fake.getFaker().textProducer().loremIpsum())
//				.photos(Arrays.asList(photos))
//				.placeType(PlaceType.DEPARMENT)
//				.price("23134")
//				.roomsNumber("3")
//				.petsAlowed(true)
//				.kidsAlowed(true)
//				.garage(true)
//				.balcony(true)
//				.aditionalBathroom(false)
//				.yard(false)
//				.contract(true)
//				.guarantor(false)
//				.initialDeposit(true)
//				.contractExpenses(true)
//				.build();
//	}
//
//}
