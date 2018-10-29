package web.demo.ui.demoui.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import web.demo.ui.demoui.controllers.PlaceDetailController;
import web.demo.ui.demoui.dtos.PropertyDTO;
import web.demo.ui.demoui.services.PlaceDetailService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(PlaceDetailController.class)
public class PlaceDetailControllerTests {
	
	private PropertyDTO placeDetailDto;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PlaceDetailService placeService;
	
	@Before
	public void setUp() {
		String[] photos = {
				"http://lorempixel.com/400/200/city/1/",
				"http://lorempixel.com/400/200/city/2/", 
				"http://lorempixel.com/400/200/city/3/"};
		
		this.placeDetailDto = new PropertyDTO();
				placeDetailDto.setaStreet("Av. Siempre Viva");
				placeDetailDto.setaNumber("666");
				placeDetailDto.setDescription("Mi Nice Properti");
				placeDetailDto.setPhotos(Arrays.asList(photos));
				placeDetailDto.setPlaceType("Departamento");
				placeDetailDto.setPrice("23134");
				placeDetailDto.setRooms("3");
				placeDetailDto.addDetail("contract", "yes");
				placeDetailDto.addDetail("guarantor", "yes");
				placeDetailDto.addDetail("initialDeposit", "yes");
				placeDetailDto.addDetail("contractExpenses", "yes");
	}
	
	@Test
	public void getPlaceDetailTest() throws Exception {
		
		given(placeService.get(1L)).willReturn(this.placeDetailDto);
		
		this.mvc.perform(get("/place/1").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk());
	}
	
	@Test
	public void getPlaceDetailBaseTitleTest() throws Exception {
		
		given(placeService.get(1L)).willReturn(this.placeDetailDto);
		
		this.mvc.perform(get("/place/1").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("BASE")));
	}
}
