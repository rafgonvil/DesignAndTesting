package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Actor;

@Service
@Transactional
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;


	// Suporting repository --------------------------------------------------

	// Constructors -----------------------------------------------------------
	public ActorService() {
		super();
	}
	// Simple CRUD methods ----------------------------------------------------

	public Collection<Actor> findAll() {
		Collection<Actor> result;
		Assert.notNull(this.actorRepository);
		result = this.actorRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public Actor findOne(final int actorId) {
		Actor result;
		result = this.actorRepository.findOne(actorId);
		return result;
	}

	public Actor save(final Actor actor) {
		assert actor != null;
		Actor result;
		result = this.actorRepository.save(actor);
		return result;
	}

	public void delete(final Actor actor) {
		assert actor != null;
		assert actor.getId() != 0;
		this.actorRepository.delete(actor);
	}

	// Other business methods -------------------------------------------------
	
	public Actor findByPrincipal(){
		Actor result;
		UserAccount userAccount;
		
		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}
	
	public Actor findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Actor result;

		result = actorRepository.findByUserAccountId(userAccount.getId());		

		return result;
	}

}
