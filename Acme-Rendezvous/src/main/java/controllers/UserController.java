package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController{

	@Autowired
	private UserService userService;
	
	//Constructor
	public UserController(){
		super();
	}
	
	//List ---------------------------
	//TODO: Hay que hacer este metodo
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView result;
		
		result = new ModelAndView("user/list");
		
		return result;
	}
}
