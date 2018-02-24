
package services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.QuestionRepository;
import domain.Question;
import domain.Rendezvous;

@Service
@Transactional
public class QuestionService {

	// Managed repository -----------------------------------------------------
	@Autowired
	private QuestionRepository	questionRepository;


	// Suporting repository --------------------------------------------------

	// Constructors -----------------------------------------------------------
	public QuestionService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Question create() {
		Question result;

		String question;
		Rendezvous rendezvous;

		result = new Question();

		question = new String();
		rendezvous = new Rendezvous();

		result.setQuestion(question);
		result.setRendezvous(rendezvous);

		return result;
	}

	public Collection<Question> findAll() {
		Collection<Question> result;
		result = this.questionRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public Question findOne(final int questionId) {
		Question result;
		result = this.questionRepository.findOne(questionId);
		Assert.notNull(result);
		return result;
	}

	public Question save(final Question question) {
		Assert.notNull(question);
		Question result;
		result = this.questionRepository.save(question);
		Assert.notNull(result);
		return result;
	}

	public void delete(final Question question) {
		Assert.notNull(question);
		List<Question> all, deleted;
		all = this.questionRepository.findAll();
		Assert.isTrue(all.contains(question));
		this.questionRepository.delete(question);
		deleted = this.questionRepository.findAll();
		Assert.isTrue(!deleted.contains(question));
	}

	//Other business methods
}
