
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class User extends Actor {

	//Atributos

	//Atributos relacionales
	private Collection<Comment>			comments;
	private Collection<Announcement>	announcements;
	private Collection<Rendezvous>		rendezvousesCreated;
	private Collection<RSVP>			rsvps;


	//Constructor
	public User() {
		super();
	}

	@OneToMany()
	public Collection<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany()
	public Collection<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(Collection<Announcement> announcements) {
		this.announcements = announcements;
	}

	@OneToMany()
	public Collection<Rendezvous> getRendezvousesCreated() {
		return this.rendezvousesCreated;
	}

	public void setRendezvousesCreated(Collection<Rendezvous> rendezvousesCreated) {
		this.rendezvousesCreated = rendezvousesCreated;
	}

	@OneToMany()
	public Collection<RSVP> getRsvps() {
		return this.rsvps;
	}

	public void setRsvps(Collection<RSVP> rsvps) {
		this.rsvps = rsvps;
	}

}
