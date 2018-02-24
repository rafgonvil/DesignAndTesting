package controllers.all;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Rendezvous;
import services.ActorService;
import services.RendezvousService;

@Controller
@RequestMapping("/rendezvous")
public class RendezvousController extends AbstractController{
	
	// Supporting services ----------------------------------------------------
	
	@Autowired
	private RendezvousService rendezvousService;
	
	
	public RendezvousController() {
		super();
	}

	// List -----------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Rendezvous> rendezvouses;
		
		rendezvouses = rendezvousService.findAll();

		result = new ModelAndView("rendezvous/list");
		result.addObject("requestURI", "rendezvous/list.do");
		result.addObject("rendezvouses", rendezvouses);

		return result;
	}

}
