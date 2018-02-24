package controllers.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Rendezvous;
import domain.User;
import forms.RendezvousForm;
import services.RendezvousService;

@Controller
@RequestMapping("/rendezvous/user")
public class RendezvousUserController extends AbstractController{
	
	@Autowired
	private RendezvousService rendezvousService;
	
	
	//Controller---------------------------------------------------
	public RendezvousUserController(){
		super();
	}
	
	//Create-------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res = new ModelAndView("rendezvous/user/create");
		RendezvousForm rendezvousForm = new RendezvousForm();
		
		res.addObject("rendezvousForm", rendezvousForm);
		res.addObject("action", "rendezvous/user/create.do");
		
		return res;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView saveCreate(@Valid RendezvousForm rendezvousForm, BindingResult binding) {
		
		ModelAndView res = new ModelAndView("rendezvous/user/create");
		
		if (binding.hasErrors()) {
			res.addObject("rendezvousForm", rendezvousForm);
			res.addObject("action", "rendezvous/user/create.do");
		} else
			try {
				Rendezvous rendezvous = rendezvousService.reconstruct(rendezvousForm);
				rendezvousService.save(rendezvous);
				res = new ModelAndView("redirect:/rendezvous/list.do");
			} catch (Throwable oops) {
				res.addObject("rendezvousForm", rendezvousForm);
				res.addObject("action", "rendezvous/user/create.do");
				res.addObject("message", "rendezvous.commit.error");
			}
		return res;
	}

}
