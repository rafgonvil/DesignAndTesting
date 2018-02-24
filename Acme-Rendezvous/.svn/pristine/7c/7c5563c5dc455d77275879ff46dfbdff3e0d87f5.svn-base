
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.RendezvousRepository;
import domain.Announcement;
import domain.Comment;
import domain.Question;
import domain.Rendezvous;
import domain.User;
import forms.RendezvousForm;

@Service
@Transactional
public class RendezvousService {

	// Managed repository -----------------------------------------------------
	@Autowired
	private RendezvousRepository	rendezvousRepository;

	// Supporting services --------------------------------------------------
	@Autowired
	private ActorService			actorService;


	// Constructors -----------------------------------------------------------
	public RendezvousService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Rendezvous create() {
		Rendezvous result;

		String name;
		String description;
		Date momentRendezvous;
		String picture;
		Double latitude;
		Double longitude;
		Boolean adultOnly;
		Boolean finalMode;
		Boolean deleted;
		User creator;
		Collection<User> attendants;
		Collection<Announcement> announcements;
		Collection<Comment> comments;
		Collection<Rendezvous> subRendezvouses;
		Collection<Question> questions;

		result = new Rendezvous();
		name = new String();
		description = new String();
		momentRendezvous = new Date();
		picture = new String();
		latitude = 0.0;
		longitude = 0.0;
		adultOnly = false;
		finalMode = false;
		deleted = false;
		creator = (User) this.actorService.findByPrincipal();
		attendants = new ArrayList<User>();
		attendants.add(creator);
		announcements = new ArrayList<Announcement>();
		comments = new ArrayList<Comment>();
		subRendezvouses = new ArrayList<Rendezvous>();
		questions = new ArrayList<Question>();

		result.setName(name);
		result.setDescription(description);
		result.setMomentRendezvous(momentRendezvous);
		result.setPicture(picture);
		result.setLatitude(latitude);
		result.setLongitude(longitude);
		result.setAdultOnly(adultOnly);
		result.setFinalMode(finalMode);
		result.setDeleted(deleted);
		result.setCreator(creator);
		result.setAttendants(attendants);
		result.setAnnouncements(announcements);
		result.setComments(comments);
		result.setSubRendezvouses(subRendezvouses);
		result.setQuestions(questions);

		return result;
	}

	public Collection<Rendezvous> findAll() {
		Collection<Rendezvous> result;
		Assert.notNull(this.rendezvousRepository);
		result = this.rendezvousRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public Rendezvous findOne(int rendezvousId) {
		Rendezvous result;
		result = this.rendezvousRepository.findOne(rendezvousId);
		return result;
	}

	public Rendezvous save(Rendezvous rendezvous) {
		assert rendezvous != null;
		Rendezvous result;

		result = this.rendezvousRepository.save(rendezvous);
		return result;
	}

	public void delete(Rendezvous rendezvous) {
		assert rendezvous != null;
		assert rendezvous.getId() != 0;
		this.rendezvousRepository.delete(rendezvous);
	}

	//Other methods-----------------------------------------------------------------------
	public RendezvousForm construct(Rendezvous rendezvous) {
		RendezvousForm res = new RendezvousForm();

		res.setName(rendezvous.getName());
		res.setDescription(rendezvous.getDescription());
		res.setMomentRendezvous(rendezvous.getMomentRendezvous());
		res.setPicture(rendezvous.getPicture());
		res.setLatitude(rendezvous.getLatitude());
		res.setLongitude(rendezvous.getLongitude());
		res.setAdultOnly(rendezvous.getAdultOnly());

		return res;
	}

	public Rendezvous reconstruct(RendezvousForm rendezvousForm) {
		Rendezvous res;

		res = this.create();

		res.setName(rendezvousForm.getName());
		res.setDescription(rendezvousForm.getDescription());
		res.setMomentRendezvous(rendezvousForm.getMomentRendezvous());
		res.setPicture(rendezvousForm.getPicture());
		res.setLatitude(rendezvousForm.getLatitude());
		res.setLongitude(rendezvousForm.getLongitude());
		res.setAdultOnly(rendezvousForm.getAdultOnly());

		return res;
	}

	public Collection<Rendezvous> findRendezvousNotDeleted() {
		return this.rendezvousRepository.findRendezvousNotDeleted();
	}

}
