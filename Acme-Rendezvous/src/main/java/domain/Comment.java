
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {

	//Atributo
	private Date				moment;
	private String				text;
	private String				picture;

	//Atributos relacionales
	private User				user;
	private Comment				parentComment;
	private Collection<Comment>	subComments;


	//Constructor
	public Comment() {
		super();
	}

	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	@NotBlank
	public String getText() {
		return this.text;
	}

	public void setText(final String text) {
		this.text = text;
	}

	@URL
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(final String picture) {
		this.picture = picture;
	}

	@ManyToOne(optional = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(optional = true)
	public Comment getParentComment() {
		return this.parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	@OneToMany(mappedBy = "parentComment")
	public Collection<Comment> getSubComments() {
		return this.subComments;
	}

	public void setSubComments(Collection<Comment> subComments) {
		this.subComments = subComments;
	}

}
