
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class RSVP extends DomainEntity {

	//Atributos

	//Atributos relacionales
	private Collection<Answer>	answers;
	private Rendezvous			rendezvous;


	@OneToMany()
	public Collection<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	@ManyToOne(optional = false)
	public Rendezvous getRendezvous() {
		return this.rendezvous;
	}

	public void setRendezvous(Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}

}
