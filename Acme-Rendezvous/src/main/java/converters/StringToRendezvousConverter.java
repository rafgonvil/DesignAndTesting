package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Rendezvous;
import repositories.RendezvousRepository;

@Component
@Transactional
public class StringToRendezvousConverter implements Converter<String, Rendezvous>{ 
	
	@Autowired
	RendezvousRepository rendezvousRepository;

	@Override
	public Rendezvous convert(String text) {
		Rendezvous result;
		int id;
		try {
			id = Integer.valueOf(text);
			result = rendezvousRepository.findOne(id);
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
