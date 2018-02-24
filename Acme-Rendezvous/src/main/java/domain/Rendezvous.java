
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Rendezvous extends DomainEntity {

	//Atributos
	private String						name;
	private String						description;
	private Date						momentRendezvous;
	private String						picture;
	private Double						latitude;
	private Double						longitude;
	private Boolean						adultOnly;
	private Boolean						finalMode;
	private Boolean						deleted;

	//Atributos relacionales
	private Collection<RSVP>			rsvps;
	private Collection<Announcement>	announcements;
	private Collection<Comment>			comments;
	private Collection<Rendezvous>		subRendezvouses;
	private Collection<Question>		questions;


	//Constructor
	public Rendezvous() {
		super();
	}

	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@NotBlank
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Date getMomentRendezvous() {
		return this.momentRendezvous;
	}
	public void setMomentRendezvous(final Date momentRendezvous) {
		this.momentRendezvous = momentRendezvous;
	}

	@URL
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(final String picture) {
		this.picture = picture;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	public Boolean getAdultOnly() {
		return this.adultOnly;
	}

	public void setAdultOnly(final Boolean adultOnly) {
		this.adultOnly = adultOnly;
	}

	public Boolean getFinalMode() {
		return this.finalMode;
	}

	public void setFinalMode(final Boolean finalMode) {
		this.finalMode = finalMode;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(final Boolean deleted) {
		this.deleted = deleted;
	}

	@OneToMany()
	public Collection<RSVP> getRsvps() {
		return this.rsvps;
	}

	public void setRsvps(Collection<RSVP> rsvps) {
		this.rsvps = rsvps;
	}

	@OneToMany()
	public Collection<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(Collection<Announcement> announcements) {
		this.announcements = announcements;
	}

	@OneToMany()
	public Collection<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany()
	public Collection<Rendezvous> getSubRendezvouses() {
		return this.subRendezvouses;
	}

	public void setSubRendezvouses(Collection<Rendezvous> subRendezvouses) {
		this.subRendezvouses = subRendezvouses;
	}

	@OneToMany()
	public Collection<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

}
