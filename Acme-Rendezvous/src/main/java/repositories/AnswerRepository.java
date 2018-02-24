
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Answer;
import domain.RSVP;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	/*@Query("select u.RSVP from User where u.id = ?1 ")
	Collection<RSVP> findRSVPFromUser(int userId);*/

	@Query("select r from RSVP r where r.rendezvous.id= ?1 ")
	Collection<RSVP> findRSVPFromRendezvous(int rendezvousId);
}
