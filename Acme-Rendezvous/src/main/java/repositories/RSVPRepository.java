package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.RSVP;
import domain.Rendezvous;

@Repository
public interface RSVPRepository  extends JpaRepository<RSVP, Integer>{

}
