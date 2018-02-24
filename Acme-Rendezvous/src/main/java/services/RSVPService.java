package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.RSVP;
import repositories.RSVPRepository;

@Service
@Transactional
public class RSVPService {
	
	// Managed repository -----------------------------------------------------
	@Autowired
	private RSVPRepository	rsvpRepository;

	// Supporting services --------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	public RSVPService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public RSVP create() {
		RSVP result;

		result = new RSVP();

		return result;
	}

	public Collection<RSVP> findAll() {
		Collection<RSVP> result;
		Assert.notNull(this.rsvpRepository);
		result = this.rsvpRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public RSVP findOne(int rsvpId) {
		RSVP result;
		result = this.rsvpRepository.findOne(rsvpId);
		return result;
	}

	public RSVP save(RSVP rsvp) {
		assert rsvp != null;
		RSVP result;

		result = rsvpRepository.save(rsvp);
		
		return result;
	}

	public void delete(RSVP rsvp) {
		assert rsvp != null;
		assert rsvp.getId() != 0;
		this.rsvpRepository.delete(rsvp);
	}


}
