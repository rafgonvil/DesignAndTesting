
package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.CommentRepository;
import domain.Comment;
import domain.User;

@Service
@Transactional
public class CommentService {

	// Managed repository -----------------------------------------------------
	@Autowired
	private CommentRepository	commentRepository;

	// Supporting services --------------------------------------------------
	@Autowired
	private ActorService		actorService;


	// Constructors -----------------------------------------------------------
	public CommentService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Comment create() {
		Comment res;

		res = new Comment();

		res.setMoment(new Date(System.currentTimeMillis()));
		res.setUser((User) this.actorService.findByPrincipal());

		return res;
	}

	public Collection<Comment> findAll() {

		Collection<Comment> res;

		res = this.commentRepository.findAll();
		Assert.notNull(res);

		return res;

	}

	public Comment findOne(int commentId) {

		Comment res;

		Assert.isTrue(this.commentRepository.exists(commentId));
		res = this.commentRepository.findOne(commentId);

		return res;

	}

	public Comment save(Comment comment) {

		Assert.notNull(comment);
		Comment res;

		res = this.commentRepository.save(comment);
		Assert.notNull(res);

		return res;

	}

	public void delete(Comment comment) {

		Assert.notNull(comment);
		Assert.isTrue(comment.getId() != 0);
		Assert.isTrue(this.commentRepository.exists(comment.getId()));
		this.commentRepository.delete(comment);

	}

}
