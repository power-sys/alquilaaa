package web.demo.ui.demoui.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "place")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Address adress;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;

	private String description;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Detail> details;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Detail> legals;

	private Integer price;

	@Enumerated(EnumType.STRING)
	private PlaceType type;

	@ElementCollection
	private List<String> images = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public List<Detail> getLegals() {
		return legals;
	}

	public void setLegals(List<Detail> legals) {
		this.legals = legals;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public PlaceType getType() {
		return type;
	}

	public void setType(PlaceType type) {
		this.type = type;
	}

	public List<String> getImages() {
		return images;
	}

	public void addImage(String imageUrl) {
		this.images.add(imageUrl);
	}
	
	
}
