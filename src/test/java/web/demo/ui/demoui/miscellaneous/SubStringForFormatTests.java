package web.demo.ui.demoui.miscellaneous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.UUID;

public class SubStringForFormatTests {
	
	private String theString;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void indexOfTest() {
		this.theString = "descarga.jpg";
		assertEquals(8, this.theString.indexOf('.'));
		assertEquals(".jpg", this.theString.substring(8, this.theString.length()));
	}
	
	@Test
	public void uuidTest() {
		this.theString = "descarga.jpg";
		String s = UUID.randomUUID().toString();
		String d = s.concat(this.theString.substring(this.theString.indexOf('.'), this.theString.length()));
		assertEquals("sewew", d);
	}
	
	@Test
	public void createName() {
		
	}
}
