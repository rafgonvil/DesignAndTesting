package forms;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

public class RendezvousForm {
	
	//Atributos
	private String	name;
	private String	description;
	private Date	momentRendezvous;
	private String	picture;
	private Double	latitude;
	private Double	longitude;
	private Boolean	adultOnly;

	//Constructor
	public RendezvousForm(){
		super();
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	public Date getMomentRendezvous() {
		return momentRendezvous;
	}
	public void setMomentRendezvous(Date momentRendezvous) {
		this.momentRendezvous = momentRendezvous;
	}

	@URL
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	@NotNull
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@NotNull
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@NotNull
	public Boolean getAdultOnly() {
		return adultOnly;
	}
	public void setAdultOnly(Boolean adultOnly) {
		this.adultOnly = adultOnly;
	}
	
	
}
