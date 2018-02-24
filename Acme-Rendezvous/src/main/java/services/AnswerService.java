
package services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AnswerRepository;
import domain.Answer;
import domain.Question;

@Service
@Transactional
public class AnswerService {

	// Managed repository -----------------------------------------------------
	@Autowired
	private AnswerRepository	answerRepository;


	// Suporting repository --------------------------------------------------

	// Constructors -----------------------------------------------------------
	public AnswerService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Answer create() {
		Answer result;

		String text;
		Question question;

		result = new Answer();

		text = new String();
		question = new Question();

		result.setText(text);
		result.setQuestion(question);

		return result;
	}

	public Collection<Answer> findAll() {
		Collection<Answer> result;
		result = this.answerRepository.findAll();
		Assert.notNull(result);
		return result;
	}
	public Answer findOne(final int answerId) {
		Answer result;
		result = this.answerRepository.findOne(answerId);
		Assert.notNull(result);
		return result;
	}

	public Answer save(final Answer answer) {
		Assert.notNull(answer);
		Answer result;
		result = this.answerRepository.save(answer);
		Assert.notNull(result);
		return result;
	}

	public void delete(final Answer answer) {
		Assert.notNull(answer);
		List<Answer> all, deleted;
		all = this.answerRepository.findAll();
		Assert.isTrue(all.contains(answer));
		this.answerRepository.delete(answer);
		deleted = this.answerRepository.findAll();
		Assert.isTrue(!deleted.contains(answer));
	}

	//Other business methods

	public Collection<Answer> getAnswerUserForRendezvous(int userId, int rendezvousId) {
		Collection<Answer> result;

		result = this.answerRepository.findAll();

		return result;
	}

}
