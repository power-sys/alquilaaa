package web.demo.ui.demoui.dtos;

import web.demo.ui.demoui.dtos.DetailDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PropertyDTO {
	private String id;
	private String placeType;
	private String rooms;
	private String price;
	private String aStreet;
	private String aNumber;
	private List<DetailDTO> aDetails = new ArrayList<>();
	private List<DetailDTO> pDetails = new ArrayList<>();
	private List<String> photos;
	private String description;
	private final Set<DetailDTO> legals= new HashSet<>();
	private String published;
	
	public PropertyDTO() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addDetail(String name, String value) {
		this.legals.add(new DetailDTO(name, value));
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getaStreet() {
		return aStreet;
	}

	public void setaStreet(String aStreet) {
		this.aStreet = aStreet;
	}

	public String getaNumber() {
		return aNumber;
	}

	public void setaNumber(String aNumber) {
		this.aNumber = aNumber;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<DetailDTO> getLegals() {
		return legals;
	}
	
	public List<DetailDTO> getaDetails() {
		return aDetails;
	}

	public void setaDetails(List<DetailDTO> aDeatails) {
		this.aDetails = aDeatails;
	}

	public List<DetailDTO> getpDetails() {
		return pDetails;
	}

	public void setpDetails(List<DetailDTO> pDetails) {
		this.pDetails = pDetails;
	}
	
	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}	
}
