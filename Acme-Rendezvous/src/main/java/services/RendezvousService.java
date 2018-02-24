
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
import domain.RSVP;
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
	private ActorService actorService;
	
	@Autowired
	private RSVPService rsvpService;
	
	@Autowired
	private UserService userService;


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
		Collection<RSVP> rsvps;
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
		rsvps = new ArrayList<RSVP>();
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
		result.setRsvps(rsvps);
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
		User user;
		Rendezvous result;
		RSVP rsvp;

		result = rendezvousRepository.save(rendezvous);
		user = (User) actorService.findByPrincipal();
		rsvp = rsvpService.create();
		
		rsvp.setRendezvous(result);
		rsvpService.save(rsvp);
		
		user.getRendezvousesCreated().add(result);
		user.getRsvps().add(rsvp);
		userService.save(user);
		
		return result;
	}
	
	public Rendezvous saveToEdit(Rendezvous rendezvous){
		assert rendezvous != null;
		User user;
		Rendezvous result;
		
		user = (User) actorService.findByPrincipal();
		Assert.isTrue(!user.getRendezvousesCreated().contains(rendezvous));
		Assert.isTrue(rendezvous.getFinalMode() == true);
		
		result = rendezvousRepository.save(rendezvous);
		
		return result;
	}
	
	public Rendezvous saveFinal(Rendezvous rendezvous){
		assert rendezvous != null;
		User user;
		Rendezvous result;
		
		user = (User) actorService.findByPrincipal();
		Assert.isTrue(!user.getRendezvousesCreated().contains(rendezvous));
		
		rendezvous.setFinalMode(true);
		result = rendezvousRepository.save(rendezvous);
		
		return result;
	}

	public void deleteByAdmin(Rendezvous rendezvous) {
		assert rendezvous != null;
		assert rendezvous.getId() != 0;
		rendezvousRepository.delete(rendezvous);
	}
	
	public void deleteByUser(Rendezvous rendezvous){
		User user;
		
		user = (User) actorService.findByPrincipal();
		Assert.isTrue(user.getRendezvousesCreated().contains(user));
		
		rendezvous.setDeleted(true);
		save(rendezvous);
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
		res.setRendezvousId(rendezvous.getId());

		return res;
	}

	public Rendezvous reconstruct(RendezvousForm rendezvousForm) {
		Rendezvous res;

		if (rendezvousForm.getRendezvousId() == 0) {
			res = this.create();
		} else {
			res = findOne(rendezvousForm.getRendezvousId());
			res.setName(rendezvousForm.getName());
			res.setDescription(rendezvousForm.getDescription());
			res.setMomentRendezvous(rendezvousForm.getMomentRendezvous());
			res.setPicture(rendezvousForm.getPicture());
			res.setLatitude(rendezvousForm.getLatitude());
			res.setLongitude(rendezvousForm.getLongitude());
			res.setAdultOnly(rendezvousForm.getAdultOnly());
		}

		return res;
	}

	public Collection<Rendezvous> findRendezvousNotDeleted() {
		return this.rendezvousRepository.findRendezvousNotDeleted();
	}

}
