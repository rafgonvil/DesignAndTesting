
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import repositories.UserRepository;
import domain.Announcement;
import domain.Answer;
import domain.Comment;
import domain.Rendezvous;
import domain.User;

@Service
@Transactional
public class UserService {

	//Managed repository -------------------------------------
	@Autowired
	private UserRepository	userRepository;

	@Autowired
	private Validator		validator;


	//Supporting services --------------------------------

	//Constructor
	public UserService() {
		super();
	}

	//Simple CRUD methods
	public User create() {
		User result;

		String name;
		String surnames;
		String postalAddress;
		String phoneNumber;
		String email;
		Date birthDate;
		Collection<Comment> comments;
		Collection<Announcement> announcements;
		Collection<Rendezvous> rendezvousesCreated;
		Collection<Rendezvous> rendezvousesAttendant;
		Collection<Answer> answers;

		result = new User();

		name = new String();
		surnames = new String();
		postalAddress = new String();
		phoneNumber = new String();
		email = new String();
		birthDate = new Date();
		comments = new ArrayList<Comment>();
		announcements = new ArrayList<Announcement>();
		rendezvousesCreated = new ArrayList<Rendezvous>();
		rendezvousesAttendant = new ArrayList<Rendezvous>();
		answers = new ArrayList<Answer>();

		result.setName(name);
		result.setSurnames(surnames);
		result.setPostalAddress(postalAddress);
		result.setPhoneNumber(phoneNumber);
		result.setBirthDate(birthDate);
		result.setComments(comments);
		result.setAnnouncements(announcements);
		result.setRendezvousesCreated(rendezvousesCreated);
	
		return result;
	}

	public Collection<User> findAll() {
		Collection<User> result;
		result = this.userRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public User findOne(int userId) {
		User result;
		result = this.userRepository.findOne(userId);
		Assert.notNull(result);
		return result;
	}

	public User save(User user) {
		Assert.notNull(user);
		User result;
		result = this.userRepository.save(user);
		Assert.notNull(result);
		return result;
	}

	public void delete(User user) {
		Assert.notNull(user);
		List<User> all, deleted;
		all = this.userRepository.findAll();
		Assert.isTrue(all.contains(user));
		this.userRepository.delete(user);
		deleted = this.userRepository.findAll();
		Assert.isTrue(!deleted.contains(user));
	}

	//Other business methods

	public User reconstruct(User user, BindingResult binding) {
		User result;

		if (user.getId() == 0)
			result = user;
		else {
			result = this.userRepository.findOne(user.getId());

			result.setName(user.getName());
			result.setSurnames(user.getSurnames());
			result.setPostalAddress(user.getPostalAddress());
			result.setPhoneNumber(user.getPhoneNumber());
			result.setEmail(user.getEmail());
			result.setBirthDate(user.getBirthDate());
		}
		this.validator.validate(result, binding);

		return result;

	}
}
